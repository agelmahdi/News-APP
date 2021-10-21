package com.agelmahdi.newsapp.Repository

import com.agelmahdi.newsapp.API.RetrofitInstance
import com.agelmahdi.newsapp.Room.ArticleDB

class NewsRepository(
    val db: ArticleDB
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(countryCode, pageNumber)
}