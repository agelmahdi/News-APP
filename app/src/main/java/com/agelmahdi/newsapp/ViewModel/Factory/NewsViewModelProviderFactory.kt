package com.agelmahdi.newsapp.ViewModel.Factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agelmahdi.newsapp.NewsApplication
import com.agelmahdi.newsapp.Repository.NewsRepository
import com.agelmahdi.newsapp.ViewModel.NewsViewModel


/*
*  - ViewModelProvider.Factory is responsible to create your instance of ViewModel.
*  - If your ViewModel have dependencies and you want to test your ViewModel
*       then you should create your own ViewModelProvider.Factory and passed dependency through ViewModel constructor
*       and give value to the ViewModelProvider.Factory instance.
* */

class NewsViewModelProviderFactory(val app: Application,val newsRepository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app,newsRepository) as T
    }
}