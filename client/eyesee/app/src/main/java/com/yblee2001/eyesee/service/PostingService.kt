package com.yblee2001.eyesee.service

import android.media.Image
import com.yblee2001.eyesee.dto.comment.CreateCommentDto
import com.yblee2001.eyesee.dto.posting.CreatePostingDto
import com.yblee2001.eyesee.dto.posting.UpdatePostingDto
import com.yblee2001.eyesee.service.retrofit.PostingRetrofitService
import java.io.File

class PostingService(
    private val postingRetrofitService: PostingRetrofitService
) {

    // get all postings
    fun getPostings() = postingRetrofitService.getPostings()

    // create posting
    fun createPosting(
        text: String,
        category: String,
        image: File?
    ) = postingRetrofitService.createPosting(CreatePostingDto(text, category, image))

    // get all postings by category
    fun getPostingsByCategory(
        category: String
    ) = postingRetrofitService.getPostingsByCategory(category)

    // get posting by id
    fun getPostingById(
        id: Int
    ) = postingRetrofitService.getPostingById(id)

    // edit posting
    fun editPosting(
        id: Int,
        text: String?,
        category: String?,
        image: Image?
    ) = postingRetrofitService.editPosting(id, UpdatePostingDto(text, category, image))

    // delete posting
    fun deletePosting(
        id: Int
    ) = postingRetrofitService.deletePosting(id)

    // create comment
    fun createComment(
        postingId: Int,
        content: String
    ) = postingRetrofitService.createComment(postingId, CreateCommentDto(content))

    // delete comment
    fun deleteComment(
        postingId: Int,
        commentId: Int
    ) = postingRetrofitService.deleteComment(postingId, commentId)

    // like comment
    fun likeComment(
        postingId: Int,
        commentId: Int
    ) = postingRetrofitService.likeComment(postingId, commentId)

}