package com.masvatif.codingaja.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.masvatif.codingaja.*
import com.masvatif.codingaja.adapter.FreeClassAdapter
import com.masvatif.codingaja.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var auth : FirebaseAuth



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = FirebaseAuth.getInstance()

        val bind = FragmentHomeBinding.inflate(layoutInflater)

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
            )
        )

        bind.rvClass.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        bind.rvClass.setHasFixedSize(true)
        bind.rvClass.adapter = FreeClassAdapter(requireActivity(), freeclassList){
            val intent = Intent(this.requireContext(), DetailClassActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        bind.search.setOnClickListener {
            val search = Intent(this.requireContext(), SearchClassActivity::class.java)
            startActivity(search)
        }

        bind.seeAll.setOnClickListener {
            val seeAll = Intent(this.requireContext(),FreeClassActivity::class.java)
            startActivity(seeAll)
        }

        bind.classcoding.setOnClickListener {
            val seeAll = Intent(this.requireContext(),FreeClassActivity::class.java)
            startActivity(seeAll)
        }

        bind.classdesign.setOnClickListener {
            val seeAll = Intent(this.requireContext(),ClassDesignActivity::class.java)
            startActivity(seeAll)
        }

        bind.classsoft .setOnClickListener {
            val seeAll = Intent(this.requireContext(),ClassDesignActivity::class.java)
            startActivity(seeAll)
        }


        val user = auth.currentUser

        bind.username.setText(user?.displayName)

        bind.cart.setOnClickListener {
            val intCart = Intent(this.requireContext(), CartActivity::class.java)
            startActivity(intCart)
        }


        return bind.root
    }


}