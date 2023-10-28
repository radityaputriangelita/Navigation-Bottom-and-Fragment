package com.example.botton_navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.botton_navbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replacefragment(DashboardFragment())

        binding.navbotLo.setOnItemSelectedListener{
            when(it.itemId){
                R.id.nav_profile -> replacefragment(ProfileFragment())
                R.id.nav_dash -> replacefragment(DashboardFragment())
                R.id.nav_Order -> replacefragment(OrderFragment())

                else->{}
            }
            true
        }


    }

    private fun replacefragment (fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_lo, fragment)
        fragmentTransaction.commit()
    }
}