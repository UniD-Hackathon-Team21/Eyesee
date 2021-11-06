package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityPostingDetailBinding
import com.yblee2001.eyesee.ui.MainActivity

class PostingDetailActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, PostingDetailActivity::class.java)
    }

    private lateinit var binding: ActivityPostingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
