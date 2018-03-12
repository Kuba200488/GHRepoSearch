package com.mobicubes.ghreposearch.presentation.userdetail.presenter

import com.mobicubes.ghreposearch.presentation.userdetail.param.UserDetailParam
import com.mobicubes.ghreposearch.presentation.userdetail.view.UserDetailView
import com.mobicubes.ghreposearch.presentation.userdetail.view.viewmodel.UserDetailViewModel

/**
 * Created by kuba on 11/03/2018.
 */
class UserDetailPresenter(
        val view: UserDetailView,
        val param: UserDetailParam
) {
    private val viewModel = UserDetailViewModel(param.user)

    fun onCreate() {
        view.setViewModel(viewModel)
    }
}