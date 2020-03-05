package com.simplex.rapientrega.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.RegisterInterface
import com.simplex.rapientrega.presenters.activities.RegisterPresenter

class RegisterActivity : AppCompatActivity(), RegisterInterface.View, View.OnClickListener {

    private lateinit var username: TextInputLayout
    private lateinit var email: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var passwordRepeat: TextInputLayout

    private lateinit var presenter: RegisterInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        username = findViewById(R.id.tilUsername)
        email = findViewById(R.id.tilEmail)
        password = findViewById(R.id.tilPassword)
        passwordRepeat = findViewById(R.id.tilPasswordRepeat)

        presenter = RegisterPresenter(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btCreateAccount -> {
                presenter.validateFields(
                    username.editText?.text.toString(),
                    email.editText?.text.toString(),
                    password.editText?.text.toString(),
                    passwordRepeat.editText?.text.toString()
                )
            }
        }
    }

    override fun showErrorUsername(id: Int) {
        username.error = getString(id)
    }

    override fun hideErrorUsername() {
        username.error = null
    }

    override fun showErrorEmail(id: Int) {
        email.error = getString(id)
    }

    override fun hideErrorEmail() {
        email.error = null
    }

    override fun showErrorPassword(id: Int) {
        password.error = getString(id)
    }

    override fun hideErrorPassword() {
        password.error = null
    }

    override fun showErrorPasswordRepeat(id: Int) {
        passwordRepeat.error = getString(id)
    }

    override fun hideErrorPasswordRepeat() {
        passwordRepeat.error = null
    }

    override fun goLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
