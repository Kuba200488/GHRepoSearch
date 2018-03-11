package com.mobicubes.ghreposearch.presentation.search.view.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.mobicubes.ghreposearch.BR
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import com.mobicubes.ghreposearch.presentation.search.view.adapter.ResultAdapter
import java.util.*

/**
 * Created by kuba on 11/03/2018.
 */
class SearchViewModel(val listener: SearchView.Listener) : BaseObservable() {

    var items: List<ItemViewModel> = Collections.emptyList()

    fun updateItems(newItems: List<ItemViewModel>) {
        items = newItems
        notifyPropertyChanged(BR.adapter)
    }

    var query: String = ""

    val adapter: ResultAdapter
        @Bindable get() = ResultAdapter(items, listener)
}