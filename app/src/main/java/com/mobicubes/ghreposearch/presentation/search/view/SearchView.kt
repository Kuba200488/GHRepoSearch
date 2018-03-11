package com.mobicubes.ghreposearch.presentation.search.view

import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.ItemViewModel

/**
 * Created by kuba on 11/03/2018.
 */

interface SearchView {
    fun search()

    fun setListener(listener: Listener)

    interface Listener {
        fun onQueryChanged(query: String)
        fun onItemClick(item: ItemViewModel)
    }
}