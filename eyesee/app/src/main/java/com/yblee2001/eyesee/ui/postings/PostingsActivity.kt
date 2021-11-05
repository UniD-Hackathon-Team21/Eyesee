package com.yblee2001.eyesee.ui.postings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityPostingsBinding

class PostingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}