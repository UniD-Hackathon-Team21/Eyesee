package com.yblee2001.eyesee.dto.user

data class CreateUserDto (
    val name: String,
    val email: String,
    val password: String,
    val confirm: String,
)