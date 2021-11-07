package com.yblee2001.eyesee.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.yblee2001.eyesee.dto.user.ReturnUserDto
import com.yblee2001.eyesee.service.UserService
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class SignUpViewModel @ViewModelInject constructor(
    private val userService: UserService
) : ViewModel() {

    // sign up
    fun signUp(name: String, email: String, password: String, confirm: String): Single<ReturnUserDto> =
        userService.signUp(name, email, password, confirm)
            .subscribeOn(Schedulers.io())

}