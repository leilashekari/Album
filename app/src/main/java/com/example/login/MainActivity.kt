package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user: EditText = findViewById(R.id.user)
        val pass: EditText = findViewById(R.id.pass)
        val login: Button = findViewById(R.id.login)

        val myUser = "Leila"
        val myPass = 2323

        login.setOnClickListener {
            if (user.text.toString().lowercase() == myUser.lowercase() && pass.text.toString().toInt() == myPass) {
                Toast.makeText(this, "Succes Full", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show()
            }
        }


    }
}