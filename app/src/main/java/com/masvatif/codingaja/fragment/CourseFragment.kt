package com.masvatif.codingaja.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.masvatif.codingaja.DetailClassActivity
import com.masvatif.codingaja.FreeClass
import com.masvatif.codingaja.HomeActivity
import com.masvatif.codingaja.R
import com.masvatif.codingaja.adapter.AllFreeAdapter
import com.masvatif.codingaja.databinding.FragmentCourseBinding

class CourseFragment : Fragment() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentCourseBinding.inflate(layoutInflater)

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



        )

        bind.rvClass.layoutManager = LinearLayoutManager(activity)
        bind.rvClass.setHasFixedSize(true)
        bind.rvClass.adapter = AllFreeAdapter(requireActivity(), freeclassList){
            val intent = Intent(this.requireContext(), DetailClassActivity::class.java)
            intent.putExtra(HomeFragment.INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        bind.btnAddCourse.setOnClickListener {
            val intAdd = Intent(this.requireContext(), HomeActivity::class.java)
            startActivity(intAdd)
        }

        return bind.root
    }


}