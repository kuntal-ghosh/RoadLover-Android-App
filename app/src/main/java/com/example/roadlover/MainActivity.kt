package com.example.roadlover

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.roadlover.fragment.CreditScoreFragment
import com.example.roadlover.fragment.HomeFragment
import com.example.roadlover.fragment.QuickKnockFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        hiding actionbar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
//        getting all fragments references
        val homeFragment=HomeFragment()
        val quickKnockFragment=QuickKnockFragment()
        val creditScoreFragment=CreditScoreFragment()
//        setting home fragment as default fragment
        setCurrentFragment(homeFragment)

//        setting fragment on bottomnavigation icon click
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

//    function to replace one fragment with another
    private  fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment).commit()
        }


}