package com.example.testtaskbooksearch.search_books

import com.example.testtaskbooksearch.model_data.SearchListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchApi {

    @GET("volumes")
    @Headers("Content-Type: application/json")
    fun getSearchList(@Query("q") title: String): Single<SearchListResponse>
}

//&maxResults=5&startIndex=1