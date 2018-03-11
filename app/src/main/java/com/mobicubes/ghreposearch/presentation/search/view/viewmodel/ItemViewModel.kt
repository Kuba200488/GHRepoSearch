package com.mobicubes.ghreposearch.presentation.search.view.viewmodel

import com.mobicubes.ghreposearch.domain.entity.RepositoryItem
import com.mobicubes.ghreposearch.domain.entity.UserItem

/**
 * Created by kuba on 11/03/2018.
 */
class ItemViewModel(
        val id: Long,
        val title: String,
        val type: Type
) {
    constructor(user: UserItem) : this(user.id, user.login, Type.USER)
    constructor(repository: RepositoryItem) : this(repository.id, repository.name, Type.REPOSITORY)

    enum class Type { USER, REPOSITORY }
}