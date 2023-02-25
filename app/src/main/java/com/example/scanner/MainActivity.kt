package com.example.scanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.scanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.emailField1.text.toString()
            val password = binding.passwordField1.text.toString()

            MenuActivity.launch(this, username)
        }
    }
}