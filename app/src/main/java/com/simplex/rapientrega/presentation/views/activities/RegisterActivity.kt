package com.simplex.rapientrega.presentation.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.interfaces.RegisterInterface
import com.simplex.rapientrega.presentation.presenters.activities.RegisterPresenter

class RegisterActivity : BaseActivity(), RegisterInterface.View, View.OnClickListener {

    private lateinit var username: TextInputLayout
    private lateinit var email: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var passwordRepeat: TextInputLayout
    private lateinit var identificationCard: TextInputLayout
    private lateinit var cellphone: TextInputLayout
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: RegisterInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = findViewById(R.id.tilUsername)
        email = findViewById(R.id.tilEmail)
        password = findViewById(R.id.tilPassword)
        passwordRepeat = findViewById(R.id.tilPasswordRepeat)
        identificationCard = findViewById(R.id.tilIdentificationCard)
        cellphone = findViewById(R.id.tilCellphone)
        progressBar = findViewById(R.id.progress_circular)

        presenter = RegisterPresenter(this)
    }

    override fun layout(): Int {
        return R.layout.activity_register
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btCreateAccount -> {
                presenter.registerUser(
                    username.editText?.text.toString(),
                    email.editText?.text.toString(),
                    password.editText?.text.toString(),
                    passwordRepeat.editText?.text.toString(),
                    identificationCard.editText?.text.toString(),
                    cellphone.editText?.text.toString()
                )
            }
            R.id.ivBack -> onBackPressed()
        }
    }

    override fun errorUsername(string: String?) {
        username.error = string
    }

    override fun errorEmail(string: String?) {
        email.error = string
    }

    override fun errorPassword(string: String?) {
        password.error = string
    }

    override fun errorPasswordRepeat(string: String?) {
        passwordRepeat.error = string
    }

    override fun errorIdentificationCard(string: String?) {
        identificationCard.error = string
    }

    override fun errorCellphone(string: String?) {
        cellphone.error = string
    }

    override fun goLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun showErrorMessage(id: Int) {
        createToast(id)
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
