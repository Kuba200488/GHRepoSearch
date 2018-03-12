package com.mobicubes.ghreposearch.presentation.search.view.viewmodel

import com.mobicubes.ghreposearch.domain.entity.UserItem

/**
 * Created by kuba on 12/03/2018.
 */
class UserViewModel(val user: UserItem) : ItemViewModel {
    override fun getId() = user.id
    override fun getType() = ItemViewModel.Type.USER
    override fun getTitle() = user.login
}