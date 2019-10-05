package com.inovaceds.finotej.net.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inovaceds.finotej.net.DataConfiguration
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        })
        .build()

    private val gson: Gson = GsonBuilder()
        .create()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .baseUrl(DataConfiguration.HOST)
        .build()

    public inline fun <reified T> create(): T {
        return retrofit.create(T::class.java)
    }
}