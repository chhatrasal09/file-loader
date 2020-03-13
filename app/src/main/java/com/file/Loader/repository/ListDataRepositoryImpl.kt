package com.file.Loader.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.file.Loader.model.PasteBinDataResponse
import com.file.Loader.utils.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class ListDataRepositoryImpl : ListDataRepository, CoroutineScope {
    val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    val mIoContext: CoroutineContext = Dispatchers.IO
    val mApiService = ApiClient.getApiService()
    val imageList: MutableLiveData<ArrayList<PasteBinDataResponse>> = MutableLiveData()

    override fun fetchImageList() {
        CoroutineScope(mIoContext).launch {
            try {
                val response = mApiService.getImageList()
                if (response?.isSuccessful == true) {
                    val result = response?.body()
                    imageList.postValue(result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getImageList(): LiveData<ArrayList<PasteBinDataResponse>> = imageList
}