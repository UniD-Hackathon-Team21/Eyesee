package com.yblee2001.eyesee.dto.posting

import android.media.Image

data class UpdatePostingDto (
    val text: String?,
    val category: String?,
    val image: Image?
)