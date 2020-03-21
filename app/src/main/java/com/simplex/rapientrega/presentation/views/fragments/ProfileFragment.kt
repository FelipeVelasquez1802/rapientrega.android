package com.simplex.rapientrega.presentation.views.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.domain.interfaces.ProfileInterface
import com.simplex.rapientrega.domain.tools.KEY
import com.simplex.rapientrega.domain.tools.USER
import com.simplex.rapientrega.presentation.presenters.fragments.ProfilePresenter
import com.simplex.rapientrega.presentation.views.activities.LoginActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ProfileFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment(), ProfileInterface.View, View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var preferences: SharedPreferences

    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var photo: ImageView
    private lateinit var logout: TextView

    private lateinit var presenter: ProfileInterface.Presenter

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
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        initialObjects()
        initialElements(view)
        return view
    }

    private fun initialObjects() {
    }

    private fun initialElements(view: View) {
        preferences = view.context.getSharedPreferences(KEY, 0)
        username = view.findViewById(R.id.tvUsername)
        email = view.findViewById(R.id.tvEmail)
        photo = view.findViewById(R.id.ivPhoto)
        logout = view.findViewById(R.id.tvLogOut)
        logout.setOnClickListener(this)
        presenter = ProfilePresenter(this)
        presenter.convertString(preferences.getString(USER, null))
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
        fun newInstance(): ProfileFragment = ProfileFragment()

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvLogOut -> {
                this.logout(USER)
                this.goLoginActivity()
            }
            R.id.tvAbout -> {
                Toast.makeText(context, "Acerca de", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun putData(profileEntity: ProfileEntity) {
        username.text = profileEntity.username
        email.text = profileEntity.email
//        Glide.with(view).load(user.photo).into(photo)
    }

    override fun logout(id: String) {
        val editor = preferences.edit()
        editor.remove(id)
        editor.apply()
    }

    override fun goLoginActivity() {
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
