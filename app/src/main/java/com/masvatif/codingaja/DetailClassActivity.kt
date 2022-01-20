package com.masvatif.codingaja

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.masvatif.codingaja.fragment.HomeFragment
import com.masvatif.codingaja.fragment.HomeFragment.Companion.INTENT_PARCELABLE

class DetailClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_class)

        val freeclass = intent.getParcelableExtra<FreeClass>(HomeFragment.INTENT_PARCELABLE)
        val back = findViewById<ImageView>(R.id.back)

        back.setOnClickListener {
            val intBack = Intent(this, HomeActivity::class.java)
            startActivity(intBack)
        }

        val nameClass = findViewById<TextView>(R.id.tv_class_name)
        val descClass = findViewById<TextView>(R.id.tv_class_description)


        nameClass.text = freeclass?.nameClass
        descClass.text = freeclass?.descClass
    }
}