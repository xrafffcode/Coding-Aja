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

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val show = findViewById<TextView>(R.id.show)
        val signpw = findViewById<EditText>(R.id.signuppw)
        val signemail = findViewById<EditText>(R.id.signupemail)
        val btnsign = findViewById<Button>(R.id.btnSignup)
        val nothave = findViewById<TextView>(R.id.nothaveSignUp)
        val forgot = findViewById<TextView>(R.id.forgotpw)

        nothave.setOnClickListener {
            val intNot = Intent(this, RegisterActivity::class.java)
            startActivity(intNot)
        }

        forgot.setOnClickListener {
            val intForgot = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intForgot)
        }

        show.setOnClickListener{
            if (show.text.toString().equals("Show")){
                signpw.transformationMethod = HideReturnsTransformationMethod.getInstance()
                show.text = "Hide"
            }
            else{
                signpw.transformationMethod = PasswordTransformationMethod.getInstance()
                show.text = "Show"
            }
        }

        btnsign.setOnClickListener{
            val email = signemail.text.toString().trim()
            val password = signpw.text.toString().trim()
            val loading = findViewById<ProgressBar>(R.id.progressBar)

            if (email.isEmpty()){
                signemail.error = "Email Harus Diisi"
                signemail.requestFocus()
                loading.visibility = View.INVISIBLE;
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                signemail.error = "Email Tidak Valid"
                signemail.requestFocus()
                loading.visibility = View.INVISIBLE;
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                signpw.error = "Password harus lebih dari 6 karakter"
                signpw.requestFocus()
                loading.visibility = View.INVISIBLE;
                return@setOnClickListener
            }


            loading.visibility = View.VISIBLE;
            loginUser(email, password)

        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this, HomeActivity::class.java).also { intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                }else{
                    val loading = findViewById<ProgressBar>(R.id.progressBar)
                    loading.visibility = View.INVISIBLE;
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this, HomeActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}