package com.yblee2001.eyesee.model

import org.w3c.dom.Comment
import java.sql.Time

data class Posting (
    val id: Int,
    val userId: Int,
    val text: String,
    val imgPath: String?,
    val category: String,
    val comments: List<Comment>?,
    val createdAt: Time,
)