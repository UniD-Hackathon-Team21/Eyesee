package com.yblee2001.eyesee.service.retrofit

import com.yblee2001.eyesee.dto.user.CreateUserDto
import com.yblee2001.eyesee.dto.user.LoginUserDto
import com.yblee2001.eyesee.dto.user.ReturnUserDto
import com.yblee2001.eyesee.dto.user.UpdateUserDto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface UserRetrofitService {

    // get my user profile
    @GET("/api/users/me")
    fun getCurrentUser(): Single<ReturnUserDto>

    // user login
    @POST("/api/users/login")
    fun login(
        @Body Body: LoginUserDto
    ): Completable

    // user logout
    @GET("/api/users/logout")
    fun logout()

    // user sign up
    @POST("/api/users/signup")
    fun signUp(
        @Body Body: CreateUserDto
    ): Single<ReturnUserDto>

    // edit user info
    @PUT("/api/users/{id}")
    fun updateUser(
        @Path("id") id: Int,
        @Body Body: UpdateUserDto
    ): Single<ReturnUserDto>

    // user delete
    @DELETE("/api/users/{id}")
    fun deleteUser(
        @Path("id") id: Int
    ): Single<ReturnUserDto>

}