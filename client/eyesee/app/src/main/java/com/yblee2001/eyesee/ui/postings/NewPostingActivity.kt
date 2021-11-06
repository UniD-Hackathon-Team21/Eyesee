package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivityNewPostingBinding
import com.yblee2001.eyesee.ui.MainActivity

class NewPostingActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, NewPostingActivity::class.java)
    }

    private lateinit var binding: ActivityNewPostingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPostingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
