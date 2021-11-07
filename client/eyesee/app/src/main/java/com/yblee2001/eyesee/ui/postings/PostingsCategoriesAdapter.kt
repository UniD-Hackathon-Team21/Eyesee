package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yblee2001.eyesee.R
import com.yblee2001.eyesee.ui.user.MyPostingsActivity
import kotlinx.android.synthetic.main.item_category.view.*
import timber.log.Timber

class PostingsCategoriesAdapter(private val context: Context) :
    RecyclerView.Adapter<PostingsCategoriesViewHolder>() {

    var categories: List<String> = listOf(
        "공학", "자연과학", "의학", "인문계열", "상경", "예술", "체육", "사회과학", "농업", "법"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostingsCategoriesViewHolder =
        LayoutInflater.from(context)
            .inflate(R.layout.item_category, parent, false)
            .let{ PostingsCategoriesViewHolder(it) }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: PostingsCategoriesViewHolder, position: Int) {
        val category = categories[position]

        // set item view
        holder.name.text = category
        Timber.d(category)
        holder.itemView.setOnClickListener{
            // TODO: category query
            context.startActivity(PostingsActivity.createIntent(context, category))
        }
    }
}

class PostingsCategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.category_name
}