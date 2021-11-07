package com.yblee2001.eyesee.dto.posting

import com.yblee2001.eyesee.dto.comment.ReturnCommentDto

data class ReturnPostingDto(
    val id: Int,
    val userId: Int,
    val text: String,
    val imgPath: String?,
    val category: String,
    val comments: List<ReturnCommentDto>?,
    val createdAt: String
)