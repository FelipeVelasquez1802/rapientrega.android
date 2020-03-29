package com.simplex.rapientrega.presentation.views.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.domain.interfaces.ProductDetailInterface
import com.simplex.rapientrega.domain.tools.KEY
import com.simplex.rapientrega.domain.tools.PRODUCT
import com.simplex.rapientrega.domain.tools.SHOPPING_CART
import com.simplex.rapientrega.domain.tools.YES
import com.simplex.rapientrega.presentation.presenters.fragments.ProductDetailPresenter
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
    BaseFragment(),
    ProductDetailInterface.View,
    ImageListener,
    View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var image: ImageView
    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var carouselView: CarouselView
    private lateinit var pay: Button
    private lateinit var count: TextView
    private lateinit var left: Button
    private lateinit var right: Button

    private lateinit var product: ProductEntity
    private lateinit var preferences: SharedPreferences

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
        super.onCreateView(inflater, container, savedInstanceState)
        preferences = itemView.context.getSharedPreferences(KEY, 0)
        initialObjects()
        presenter = ProductDetailPresenter(this)
        presenter.initial()
        return itemView
    }

    override fun getItemView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    private fun initialObjects() {
    }

    override fun initialElements() {
        product = arguments?.getSerializable(PRODUCT) as ProductEntity
        image = itemView.findViewById(R.id.ivPhoto)
        Glide.with(itemView).load(
            if (product.image == null) R.drawable.ic_image_black_24dp
            else product.imageAbsolute()
        ).into(image)
        name = itemView.findViewById(R.id.tvName)
        name.text = product.name
        carouselView = itemView.findViewById(R.id.carouselView)
        val size = product.images.size
        carouselView.pageCount = if (size > 0) size else 1
        description = itemView.findViewById(R.id.tvDescription)
        description.text = product.description
        pay = itemView.findViewById(R.id.btAddShoppingCart)
        count = itemView.findViewById(R.id.tvCount)
        left = itemView.findViewById(R.id.btLeft)
        left.isEnabled = false
        right = itemView.findViewById(R.id.btMore)
    }

    override fun subtract(count: String, flag: Boolean) {
        this.count.text = count
        left.isEnabled = flag
    }

    override fun add(count: String, flag: Boolean) {
        this.count.text = count
        left.isEnabled = flag
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
            val count = product.images.size
            context?.let {
                Glide.with(it).load(
                    if (count > 0) product.images[position]
                    else R.drawable.ic_image_black_24dp
                ).into(imageView)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btAddShoppingCart -> {
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, YES) { _, _ ->
                    run {
                        val value = preferences.getString(SHOPPING_CART, null)
                        presenter.addProductToCar(product, count.text.toString(), value)
                    }
                }
                dialog.show()
            }
            R.id.btLeft -> {
                presenter.left(count.text.toString())
            }
            R.id.btMore -> {
                presenter.right(count.text.toString())
            }
        }
    }

    override fun addShoppingCart(string: String) {
        val editor = preferences.edit()
        editor.putString(SHOPPING_CART, string)
        editor.apply()
        parentFragmentManager.popBackStack()
    }

    override fun addListener() {
        carouselView.setImageListener(this)
        pay.setOnClickListener(this)
        left.setOnClickListener(this)
        right.setOnClickListener(this)
    }
}
