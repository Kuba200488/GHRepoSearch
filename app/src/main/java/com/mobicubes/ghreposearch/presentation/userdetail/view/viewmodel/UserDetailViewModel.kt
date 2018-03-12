package com.mobicubes.ghreposearch.presentation.userdetail.view.viewmodel

import android.databinding.BaseObservable
import com.mobicubes.ghreposearch.domain.entity.UserItem

/**
 * Created by kuba on 11/03/2018.
 */
class UserDetailViewModel(
        val user: UserItem
) : BaseObservable() {
    fun getName() = user.login
    fun getImageUrl() = user.avatarUrl
}