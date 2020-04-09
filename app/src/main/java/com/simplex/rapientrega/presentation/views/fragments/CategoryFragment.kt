package com.simplex.rapientrega.presentation.views.fragments

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.interfaces.CategoryInterface
import com.simplex.rapientrega.domain.tools.CITY_USER
import com.simplex.rapientrega.domain.tools.STORES
import com.simplex.rapientrega.presentation.presenters.fragments.CategoryPresenter
import com.simplex.rapientrega.presentation.views.adapters.CategoryAdapter
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private const val CODE_LOCATION = 1

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CategoryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment :
    BaseFragment(),
    CategoryInterface.View,
    CategoryAdapter.OnItemClickListener,
    LocationListener,
    View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var dialogLocation: AlertDialog
    private lateinit var dialogCity: AlertDialog
    private lateinit var listEmpty: TextView
    private lateinit var update: ImageView

    private lateinit var presenter: CategoryInterface.Presenter
    private lateinit var locationManager: LocationManager
    private var isSearch: Boolean = true
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private lateinit var cities: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        presenter = CategoryPresenter(this)
        presenter.initial()
        return itemView
    }

    override fun getItemView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance(): CategoryFragment = CategoryFragment()

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(stores: List<StoreEntity>) {
        val fragment: Fragment = StoreFragment()
        val args = Bundle()
        args.putSerializable(STORES, stores as Serializable)
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.add(R.id.frame_layout_main, fragment)
            ?.addToBackStack(null)?.commit()
    }

    override fun initialElements() {
        recyclerView = itemView.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        progressBar = itemView.findViewById(R.id.progress_circular)
        listEmpty = itemView.findViewById(R.id.tvListEmpty)
        update = requireActivity().findViewById(R.id.ivUpdate)
        createDialogLocation()
        createDialogCity()
    }

    override fun initialObjects() {
        cities = resources.getStringArray(R.array.cities).toList()
        locationManager =
            itemView.context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun addListeners() {
        update.setOnClickListener(this)
    }

    override fun havePermissions() {
        if (checkPermission()) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), CODE_LOCATION
            )
            return
        }
        if (!isLocationEnabled()) {
            presenter.showDialogLocation()
            return
        }
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 0, 0f, this
        )

    }

    override fun showDialogLocation() {
        dialogLocation.show()
    }

    override fun hideDialogLocation() {
        dialogLocation.hide()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        when (requestCode) {
            CODE_LOCATION -> {
                when (grantResults[0]) {
                    0 -> presenter.havePermissions()
                }
            }
        }
        presenter.showListEmpty()
    }

    override fun onLocationChanged(location: Location?) {
        if (location == null) {
            presenter.showListEmpty()
            return
        }
        this.latitude = location.latitude
        this.longitude = location.longitude
        if (isSearch) {
            presenter.verifyCity(preferences)
            isSearch = false
        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

    private fun checkPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            itemView.context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            itemView.context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    }

    override fun showCategories(categories: List<StoreCategoryEntity>?) {
        if (categories == null) showAlertError(R.string.list_empty)
        else {
            adapter = CategoryAdapter(categories, this)
            recyclerView.adapter = adapter
        }
    }

    override fun showAlertError(id: Int) {
        Toast.makeText(context, getString(id), Toast.LENGTH_LONG).show()
    }

    override fun stateProgressBar(id: Int) {
        when (id) {
            View.VISIBLE -> dialogLoading.show()
            View.GONE -> dialogLoading.hide()
        }
    }

    override fun showListEmpty() {
        listEmpty.visibility = View.VISIBLE
    }

    override fun hideListEmpty() {
        listEmpty.visibility = View.GONE
    }

    override fun showDialogCity() {
        dialogCity.show()
    }

    private fun createCity(city: String) {
        val editor = preferences.edit()
        editor.putString(CITY_USER, city)
        editor.apply()
    }

    override fun getCity(city: String) {
        presenter.consultCategories(city, latitude, longitude)
    }

    private fun isLocationEnabled(): Boolean {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    private fun createDialogLocation() {
        val builder =
            AlertDialog.Builder(ContextThemeWrapper(itemView.context, R.style.AlertDialogTheme))
        builder.setTitle(getString(R.string.app_name))
            .setMessage(getString(R.string.active_the_location))
            .setPositiveButton(R.string.yes) { _, _ ->
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivityForResult(intent, CODE_LOCATION)
            }.setNegativeButton(R.string.no) { _, _ -> showListEmpty() }
        dialogLocation = builder.create()
    }

    private fun createDialogCity() {
        val builder =
            AlertDialog.Builder(ContextThemeWrapper(itemView.context, R.style.AlertDialogTheme))
        val view = LayoutInflater.from(itemView.context).inflate(R.layout.dialog_city, null)
        val city: Spinner = view.findViewById(R.id.spCity)
        builder.setTitle(getString(R.string.app_name))
            .setPositiveButton(R.string.yes) { _, _ ->
                val cityString = cities[city.selectedItemPosition]
                createCity(cityString)
                presenter.verifyCity(preferences)
            }
            .setNegativeButton(R.string.no) { _, _ -> presenter.showListEmpty() }
        builder.setView(view)
        dialogCity = builder.create()
        dialogCity.setCancelable(false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_LOCATION) {
            presenter.havePermissions()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivUpdate -> {
                isSearch = true
                presenter.havePermissions()
            }
        }
    }

}
