package com.yblee2001.eyesee.dto.posting

import android.media.Image
import android.text.Html
import java.io.File

data class CreatePostingDto (
    val text: String,
    val category: String,
    // multipart-form data (json ㄴㄴ)
    val image: File?,
)