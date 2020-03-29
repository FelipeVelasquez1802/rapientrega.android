package com.simplex.rapientrega.presentation.views.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.interfaces.MapInterface
import com.simplex.rapientrega.presentation.presenters.fragments.MapPresenter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MapFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment :
    BaseFragment(),
    MapInterface.View,
    OnMapReadyCallback,
    Style.OnStyleLoaded,
    View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private var mapView: MapView? = null
    private lateinit var progressBar: ProgressBar;
    private lateinit var less: FloatingActionButton
    private lateinit var plus: FloatingActionButton

    private lateinit var map: MapboxMap

    private lateinit var presenter: MapInterface.Presenter

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
        Mapbox.getInstance(requireContext(), getString(R.string.mapbox_access_token))
        super.onCreateView(inflater, container, savedInstanceState)
        presenter = MapPresenter(this)
        presenter.initial(savedInstanceState)
        return itemView
    }

    override fun getItemView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
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
        fun newInstance() = MapFragment()

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MapFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun initialElement(savedInstanceState: Bundle?) {
        mapView = itemView.findViewById(R.id.map_view)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync(this)
        progressBar = itemView.findViewById(R.id.progress_circular)
        presenter.stateProgressBar(true)
        less = itemView.findViewById(R.id.fabLess)
        plus = itemView.findViewById(R.id.fabPlus)
    }

    override fun stateProgressBar(id: Int) {
        progressBar.visibility = id
    }

    override fun addListener() {
        less.setOnClickListener(this)
        plus.setOnClickListener(this)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        presenter.stateProgressBar(false)
        map = mapboxMap
        map.setStyle(Style.MAPBOX_STREETS, this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fabPlus -> updateCamera(1)
            R.id.fabLess -> updateCamera(-1)
        }
    }

    private fun updateCamera(value: Int) {
        val location = map.locationComponent.lastKnownLocation ?: return
        val lat = location.latitude
        val lng = location.longitude
        val zoom = map.cameraPosition.zoom + value
        val cameraPosition = CameraPosition.Builder()
            .target(LatLng(lat, lng))
            .zoom(zoom)
            .build()
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1000)
    }

    override fun onStyleLoaded(style: Style) {
        if (PermissionsManager.areLocationPermissionsGranted(context)) {
            val locationComponent = map.locationComponent
            map.style?.let { style ->
                val locationComponentOptions =
                    LocationComponentOptions.builder(requireContext()).build()
                val activationOptions =
                    LocationComponentActivationOptions.Builder(requireContext(), style)
                        .locationComponentOptions(locationComponentOptions)
                        .build()
                locationComponent.activateLocationComponent(activationOptions)
            }

            locationComponent.isLocationComponentEnabled = true
            locationComponent.renderMode = RenderMode.COMPASS
        }
    }
}
