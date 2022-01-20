package com.masvatif.codingaja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masvatif.codingaja.adapter.AllFreeAdapter
import com.masvatif.codingaja.adapter.FreeClassAdapter

class FreeClassActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free_class)

        val freeclassList = listOf<FreeClass>(
            FreeClass(
                R.drawable.html,
                nameClass = "Belajar HTML 5",
                levelClass = "Pemula",
                descClass = "HTML adalah teknologi dasar yang digunakan untuk membuat dasar dari sebuah halaman web dengan menghubungkan teks / link antar halaman, memberi struktur dan membagikan informasi yang terkait dengan sebuah halaman web."
            ),

            FreeClass(
                R.drawable.css,
                nameClass = "Belajar CSS",
                levelClass = "Pemula",
                descClass = "CSS adalah singkatan dari Cascading Style Sheets. Kalau baca di kamus, cascading itu artinya air terjun. Tapi dalam hal ini, yang di maksud adalah, aliran dari suatu kode ke kode lain yang saling berhubungan."
            ),

            FreeClass(
                R.drawable.php,
                nameClass = "Belajar PHP",
                levelClass = "Pemula",
                descClass = "PHP merupakan bahasa pemrograman server-side, maka script dari PHP nantinya akan diproses di server. Jenis server yang sering digunakan bersama dengan PHP antara lain Apache, Nginx, dan LiteSpeed.    "
            ),

            FreeClass(
                R.drawable.bootstraps,
                nameClass = "Belajar Bootsraps 5",
                levelClass = "Pemula",
                descClass = "CSS adalah singkatan dari Cascading Style Sheets. Kalau baca di kamus, cascading itu artinya air terjun. Tapi dalam hal ini, yang di maksud adalah, aliran dari suatu kode ke kode lain yang saling berhubungan."
            ),

            FreeClass(
                R.drawable.sass,
                nameClass = "Belajar Sass",
                levelClass = "Pemula",
                descClass = "CSS adalah singkatan dari Cascading Style Sheets. Kalau baca di kamus, cascading itu artinya air terjun. Tapi dalam hal ini, yang di maksud adalah, aliran dari suatu kode ke kode lain yang saling berhubungan."
            ),

            FreeClass(
                R.drawable.laravel,
                nameClass = "Belajar Laravel",
                levelClass = "Pemula",
                descClass = "CSS adalah singkatan dari Cascading Style Sheets. Kalau baca di kamus, cascading itu artinya air terjun. Tapi dalam hal ini, yang di maksud adalah, aliran dari suatu kode ke kode lain yang saling berhubungan."
            )


        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_class)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AllFreeAdapter   (this, freeclassList){

            val intent = Intent(this, DetailClassActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        val back = findViewById<ImageView>(R.id.backclass)
        back.setOnClickListener {
            val intBack = Intent(this,HomeActivity::class.java)
            startActivity(intBack)
        }

    }
}