package com.simplex.rapientrega.views.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.BaseInterface
import com.simplex.rapientrega.tools.KEY

abstract class BaseActivity : AppCompatActivity(), BaseInterface.View, View.OnClickListener {

    protected lateinit var preferences: SharedPreferences
    private lateinit var dialog: AlertDialog

    private lateinit var presenter: BaseInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        preferences = applicationContext.getSharedPreferences(KEY, 0)
        createDialogExit()
    }

    fun createToast(){

    }

    abstract fun layout(): Int

    override fun createDialogExit() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.arr_you_exit)
            .setTitle(R.string.app_name)
            .setPositiveButton(
                R.string.yes
            ) { dialog, which -> onBackPressed() }
            .setNegativeButton(R.string.no, null)
        dialog = builder.create()
    }

    override fun showDialogExit() {
        dialog.show()
    }

    override fun hideDialogExist() {
        dialog.hide()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
        }
    }

}