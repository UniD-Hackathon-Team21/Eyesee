package com.yblee2001.eyesee.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
