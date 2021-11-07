package com.yblee2001.eyesee.ui.login

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getText
import com.yblee2001.eyesee.databinding.ActivityLoginBinding
import com.yblee2001.eyesee.ui.MainActivity
import com.yblee2001.eyesee.ui.user.MyPostingsActivity
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.idEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    startActivity(MainActivity.createIntent(this.applicationContext))
                    finish()
                },{
                    //TODO: show message
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                })
        }

        binding.signUpButton.setOnClickListener {
            startActivity(SignUpActivity.createIntent(this.applicationContext))
            finish()
        }
    }
}
