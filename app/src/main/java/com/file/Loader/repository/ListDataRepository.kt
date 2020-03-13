package com.file.Loader.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.file.Loader.model.PasteBinDataResponse
import retrofit2.Response

interface ListDataRepository {

    fun fetchImageList()
    fun getImageList(): LiveData<ArrayList<PasteBinDataResponse>>
}