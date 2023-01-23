package com.example.testtaskbooksearch.model_data

    data class SearchListResponse(val items: List<VolumeInfo>)
    data class VolumeInfo(val volumeInfo: BookInfo)
    data class BookInfo(val title: String, val subtitle: String, val publishedDate: String, val description: String,val categories: List<String>, val authors: List<String>, val imageLinks: ImageLinks)
    data class ImageLinks(val smallThumbnail: String)

