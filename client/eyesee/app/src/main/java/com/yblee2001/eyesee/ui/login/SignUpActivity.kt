package com.yblee2001.eyesee.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yblee2001.eyesee.databinding.ActivitySignUpBinding
import com.yblee2001.eyesee.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, SignUpActivity::class.java)
    }

    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val confirm = binding.confirm.text.toString()

            if (password == confirm) {
                viewModel.signUp(name, email, password, confirm)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        startActivity(MainActivity.createIntent(this.applicationContext))
                        finish()
                    },{
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    })
            } else {
                Toast.makeText(this, "패스워드를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
