package com.mobicubes.ghreposearch.presentation.search

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.mobicubes.ghreposearch.MyApplication
import com.mobicubes.ghreposearch.R
import com.mobicubes.ghreposearch.databinding.ViewSearchBinding
import com.mobicubes.ghreposearch.domain.entity.UserItem
import com.mobicubes.ghreposearch.presentation.BaseActivity
import com.mobicubes.ghreposearch.presentation.search.di.SearchActivityModule
import com.mobicubes.ghreposearch.presentation.search.presenter.SearchPresenter
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.SearchViewModel
import com.mobicubes.ghreposearch.presentation.userdetail.UserDetailActivity
import com.mobicubes.ghreposearch.presentation.userdetail.param.UserDetailParam
import javax.inject.Inject

class SearchActivity : BaseActivity(), SearchView {

    private lateinit var binding: ViewSearchBinding

    @Inject lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as MyApplication).appComponent
                .plus(SearchActivityModule(this))
                .inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.view_search)

        presenter.onCreate()
    }

    override fun goToUserDetail(user: UserItem) {
        val intent = Intent(this, UserDetailActivity::class.java)
        intent.putExtra(UserDetailActivity.EXTRA, UserDetailParam(user))
        startActivity(intent)
    }

    override fun setListener(listener: SearchView.Listener) {
        binding.listener = listener
    }

    override fun setViewModel(viewModel: SearchViewModel) {
        binding.viewModel = viewModel
    }
}
