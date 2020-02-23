package com.simplex.rapientrega.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.RestorePasswordInterface
import com.simplex.rapientrega.presenters.activities.RestorePasswordPresenter
import com.simplex.rapientrega.tools.emptyField

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
//                if (emptyField(email)) {
//                    email.error = getString(R.string.not_empty)
//                    return
//                } else {
//                    email.error = null
//                }
//                var intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
            }
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
