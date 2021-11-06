package com.yblee2001.eyesee.ui.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, SettingsActivity::class.java)
    }

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoutButton.setOnClickListener {
            // TODO: networking
        }

    }
}
