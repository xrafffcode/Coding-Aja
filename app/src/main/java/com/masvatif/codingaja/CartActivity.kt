package com.masvatif.codingaja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masvatif.codingaja.adapter.AllFreeAdapter

class CartActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val freeclassList = listOf<FreeClass>(
            FreeClass(
                R.drawable.html,
                nameClass = "Belajar HTML 5",
                levelClass = "Pemula",
                descClass = "HTML adalah teknologi dasar yang digunakan untuk membuat dasar dari sebuah halaman web dengan menghubungkan teks / link antar halaman, memberi struktur dan membagikan informasi yang terkait dengan sebuah halaman web."
            ),

        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_class)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AllFreeAdapter   (this, freeclassList){

            val intent = Intent(this, DetailClassActivity::class.java)
            intent.putExtra(FreeClassActivity.INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        val back = findViewById<ImageView>(R.id.backcart)
        back.setOnClickListener {
            val intBack = Intent(this,HomeActivity::class.java)
            startActivity(intBack)
        }
    }
}