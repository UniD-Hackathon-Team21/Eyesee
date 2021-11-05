package com.yblee2001.eyesee.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityMyPostingsBinding

class MyPostingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyPostingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPostingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
