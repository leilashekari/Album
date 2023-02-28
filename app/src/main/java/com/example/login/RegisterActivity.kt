package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class RegisterActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var passwordEditText: EditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name = findViewById(R.id.regisName)
        email = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.pass)
        saveButton = findViewById(R.id.save)

        passwordEditText.doAfterTextChanged {
            validate()
        }

        email.doAfterTextChanged {
            validate()
        }

        name.doAfterTextChanged {
            validate()
        }

        saveButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", email.text.toString())
            intent.putExtra("pass", passwordEditText.text.toString())
            startActivity(intent)
        }
    }

    fun validate() {
        if (passwordEditText.text.length >= 6 &&
            email.text.length >= 6 &&
            name.text.length >= 6
        ) {
            saveButton.isEnabled = true
        } else {
            saveButton.isEnabled = false
        }
    }
}
