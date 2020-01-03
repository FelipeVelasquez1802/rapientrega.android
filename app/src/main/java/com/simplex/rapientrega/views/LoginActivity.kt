package com.simplex.rapientrega.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.tools.emptyField

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var username: TextInputLayout
    private lateinit var password: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialElements()
    }

    fun initialElements() {
        username = findViewById(R.id.tilUserLogin)
        password = findViewById(R.id.tilPasswordLogin)
    }

    override fun onClick(v: View?) {
        var intent = Intent()
        when (v?.id) {
            R.id.tvRegister -> {
                intent = Intent(this, RegisterActivity::class.java)
            }
            R.id.tvForgotPassword -> {
                intent = Intent(this, RestorePasswordActivity::class.java)
            }
            R.id.btSignIn -> {
                if (emptyField(username)) {
                    username.error = getString(R.string.field_empty)
                    return
                } else {
                    username.error = null
                }
                if (emptyField(password)) {
                    password.error = getString(R.string.field_empty)
                    return
                } else {
                    password.error = null
                }
                intent = Intent(this, RegisterActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
