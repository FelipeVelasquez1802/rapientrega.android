package com.simplex.rapientrega.views.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.ProductDetailInterface
import com.simplex.rapientrega.objects.Product
import com.simplex.rapientrega.presenters.fragments.ProductDetailPresenter
import com.simplex.rapientrega.tests.ProductTest
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ProductDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ProductDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailFragment :
    Fragment(),
    ProductDetailInterface.View,
    ImageListener,
    View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var carouselView: CarouselView
    private lateinit var pay: Button
    private lateinit var count: TextView
    private lateinit var less: Button
    private lateinit var right: Button

    private lateinit var product: Product

    private lateinit var presenter: ProductDetailInterface.Presenter

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
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_product_detail, container, false)
        initialObjects()
        initialElements(view)

        presenter = ProductDetailPresenter(this)
        presenter.consultProductDetail()
        return view
    }

    private fun initialObjects() {
        product = ProductTest().product()
    }

    private fun initialElements(view: View) {
        name = view.findViewById(R.id.tvName)

        carouselView = view.findViewById(R.id.carouselView)
        carouselView.setImageListener(this)

        description = view.findViewById(R.id.tvDescription)

        pay = view.findViewById(R.id.btPay)
        pay.setOnClickListener(this)

        count = view.findViewById(R.id.tvCount)

        less = view.findViewById(R.id.btLess)
        less.setOnClickListener(this)

        right = view.findViewById(R.id.btMore)
        right.setOnClickListener(this)
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
         * @return A new instance of fragment ProductDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setImageForPosition(position: Int, imageView: ImageView?) {
        if (imageView != null) {
            context?.let { Glide.with(it).load(product.photos?.get(position)).into(imageView) }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btPay -> {
                Toast.makeText(context, "Comprar", Toast.LENGTH_LONG).show()
            }
            R.id.btLess -> {
                val count = this.count.text.toString().toInt() - 1
                if (count >= 0) {
                    this.count.text = "$count"
                }
            }
            R.id.btMore -> {
                val count = this.count.text.toString().toInt() + 1
                this.count.text = "$count"
            }
        }
    }

    override fun showProductDetail(product: Product) {
        name.text = product.name
        carouselView.pageCount = product.photos?.size ?: 0
        description.text = product.description
    }
}
