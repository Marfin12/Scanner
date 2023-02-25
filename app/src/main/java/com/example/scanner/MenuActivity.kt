package com.example.scanner

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.scanner.databinding.ActivityMainBinding
import com.example.scanner.databinding.ActivityMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    companion object {
        const val EXTRA_USER_NAME = "extra_room_name"
        var theName = "dwadwa"

        fun launch(activity: Activity, userName: String) {
            val intent = Intent(activity, MenuActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, userName)
            this.theName = userName

            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra(EXTRA_USER_NAME)

        val mBundle = Bundle()
        val alarmFragment = AlarmFragment()

        mBundle.putString("mText",userName)
        alarmFragment.arguments = mBundle

        loadFragment(alarmFragment)
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.music -> {
                    loadFragment(MusicFragment())
                    true
                }
                R.id.bookmark -> {
                    loadFragment(BookmarkFragment())
                    true
                }
                R.id.alarm -> {
                    loadFragment(AlarmFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}