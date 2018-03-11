package com.mobicubes.ghreposearch.presentation.search.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobicubes.ghreposearch.R
import com.mobicubes.ghreposearch.databinding.ItemResultBinding
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.ItemViewModel

/**
 * Created by kuba on 11/03/2018.
 */

class ResultAdapter(val items: List<ItemViewModel>, val listener: SearchView.Listener?) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding: ItemResultBinding = DataBindingUtil.inflate(inflater, R.layout.item_result, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size
}