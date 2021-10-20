package com.agelmahdi.newsapp.View.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.agelmahdi.newsapp.R
import com.agelmahdi.newsapp.View.Activities.NewsActivity
import com.agelmahdi.newsapp.ViewModel.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    lateinit var newsViewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = (activity as NewsActivity).viewModel
    }
}