package com.file.Loader.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.file.Loader.model.PasteBinDataResponse
import com.file.Loader.repository.ListDataRepository
import com.file.Loader.repository.ListDataRepositoryImpl

class ListViewModel : ViewModel() {
    private val mRepo: ListDataRepository = ListDataRepositoryImpl()
    fun getImageList(): LiveData<ArrayList<PasteBinDataResponse>> = mRepo.getImageList()
    fun fetchImageList() = mRepo.fetchImageList()
}