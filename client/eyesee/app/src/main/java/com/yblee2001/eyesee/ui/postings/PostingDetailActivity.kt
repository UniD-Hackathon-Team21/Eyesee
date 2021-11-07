package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityPostingDetailBinding
import com.yblee2001.eyesee.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostingDetailActivity : AppCompatActivity() {

    companion object {
        private const val POSTING_ID_KEY = "postingId"
        fun createIntent(context: Context, postingId: Int): Intent {
            return Intent(context, PostingDetailActivity::class.java).apply {
                putExtra(POSTING_ID_KEY, postingId)
            }
        }
    }

    private lateinit var binding: ActivityPostingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postingId = intent.getStringExtra(POSTING_ID_KEY) ?: ""

    }
}
