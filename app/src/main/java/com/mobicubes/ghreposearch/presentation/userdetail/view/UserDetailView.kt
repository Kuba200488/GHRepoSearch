package com.mobicubes.ghreposearch.presentation.userdetail.view

import com.mobicubes.ghreposearch.presentation.BaseView
import com.mobicubes.ghreposearch.presentation.userdetail.view.viewmodel.UserDetailViewModel

/**
 * Created by kuba on 11/03/2018.
 */
interface UserDetailView : BaseView {

    fun setViewModel(viewModel: UserDetailViewModel)
}