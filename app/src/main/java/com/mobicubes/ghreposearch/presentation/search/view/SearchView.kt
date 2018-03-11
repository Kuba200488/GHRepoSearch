package com.mobicubes.ghreposearch.presentation.search.view

/**
 * Created by kuba on 11/03/2018.
 */

interface SearchView {
    fun search()

    fun setListener(listener: Listener)

    interface Listener {
        fun onQueryChanged(query: String)
    }
}