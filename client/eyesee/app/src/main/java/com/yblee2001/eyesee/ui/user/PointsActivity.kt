package com.yblee2001.eyesee.ui.user

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.R
import com.yblee2001.eyesee.databinding.ActivityPointsBinding

class PointsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPointsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var plus = findViewById<Button>(R.id.plus_btn)
        val output = findViewById<TextView>(R.id.points)
        val output_text : String = "points";
        var num = 0;

        plus.setOnClickListener{
            num++
            output.setText(num.toString() + output_text)
        }
    }

    private fun loadDate(){
        val pref = this.getPreferences(0) // 저장된 값이 없으면 0가져오기


    }
}
