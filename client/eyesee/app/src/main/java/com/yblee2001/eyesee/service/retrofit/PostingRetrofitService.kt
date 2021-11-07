package com.yblee2001.eyesee.service.retrofit

import com.yblee2001.eyesee.dto.comment.CreateCommentDto
import com.yblee2001.eyesee.dto.posting.CreatePostingDto
import com.yblee2001.eyesee.dto.posting.ReturnPostingDto
import com.yblee2001.eyesee.dto.posting.UpdatePostingDto
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface PostingRetrofitService {

    // get all postings
    @GET("/api/postings")
    fun getPostings(): Observable<List<ReturnPostingDto>>

    // create posting
    @PUT("/api/postings")
    fun createPosting(
        @Body Body: CreatePostingDto
    ): Single<ReturnPostingDto>

    // get all postings by category
    @GET("/api/postings/category/{category}")
    fun getPostingsByCategory(
        @Path("category") category: String
    ): Observable<List<ReturnPostingDto>>


    // get posting by id
    @GET("/api/postings/{id}")
    fun getPostingById(
        @Path("id") id: Int
    ): Single<ReturnPostingDto>

    // edit posting
    @PUT("/api/postings/{id}")
    fun editPosting(
        @Path("id") id: Int,
        @Body Body: UpdatePostingDto
    ): Single<ReturnPostingDto>

    // delete posing
    @DELETE("/api/postings/{id}")
    fun deletePosting(
        @Path("id") id: Int
    )

    // create comment
    @POST("/api/postings/{id}/comments")
    fun createComment(
        @Path("id") postingId: Int,
        @Body Body: CreateCommentDto
    ): Single<ReturnPostingDto>

    // delete comment
    @DELETE("/api/postings/{id}/comments/{commentId}")
    fun deleteComment(
        @Path("id") postingId: Int,
        @Path("commentId") commentId: Int
    ): Single<ReturnPostingDto>

    // like comment
    @GET("/api/postings/{id}/comments/{commentId}/like")
    fun likeComment(
        @Path("id") postingId: Int,
        @Path("commentId") commentId: Int
    ): Single<ReturnPostingDto>

}