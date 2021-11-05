package com.yblee2001.eyesee.ui.postings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityNewPostingBinding

class NewPostingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewPostingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPostingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
