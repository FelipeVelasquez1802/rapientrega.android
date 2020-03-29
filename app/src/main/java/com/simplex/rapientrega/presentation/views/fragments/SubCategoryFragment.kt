package com.simplex.rapientrega.presentation.views.fragments

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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProductCategoriesEntity
import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.domain.interfaces.SubCategoryInterface
import com.simplex.rapientrega.domain.tools.PRODUCTS
import com.simplex.rapientrega.domain.tools.STORE_ID
import com.simplex.rapientrega.presentation.presenters.fragments.SubCategoryPresenter
import com.simplex.rapientrega.presentation.views.adapters.SubCategoryAdapter
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SubCategoryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SubCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubCategoryFragment :
    BaseFragment(),
    SubCategoryInterface.View,
    SubCategoryAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SubCategoryAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var listEmpty: TextView

    private lateinit var presenter: SubCategoryInterface.Presenter
    private var subcategories: ArrayList<ProductCategoriesEntity> = ArrayList()

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
        presenter = SubCategoryPresenter(this)
        presenter.initial()
        return itemView
    }

    override fun getItemView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }

    private fun initialElements(view: View) {
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SubCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SubCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(products: List<ProductEntity>) {
        val fragment = ProductFragment()
        val args = Bundle()
        args.putSerializable(PRODUCTS, products as Serializable)
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.add(R.id.frame_layout_main, fragment)
            ?.addToBackStack(null)?.commit()
    }

    override fun initialObjects() {
        val storeId = arguments?.getInt(STORE_ID, -1)
        if (storeId == null) {
            showListEmpty()
            return
        }
        presenter.consultSubCategories(storeId)
    }

    override fun initialElements() {
        recyclerView = itemView.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = SubCategoryAdapter(subcategories, this)
        recyclerView.adapter = adapter
        progressBar = itemView.findViewById(R.id.progress_circular)
        listEmpty = itemView.findViewById(R.id.tvListEmpty)
    }

    override fun showSubCategories(subcategories: List<ProductCategoriesEntity>) {
        this.subcategories.addAll(subcategories)
        adapter.notifyDataSetChanged()
        showListEmpty()
    }

    private fun showListEmpty() {
        if (subcategories.isEmpty()) {
            listEmpty.visibility = View.VISIBLE
        } else {
            listEmpty.visibility = View.GONE
        }
    }

    override fun showAlertMessage(id: Int) {
        Toast.makeText(context, getString(id), Toast.LENGTH_LONG).show()
    }

    override fun stateProgressBar(id: Int) {
        progressBar.visibility = id
    }
}
