package com.yblee2001.eyesee.di

import com.squareup.moshi.Moshi
import com.yblee2001.eyesee.BuildConfig
import com.yblee2001.eyesee.service.PostingService
import com.yblee2001.eyesee.service.UserService
import com.yblee2001.eyesee.service.retrofit.PostingRetrofitService
import com.yblee2001.eyesee.service.retrofit.UserRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    private val baseURL = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .client(okHttpClient)
            .baseUrl(baseURL)
            .build()

    // creates retrofit & provide services
    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return UserService(retrofit.create(UserRetrofitService::class.java))
    }

    @Provides
    @Singleton
    fun providePostingService(retrofit: Retrofit): PostingService {
        return PostingService(retrofit.create(PostingRetrofitService::class.java))
    }

}
