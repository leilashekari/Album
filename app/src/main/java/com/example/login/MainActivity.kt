package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entryEmail: EditText = findViewById(R.id.entryEmail)
        val enterPass: EditText = findViewById(R.id.entryPass)
        val login: Button = findViewById(R.id.login)
        val back: ImageView = findViewById(R.id.backflash)

        back.setOnClickListener {
            onBackPressed()
        }

        login.setOnClickListener {

            val correctEmail = intent.getStringExtra("email")!!
            val correctPass = intent.getStringExtra("pass")!!

            if (entryEmail.text.toString().lowercase() == correctEmail.lowercase()) {
                Toast.makeText(this, "Succes Full", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, " Wrong", Toast.LENGTH_LONG).show()
            }
            if (enterPass.text.toString().lowercase() == correctPass.lowercase()) {
                Toast.makeText(this, "Succes Full", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, " Wrong", Toast.LENGTH_LONG).show()
            }
        }


    }
}