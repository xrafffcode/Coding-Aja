package com.masvatif.codingaja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.masvatif.codingaja.fragment.ChatFragment
import com.masvatif.codingaja.fragment.CourseFragment
import com.masvatif.codingaja.fragment.HomeFragment
import com.masvatif.codingaja.fragment.UserFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val scheduleFragment = CourseFragment()
        val chatFragment = ChatFragment()
        val userFragment = UserFragment()

        makeCurrentFragment(homeFragment)

        val buttom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        buttom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_course -> makeCurrentFragment(scheduleFragment)
                R.id.menu_chat -> makeCurrentFragment(chatFragment)
                R.id.menu_user -> makeCurrentFragment(userFragment)
            }

            true
        }
    }



    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}