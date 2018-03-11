package com.mobicubes.ghreposearch.presentation.search

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobicubes.ghreposearch.MyApplication
import com.mobicubes.ghreposearch.R
import com.mobicubes.ghreposearch.databinding.ViewSearchBinding
import com.mobicubes.ghreposearch.presentation.search.di.SearchActivityModule
import com.mobicubes.ghreposearch.presentation.search.presenter.SearchPresenter
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import javax.inject.Inject

class SearchActivity : AppCompatActivity(), SearchView {

    private lateinit var binding: ViewSearchBinding

    override fun search() {
        return
    }

    @Inject lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.view_search)

        (applicationContext as MyApplication).appComponent
                .plus(SearchActivityModule(this))
                .inject(this)

        setListener(presenter)
        setViewModel()
    }

    override fun setListener(listener: SearchView.Listener) {
        binding.listener = listener
    }

    fun setViewModel() {
        binding.viewModel = presenter.viewModel
    }
}
