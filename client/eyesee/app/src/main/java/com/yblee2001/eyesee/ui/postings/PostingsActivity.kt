package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yblee2001.eyesee.databinding.ActivityPostingsBinding
import com.yblee2001.eyesee.dto.posting.ReturnPostingDto
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

@AndroidEntryPoint
class PostingsActivity : AppCompatActivity() {

    companion object {
        private const val CATEGORY_KEY = "category"
        fun createIntent(context: Context, category: String): Intent {
            return Intent(context, PostingsActivity::class.java).apply {
                putExtra(CATEGORY_KEY, category)
            }
        }
    }

    private lateinit var binding: ActivityPostingsBinding
    private lateinit var adapter: PostingsAdapter
    private val viewModel: PostingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra(CATEGORY_KEY) ?: ""

        buildRecyclerView()

        // update view
//        viewModel.getPostingsByCategory(category)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                adapter.submitList(it as MutableList<ReturnPostingDto>)
//            },{
//                Timber.d(it)
//            })

        // create new posting
        binding.writeButton.setOnClickListener {
            startActivity(NewPostingActivity.createIntent(this, category))
        }

    }

    private fun buildRecyclerView() {
        adapter = PostingsAdapter(this)
        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }
    }
}
