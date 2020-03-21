package com.simplex.rapientrega.presentation.views.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.tools.KEY

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var preferences: SharedPreferences
    protected lateinit var dialog: AlertDialog
    protected lateinit var dialogProduct: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        preferences = applicationContext.getSharedPreferences(KEY, 0)
        createDialog()
        createDialogDeleteProduct()
    }

    abstract fun layout(): Int

    private fun createDialog() {
        val build: AlertDialog.Builder = AlertDialog.Builder(this)
        build.setMessage(R.string.you_sure_exit)
            .setTitle(R.string.app_name)
            .setPositiveButton(R.string.yes) { _, _ -> finish() }
            .setNegativeButton(R.string.no, null)
        dialog = build.create()
    }

    private fun createDialogDeleteProduct() {
        val build: AlertDialog.Builder = AlertDialog.Builder(this)
        build.setMessage(R.string.you_sure_delete)
            .setTitle(R.string.app_name)
            .setNegativeButton(R.string.no, null)
        dialogProduct = build.create()
    }

    protected fun createToast(id: Int) {
        Toast.makeText(this, getString(id), Toast.LENGTH_LONG).show()
    }

//    override fun onBackPressed() {
//        dialog.show()
//    }
}