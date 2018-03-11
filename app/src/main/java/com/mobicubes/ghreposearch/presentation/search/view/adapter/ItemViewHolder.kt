package com.mobicubes.ghreposearch.presentation.search.view.adapter

import android.support.v7.widget.RecyclerView
import com.mobicubes.ghreposearch.databinding.ItemResultBinding
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.ItemViewModel

/**
 * Created by kuba on 11/03/2018.
 */
class ItemViewHolder(val binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: ItemViewModel, listener: SearchView.Listener?) {
        binding.viewModel = itemViewModel
        binding.listener = listener
    }
}