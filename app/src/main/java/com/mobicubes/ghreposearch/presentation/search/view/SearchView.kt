package com.mobicubes.ghreposearch.presentation.search.view

import com.mobicubes.ghreposearch.domain.entity.UserItem
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.ItemViewModel
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.SearchViewModel

/**
 * Created by kuba on 11/03/2018.
 */

interface SearchView {

    fun setListener(listener: Listener)

    fun setViewModel(viewModel: SearchViewModel)

    fun goToUserDetail(user: UserItem)

    fun displayMessage(message: String)

    interface Listener {
        fun onQueryChanged(query: String)
        fun onItemClick(item: ItemViewModel)
    }
}