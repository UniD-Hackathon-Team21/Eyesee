package com.yblee2001.eyesee.dto.posting

import android.media.Image
import android.text.Html

data class CreatePostingDto (
    val text: String,
    val category: String,
    // multipart-form data (json ㄴㄴ)
    val image: Image?,
)