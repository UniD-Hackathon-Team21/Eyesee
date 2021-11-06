package com.yblee2001.eyesee.ui.postings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityPostingDetailBinding

class PostingDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        imageView2.visiblity = VIEW.invisible
    }
}
