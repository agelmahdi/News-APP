package com.agelmahdi.newsapp.Model.NewsModel

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)