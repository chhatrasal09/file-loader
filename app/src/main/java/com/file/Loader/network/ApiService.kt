package com.file.Loader.network

import com.file.Loader.model.PasteBinDataResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("raw/wgkJgazE")
    suspend fun getImageList(): Response<ArrayList<PasteBinDataResponse>>?

    @GET("raw/wgkJgazE")
    fun fetchImageList(): Observable<ArrayList<PasteBinDataResponse>>
}