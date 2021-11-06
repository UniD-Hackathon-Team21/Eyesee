package com.yblee2001.eyesee.ui.user

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.R
import com.yblee2001.eyesee.databinding.ActivityPointsBinding

class PointsActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, PointsActivity::class.java)
    }

    private lateinit var binding: ActivityPointsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun loadDate(){
        val pref = this.getPreferences(0) // 저장된 값이 없으면 0가져오기
    }
}
