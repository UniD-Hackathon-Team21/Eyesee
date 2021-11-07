package com.yblee2001.eyesee.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.yblee2001.eyesee.R
import com.yblee2001.eyesee.databinding.ActivityMainBinding
import com.yblee2001.eyesee.ui.postings.PostingsFragment
import com.yblee2001.eyesee.ui.user.MyPostingsActivity
import com.yblee2001.eyesee.ui.user.UserFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<PostingsFragment>(R.id.fragment_container_view)
            }
        }

        binding.bottomNavigationView.selectedItemId = R.id.bottom_menu_postings

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_menu_postings -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<PostingsFragment>(R.id.fragment_container_view)
                    }
                    Timber.d("POSTINGS")
                    true
                }
                R.id.bottom_menu_user -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<UserFragment>(R.id.fragment_container_view)
                    }
                    Timber.d("USER")
                    true
                }
                else -> { false }
            }
        }

    }
}
