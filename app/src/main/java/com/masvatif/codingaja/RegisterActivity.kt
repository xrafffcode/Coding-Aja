package com.masvatif.codingaja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        
        val have = findViewById<TextView>(R.id.have)
        val signuppw = findViewById<EditText>(R.id.signuppw)
        val signupemail = findViewById<EditText>(R.id.signupemail)
        val btnsignup = findViewById<Button>(R.id.btnSignup)
        val show = findViewById<TextView>(R.id.show)

        have.setOnClickListener {
            val intHave = Intent(this, Login::class.java)
            startActivity(intHave)
        }

        btnsignup.setOnClickListener {
            val email = signupemail.text.toString().trim()
            val password = signuppw.text.toString().trim()
            val loading = findViewById<ProgressBar>(R.id.progressBar2)

            if (email.isEmpty()){
                signupemail.error = "Email Harus Diisi"
                signupemail.requestFocus()
                loading.visibility = View.INVISIBLE;
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                signupemail.error = "Email Tidak Valid"
                signupemail.requestFocus()
                loading.visibility = View.INVISIBLE;
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                signuppw.error = "Password harus lebih dari 6 karakter"
                signuppw.requestFocus()
                loading.visibility = View.INVISIBLE;
                return@setOnClickListener
            }

            loading.visibility = View.VISIBLE;

            register(email, password)
        }




        show.setOnClickListener{
            if (show.text.toString().equals("Show")){
                signuppw.transformationMethod = HideReturnsTransformationMethod.getInstance()
                show.text = "Hide"
            }
            else{
                signuppw.transformationMethod = PasswordTransformationMethod.getInstance()
                show.text = "Show"
            }
        }
    }

    private fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this, SignUpFinishActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else{
                    val loading = findViewById<ProgressBar>(R.id.progressBar)
                    loading.visibility = View.INVISIBLE;
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

}