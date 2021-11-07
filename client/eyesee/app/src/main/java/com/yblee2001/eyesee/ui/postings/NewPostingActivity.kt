package com.yblee2001.eyesee.ui.postings

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yblee2001.eyesee.databinding.ActivityNewPostingBinding
import com.yblee2001.eyesee.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

@AndroidEntryPoint
class NewPostingActivity : AppCompatActivity() {

    companion object {
        private const val CATEGORY_KEY = "category"
        fun createIntent(context: Context, category: String): Intent {
            return Intent(context, NewPostingActivity::class.java).apply {
                putExtra(CATEGORY_KEY, category)
            }
        }
    }

    private lateinit var binding: ActivityNewPostingBinding
    private val viewModel: PostingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPostingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra(CATEGORY_KEY) ?: ""

        // TODO: IMAGE!!!
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 555,)
//        }
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
//        startActivityForResult(intent, 1126)

        binding.submitButton.setOnClickListener {
            val text = binding.content.text.toString()
            finish()
//            viewModel.createPosting(text, category, null)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    Toast.makeText(this, "post created", Toast.LENGTH_LONG).show()
//                    finish()
//                }, {
//                    Toast.makeText(this, "failed to create post", Toast.LENGTH_LONG).show()
//                })
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == 1126 && resultCode == Activity.RESULT_OK) {
//            data?.data?.let {
//                if (!viewModel.addUri(it)) {
//                    Toast.makeText(this, "post created", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }

}
