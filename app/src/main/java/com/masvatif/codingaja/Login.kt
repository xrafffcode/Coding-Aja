package com.masvatif.codingaja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val show = findViewById<TextView>(R.id.show)
        val password = findViewById<EditText>(R.id.loginPass)

        show.setOnClickListener{
            if (show.text.toString().equals("Show")){
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                show.text = "Hide"
            }
            else{
                password.transformationMethod = PasswordTransformationMethod.getInstance()
                show.text = "Show"
            }
        }
    }
}