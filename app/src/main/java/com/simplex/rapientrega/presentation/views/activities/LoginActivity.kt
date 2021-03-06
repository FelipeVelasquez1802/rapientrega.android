package com.simplex.rapientrega.presentation.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.interfaces.LoginInterface
import com.simplex.rapientrega.presentation.presenters.activities.LoginPresenter
import com.simplex.rapientrega.domain.tools.KEY
import com.simplex.rapientrega.domain.tools.objectToString


class LoginActivity : BaseActivity(), LoginInterface.View, View.OnClickListener {

    private lateinit var username: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: LoginInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = applicationContext.getSharedPreferences(KEY, 0)
        presenter = LoginPresenter(this)
        presenter.isLoginNow(preferences)
        initialElements()
    }

    override fun layout(): Int {
        return R.layout.activity_login
    }

    fun initialElements() {
        username = findViewById(R.id.tilUserLogin)
        password = findViewById(R.id.tilPasswordLogin)
        progressBar = findViewById(R.id.progress_circular)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvRegister -> {
                goRegisterActivity()
            }
            R.id.tvForgotPassword -> {
                goRestorePasswordActivity()
            }
            R.id.btSignIn -> {
                presenter.validateLogin(
                    username.editText?.text.toString(),
                    password.editText?.text.toString()
                )
            }
            R.id.ivBack -> presenter.showDialogExit()
        }
    }

    override fun showErrorEmail(id: Int) {
        username.error = getString(id)
    }

    override fun hideErrorEmail() {
        username.error = null
    }

    override fun showErrorPassword(id: Int) {
        password.error = getString(id)
    }

    override fun hideErrorPassword() {
        password.error = null
    }

    override fun goMainActivity() {
        defineIntent(MainActivity::class.java)
    }

    override fun goRestorePasswordActivity() {
        defineIntent(RestorePasswordActivity::class.java)
    }

    override fun goRegisterActivity() {
        defineIntent(RegisterActivity::class.java)
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showAlertMessage(id: Int) {
        Toast.makeText(this, getString(id), Toast.LENGTH_LONG).show()
    }

    override fun saveUser(key: String, any: Any) {
        val editor = preferences.edit()
        editor.putString(key, objectToString(any))
        editor.apply()
    }

    override fun showDialogExit() {
        dialog.show()
    }

    override fun hideDialogExit() {
        dialog.hide()
    }

    private fun defineIntent(cls: Class<*>) {
        val intent = Intent(this, cls)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        if (cls == MainActivity::class.java) {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }

}
