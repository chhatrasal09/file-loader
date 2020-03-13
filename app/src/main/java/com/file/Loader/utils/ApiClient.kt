package com.file.Loader.utils

import com.file.Loader.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var sApiService: ApiService? = null

    fun init() {
        sApiService = Retrofit.Builder()
            .baseUrl("http://www.pastebin.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getApiService(): ApiService {
        if (sApiService == null) {
            init()
        }
        return sApiService!!
    }
}