package com.yblee2001.eyesee.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivitySignUpBinding
import com.yblee2001.eyesee.ui.MainActivity

class SignUpActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, SignUpActivity::class.java)
    }

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
