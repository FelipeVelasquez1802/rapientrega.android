package com.simplex.rapientrega.presentation.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.data.api.entities.orders.OrderEntity
import com.simplex.rapientrega.domain.interfaces.OrderInterface
import com.simplex.rapientrega.domain.tools.KEY
import com.simplex.rapientrega.domain.tools.ORDER_KEY
import com.simplex.rapientrega.domain.tools.USER
import com.simplex.rapientrega.presentation.presenters.fragments.OrderPresenter
import com.simplex.rapientrega.presentation.views.adapters.OrderAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OrderFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment :
    BaseFragment(),
    OrderInterface.View,
    OrderAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private var orders: ArrayList<OrderEntity> = ArrayList()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: OrderAdapter
    private lateinit var presenter: OrderInterface.Presenter
    private lateinit var preferences: SharedPreferences

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
        presenter = OrderPresenter(this)
        presenter.initial()
//        presenter.consultOrders(preferences.getString(ORDER, null))
        return itemView
    }

    override fun getItemView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_order, container, false)
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
        fun newInstance(): OrderFragment = OrderFragment()

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrdersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(order: OrderEntity) {
        val fragment = OrderDetailFragment()
        val args = Bundle()
        args.putSerializable(ORDER_KEY, order)
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.add(R.id.frame_layout_main, fragment)
            ?.addToBackStack(null)?.commit()
    }

    override fun initialElements() {
        preferences = itemView.context.getSharedPreferences(KEY, 0)
        recyclerView = itemView.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun initialObjects() {
        adapter = OrderAdapter(orders, this)
        recyclerView.adapter = adapter
        val string = preferences.getString(USER, null)
        presenter.convertUser(string)
    }

    override fun showOrders(orders: List<OrderEntity>) {
        this.orders.addAll(orders)
        adapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        dialogLoading.show()
    }

    override fun hideLoading() {
        dialogLoading.hide()
    }

    override fun showError(message: String) {
        showToast(message)
    }

    override fun getUser(profile: ProfileEntity) {
        presenter.consultOrders(profile.id)
    }

//    override fun putOrders(orders: List<OrderEntity>) {
//        adapter = OrderAdapter(orders, this)
//        recyclerView.adapter = adapter
//    }
}
