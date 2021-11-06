package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityPostingsBinding
import com.yblee2001.eyesee.ui.MainActivity

class PostingsActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, PostingsActivity::class.java)
    }

    private lateinit var binding: ActivityPostingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.writeButton.setOnClickListener {
            startActivity(NewPostingActivity.createIntent(this))
        }

    }
}
