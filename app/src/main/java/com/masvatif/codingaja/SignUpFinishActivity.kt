package com.masvatif.codingaja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpFinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_finish)

        val sign = findViewById<Button>(R.id.btnSign)

        sign.setOnClickListener {
            val intLogin = Intent(this, Login::class.java)
            startActivity(intLogin)
        }
    }
}