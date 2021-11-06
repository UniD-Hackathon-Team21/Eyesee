package com.yblee2001.eyesee.model

data class User (
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val confirm: String,
)