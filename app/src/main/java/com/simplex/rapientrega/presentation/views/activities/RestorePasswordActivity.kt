package com.simplex.rapientrega.presentation.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.interfaces.RestorePasswordInterface
import com.simplex.rapientrega.presentation.presenters.activities.RestorePasswordPresenter

class RestorePasswordActivity :
    AppCompatActivity(),
    RestorePasswordInterface.View,
    View.OnClickListener {

    private lateinit var email: TextInputLayout
    private lateinit var presenter: RestorePasswordInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password)
        presenter = RestorePasswordPresenter(this)
        initialElements()
    }

    private fun initialElements() {
        email = findViewById(R.id.tilEmailRestore)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btRestore -> {
                presenter.validateFields(email.editText?.text.toString())
            }
            R.id.ivBack -> onBackPressed()
        }
    }

    override fun showErrorEmail(id: Int) {
        email.error = getString(id)
    }

    override fun hideErrorEmail() {
        email.error = null
    }

    override fun goLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
