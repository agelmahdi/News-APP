package com.agelmahdi.newsapp.Repository

import com.agelmahdi.newsapp.API.RetrofitInstance
import com.agelmahdi.newsapp.Model.NewsModel.Article
import com.agelmahdi.newsapp.Room.ArticleDB

class NewsRepository(
    val db: ArticleDB
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(countryCode, pageNumber)

    suspend fun updateOrInsert(article: Article) =
        db.getArticleDAO().insertOrUpdate(article)

    suspend fun deleteArticle(article: Article) =
        db.getArticleDAO().deleteArticle(article)

    fun getSavedNews() =
        db.getArticleDAO().getAllArticles()
}