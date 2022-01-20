package com.masvatif.codingaja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView






class SearchClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_class)

        val back = findViewById<ImageView>(R.id.backSearch)

        back.setOnClickListener {
            val intBack = Intent(this, HomeActivity::class.java)
            startActivity(intBack)
        }
    }
}