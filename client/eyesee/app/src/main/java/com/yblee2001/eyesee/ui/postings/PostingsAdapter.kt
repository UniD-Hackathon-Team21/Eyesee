package com.yblee2001.eyesee.ui.postings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yblee2001.eyesee.R
import com.yblee2001.eyesee.dto.posting.ReturnPostingDto
import kotlinx.android.synthetic.main.item_posting.view.*

class PostingsAdapter(private val context: Context) :
    RecyclerView.Adapter<PostingsViewHolder>() {

    var postings: MutableList<ReturnPostingDto> = mutableListOf(
        ReturnPostingDto(1, 1, "Campbell 생명의 원리 p.127 Figure 14.1 사진 설명 부탁드립니다 ㅠㅠ", null, "자연과학", null, "2021.11.07"),
        ReturnPostingDto(1, 1, "Campbell 생명의 원리 p.127 Figure 14.1 사진 설명 부탁드립니다 ㅠㅠ", null, "자연과학", null, "2021.11.07"),
        ReturnPostingDto(1, 1, "Campbell 생명의 원리 p.127 Figure 14.1 사진 설명 부탁드립니다 ㅠㅠ", null, "자연과학", null, "2021.11.07"),
        ReturnPostingDto(1, 1, "Campbell 생명의 원리 p.127 Figure 14.1 사진 설명 부탁드립니다 ㅠㅠ", null, "자연과학", null, "2021.11.07"),
        ReturnPostingDto(1, 1, "Campbell 생명의 원리 p.127 Figure 14.1 사진 설명 부탁드립니다 ㅠㅠ", null, "자연과학", null, "2021.11.07"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostingsViewHolder =
        LayoutInflater.from(context)
            .inflate(R.layout.item_posting, parent, false)
            .let{ PostingsViewHolder(it) }

    override fun getItemCount(): Int = postings.size

    override fun onBindViewHolder(holder: PostingsViewHolder, position: Int) {
        val posting = postings[position]

        // set item view
        holder.content.text = posting.text

        // TODO: multipart form data...
        // holder.image

        holder.itemView.setOnClickListener{
            context.startActivity(PostingDetailActivity.createIntent(context, posting.id))
        }
    }

//    fun submitList(newData: MutableList<ReturnPostingDto>) {
//        postings.clear()
//        postings.addAll(newData)
//        notifyDataSetChanged()
//    }
}

class PostingsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var content: TextView = view.content
    var image: ImageView? = view.image
}