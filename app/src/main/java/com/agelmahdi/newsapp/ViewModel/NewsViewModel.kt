package com.agelmahdi.newsapp.ViewModel

import androidx.lifecycle.ViewModel
import com.agelmahdi.newsapp.Repository.NewsRepository

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {
}