package com.yblee2001.eyesee.dto.comment

import com.yblee2001.eyesee.dto.posting.ReturnPostingDto
import com.yblee2001.eyesee.model.Posting

data class ReturnCommentDto(
    val id: Int,
    val userId: Int,
    val content: String,
    val likes: Int,
    val likedUsers: MutableList<String>?,
    val reports: Int,
    val posting: ReturnPostingDto,
    val createdAt: String
)