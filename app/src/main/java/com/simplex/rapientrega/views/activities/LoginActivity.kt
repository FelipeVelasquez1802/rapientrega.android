package com.simplex.rapientrega.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.LoginInterface
import com.simplex.rapientrega.presenters.activities.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginInterface.View, View.OnClickListener {

    private lateinit var username: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: LoginInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)
        initialElements()
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
                presenter.validateFields(
                    username.editText?.text.toString(),
                    password.editText?.text.toString()
                )
            }
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

    private fun defineIntent(cls: Class<*>) {
        val intent = Intent(this, cls)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}
