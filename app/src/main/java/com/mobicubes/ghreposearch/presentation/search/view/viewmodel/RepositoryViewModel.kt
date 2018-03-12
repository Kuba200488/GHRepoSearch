package com.mobicubes.ghreposearch.presentation.search.view.viewmodel

import com.mobicubes.ghreposearch.domain.entity.RepositoryItem

/**
 * Created by kuba on 12/03/2018.
 */
class RepositoryViewModel(private val repository: RepositoryItem) : ItemViewModel {
    override fun getId() = repository.id
    override fun getType() = ItemViewModel.Type.REPOSITORY
    override fun getTitle() = repository.name
}