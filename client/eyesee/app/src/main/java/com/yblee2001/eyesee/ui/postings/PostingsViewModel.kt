package com.yblee2001.eyesee.ui.postings

import android.media.Image
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yblee2001.eyesee.dto.posting.ReturnPostingDto
import com.yblee2001.eyesee.service.PostingService
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File

class PostingsViewModel @ViewModelInject constructor(
    private val postingService: PostingService
) : ViewModel() {

    fun getPostingsByCategory(category: String) =
        postingService.getPostingsByCategory(category)
            .subscribeOn(Schedulers.io())

    fun createPosting(text: String, category: String, image: File?) =
        postingService.createPosting(text, category, image)
            .subscribeOn(Schedulers.io())

}