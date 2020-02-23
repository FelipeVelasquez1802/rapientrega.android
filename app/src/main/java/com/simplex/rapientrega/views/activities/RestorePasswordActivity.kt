package com.simplex.rapientrega.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import com.simplex.rapientrega.R
import com.simplex.rapientrega.tools.emptyField

class RestorePasswordActivity :
    AppCompatActivity(), View.OnClickListener {

    private lateinit var email: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password)
        initialElements()
    }

    private fun initialElements() {
        email = findViewById(R.id.tilEmailRestore)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btRestore -> {
                if (emptyField(email)) {
                    email.error = getString(R.string.not_empty)
                    return
                } else {
                    email.error = null
                }
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
