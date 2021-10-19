package com.agelmahdi.newsapp.Model.NewsModel

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)