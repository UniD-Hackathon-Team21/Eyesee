package com.yblee2001.eyesee.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.yblee2001.eyesee.service.UserService
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel @ViewModelInject constructor(
    private val userService: UserService
) : ViewModel() {

    // login
    fun login(email: String, password: String): Completable =
        userService.login(email, password)
            .subscribeOn(Schedulers.io())

}