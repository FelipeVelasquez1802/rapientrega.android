package com.simplex.rapientrega.presentation.views.fragments

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.interfaces.CategoryInterface
import com.simplex.rapientrega.domain.tools.CITY_USER
import com.simplex.rapientrega.domain.tools.STORES
import com.simplex.rapientrega.domain.tools.UBICATION_INITIAL
import com.simplex.rapientrega.domain.tools.toUbicationEntity
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
    CategoryAdapter.OnItemClickListener {
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

    private lateinit var presenter: CategoryInterface.Presenter

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
    }

    override fun initialObjects() {
    }

    override fun addListeners() {
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

    override fun searchUbication() {
        val city = preferences.getString(CITY_USER, null)
        val ubication = preferences.getString(UBICATION_INITIAL, null)

        val ubicationEntity = toUbicationEntity(ubication)
        presenter.consultCategories(city, ubicationEntity)
    }

}
