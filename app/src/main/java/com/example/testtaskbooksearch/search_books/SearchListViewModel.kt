package com.example.testtaskbooksearch.search_books

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.testtaskbooksearch.model_data.SearchListResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchListViewModel(application: Application): AndroidViewModel(application) {


    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchSearchList(searchApi: SearchApi, title: String): Single<SearchListResponse> {
        return searchApi.getSearchList(title)
    }

}
