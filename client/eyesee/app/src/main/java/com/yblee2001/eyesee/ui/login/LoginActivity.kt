package com.yblee2001.eyesee.ui.login

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getText
import com.yblee2001.eyesee.databinding.ActivityLoginBinding
import com.yblee2001.eyesee.ui.MainActivity
import com.yblee2001.eyesee.ui.user.MyPostingsActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = binding.idEditText.getText().toString()
        val password: String = binding.passwordEditText.getText().toString()

        binding.loginButton.setOnClickListener {
            // TODO: networking

            // temp
            startActivity(MainActivity.createIntent(this.applicationContext))
        }

        binding.signUpButton.setOnClickListener {
            startActivity(SignUpActivity.createIntent(this.applicationContext))
        }
    }
}
