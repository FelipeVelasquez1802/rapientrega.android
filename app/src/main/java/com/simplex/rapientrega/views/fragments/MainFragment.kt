package com.simplex.rapientrega.views.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mapbox.mapboxsdk.Mapbox

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.MainFragmentInterface
import com.simplex.rapientrega.presenters.fragments.MainFragmentPresenter
import com.simplex.rapientrega.views.adapters.MyPagerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CategoryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val NUM_PAGES = 3

class MainFragment :
    Fragment(),
    MainFragmentInterface.View,
    BottomNavigationView.OnNavigationItemSelectedListener,
    ViewPager.OnPageChangeListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var viewPager: ViewPager

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var presenter: MainFragmentInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        viewPager = view.findViewById(R.id.view_pager)
        bottomNavigationView = view.findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        presenter = MainFragmentPresenter(this)
        presenter.addAdapter()
        return view
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
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
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

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return when (p0.itemId) {
            R.id.item_category -> {
                viewPagerItem(0)
                true
            }
            R.id.item_shopping_basket -> {
                viewPagerItem(1)
                true
            }
            R.id.item_profile -> {
                viewPagerItem(2)
                true
            }
            else -> {
                viewPagerItem(0)
                true
            }
        }
    }

    private fun viewPagerItem(position: Int) {
        viewPager.currentItem = position
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                bottomNavigationViewItem(R.id.item_category)
            }
            1 -> {
                bottomNavigationViewItem(R.id.item_shopping_basket)
            }
            2 -> {
                bottomNavigationViewItem(R.id.item_profile)
            }
            else -> {
                bottomNavigationViewItem(R.id.item_category)
            }
        }
    }

    private fun bottomNavigationViewItem(id: Int) {
        bottomNavigationView.selectedItemId = id
    }

    override fun addAdapter() {
        viewPager.adapter = MyPagerAdapter(fragmentManager)
        viewPager.addOnPageChangeListener(this)
    }

}
