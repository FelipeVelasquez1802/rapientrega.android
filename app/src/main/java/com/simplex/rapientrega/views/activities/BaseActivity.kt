package com.simplex.rapientrega.views.activities

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.simplex.rapientrega.R
import com.simplex.rapientrega.tools.KEY

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var preferences: SharedPreferences
    protected lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        preferences = applicationContext.getSharedPreferences(KEY, 0)
        createDialog()
    }

    abstract fun layout(): Int

    private fun createDialog() {
        val build: AlertDialog.Builder = AlertDialog.Builder(this)
        build.setMessage(R.string.you_sure_exit)
            .setTitle(R.string.app_name)
            .setPositiveButton(R.string.yes, { dialog, which -> onBackPressed() })
            .setNegativeButton(R.string.no, null)
        dialog = build.create()
    }
}