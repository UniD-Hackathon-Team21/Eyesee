package com.yblee2001.eyesee.model

import java.sql.Time

data class Comment (
    val id: Int,
    val userId: Int,
    val content: String,
    val posting: String,
    val createdAt: Time,
)