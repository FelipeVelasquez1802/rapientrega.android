package com.simplex.rapientrega.presentation.views.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.simplex.rapientrega.R

abstract class BaseFragment : Fragment() {

    protected lateinit var itemView: View
    protected lateinit var dialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        itemView = getItemView(inflater, container)
        createDialog()
        return itemView
    }

    abstract fun getItemView(inflater: LayoutInflater, container: ViewGroup?): View

    private fun createDialog() {
        val build = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogTheme))
        build.setTitle(R.string.app_name)
            .setMessage(R.string.you_sure_add_product)
            .setCancelable(false)
            .setNegativeButton(R.string.no, null)
        dialog = build.create()
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}