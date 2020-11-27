package com.example.roadlover

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.roadlover.R
import com.example.roadlover.fragment.CreditScoreFragment
import com.example.roadlover.fragment.HomeFragment
import com.example.roadlover.fragment.QuickKnockFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment=HomeFragment()
        val quickKnockFragment=QuickKnockFragment()
        val creditScoreFragment=CreditScoreFragment()
        setCurrentFragment(homeFragment)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 click
                    setCurrentFragment(homeFragment);
                    println("hello")

                    true
                }
                R.id.map -> {
                    // Respond to navigation item 2 click
                    setCurrentFragment(quickKnockFragment);
                    println(item.itemId)

                    true
                }
                R.id.add -> {
                    // Respond to navigation item 2 click
                    setCurrentFragment(creditScoreFragment);
                    println(item.itemId)

                    true
                }
                else -> false
            }
        }    }

    private  fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment).commit()
        }


}