package com.example.login.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://picsum.photos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}