package com.yblee2001.eyesee.service

import com.yblee2001.eyesee.dto.user.CreateUserDto
import com.yblee2001.eyesee.dto.user.LoginUserDto
import com.yblee2001.eyesee.dto.user.UpdateUserDto
import com.yblee2001.eyesee.service.retrofit.UserRetrofitService

class UserService (
    private val userRetrofitService: UserRetrofitService
) {

    // get my user profile
    fun getCurrentUser() = userRetrofitService.getCurrentUser()

    // user login
    fun login(
        email: String,
        password: String
    ) = userRetrofitService.login(LoginUserDto(email, password))

    // user logout
    fun logout() = userRetrofitService.logout()

    // user sign up
    fun signUp(
        name: String,
        email: String,
        password: String,
        confirm: String
    ) = userRetrofitService.signUp(CreateUserDto(name, email, password, confirm))

    // edit user info
    fun updateUser(
        id: Int,
        name: String?,
        email: String?,
        password: String?,
        confirm: String?
    ) = userRetrofitService.updateUser(
        id,
        UpdateUserDto(name, email, password, confirm)
    )

    // user delete
    fun deleteUser(
        id: Int
    ) = userRetrofitService.deleteUser(id)

}