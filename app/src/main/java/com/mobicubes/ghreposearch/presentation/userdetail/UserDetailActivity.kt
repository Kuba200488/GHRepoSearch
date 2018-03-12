package com.mobicubes.ghreposearch.presentation.userdetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.mobicubes.ghreposearch.MyApplication
import com.mobicubes.ghreposearch.R
import com.mobicubes.ghreposearch.databinding.ViewUserDetailBinding
import com.mobicubes.ghreposearch.presentation.BaseActivity
import com.mobicubes.ghreposearch.presentation.userdetail.di.UserDetailActivityModule
import com.mobicubes.ghreposearch.presentation.userdetail.param.UserDetailParam
import com.mobicubes.ghreposearch.presentation.userdetail.presenter.UserDetailPresenter
import com.mobicubes.ghreposearch.presentation.userdetail.view.UserDetailView
import com.mobicubes.ghreposearch.presentation.userdetail.view.viewmodel.UserDetailViewModel
import javax.inject.Inject

/**
 * Created by kuba on 11/03/2018.
 */
class UserDetailActivity : BaseActivity(), UserDetailView {

    companion object {
        val EXTRA = "USER_DETAIL_EXTRA"
    }

    private lateinit var binding: ViewUserDetailBinding

    @Inject lateinit var presenter: UserDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as MyApplication).appComponent
                .plus(UserDetailActivityModule(this))
                .inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.view_user_detail)

        presenter.onCreate()
    }

    fun getExtra() = intent.getSerializableExtra(EXTRA) as UserDetailParam

    override fun setViewModel(viewModel: UserDetailViewModel) {
        binding.viewModel = viewModel
    }
}