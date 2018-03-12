package com.mobicubes.ghreposearch.presentation.search.view.viewmodel

/**
 * Created by kuba on 11/03/2018.
 */
interface ItemViewModel {

    fun getId(): Long
    fun getType(): Type
    fun getTitle(): String

    enum class Type { USER, REPOSITORY }
}