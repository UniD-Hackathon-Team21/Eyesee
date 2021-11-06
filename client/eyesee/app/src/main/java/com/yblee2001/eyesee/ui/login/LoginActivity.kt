package com.yblee2001.eyesee.ui.login

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getText
import com.yblee2001.eyesee.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = binding.idEditText.getText().toString()
        val password: String = binding.passwordEditText.getText().toString()

        binding.btnLogin.setOnClickListener {
            // TODO: networking

        }
    }
}
