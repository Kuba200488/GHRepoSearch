package com.mobicubes.ghreposearch.presentation.search.presenter

import com.mobicubes.ghreposearch.domain.entity.RepositoryItem
import com.mobicubes.ghreposearch.domain.entity.UserItem
import com.mobicubes.ghreposearch.domain.interactor.SearchRepositoriesUseCase
import com.mobicubes.ghreposearch.domain.interactor.SearchUsersUseCase
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.ItemViewModel
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.RepositoryViewModel
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.SearchViewModel
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.UserViewModel
import com.mobicubes.ghreposearch.util.ErrorMapper
import io.reactivex.observers.DisposableObserver

/**
 * Created by kuba on 11/03/2018.
 */

class SearchPresenter(
        val view: SearchView,
        private val searchUsersUseCase: SearchUsersUseCase,
        private val searchRepositoriesUseCase: SearchRepositoriesUseCase
) : SearchView.Listener {

    var repositories: List<RepositoryItem>? = null
    var users: List<UserItem>? = null

    val viewModel: SearchViewModel = SearchViewModel(this)

    fun onCreate() {
        view.setListener(this)
        view.setViewModel(viewModel)
    }

    override fun onItemClick(item: ItemViewModel) {
        when (item) {
            is UserViewModel -> view.goToUserDetail(item.user)
            else -> return
        }
    }

    override fun onQueryChanged(query: String) {
        searchResults(query)
    }

    private fun searchResults(query: String) {
        clearLists()
        searchUsersUseCase.execute(query, object : DisposableObserver<List<UserItem>>() {
            override fun onError(e: Throwable) {
                displayError(e)
            }

            override fun onComplete() {}

            override fun onNext(t: List<UserItem>) {
                users = t
                updateViewModel()
            }
        })

        searchRepositoriesUseCase.execute(query, object : DisposableObserver<List<RepositoryItem>>() {
            override fun onError(e: Throwable) {
                displayError(e)
            }

            override fun onComplete() {}

            override fun onNext(t: List<RepositoryItem>) {
                repositories = t
                updateViewModel()
            }
        })
    }

    private fun displayError(e: Throwable) {
        view.displayMessage("Error: ${ErrorMapper.mapThrowable(e)}")
    }

    private fun updateViewModel() {

        if (users == null || repositories == null) {
            return
        }

        val joined = ArrayList<ItemViewModel>()

        joined.addAll(users!!.map { UserViewModel(it) })
        joined.addAll(repositories!!.map { RepositoryViewModel(it) })

        viewModel.updateItems(joined.sortedWith(compareBy(ItemViewModel::getId)))
    }

    private fun clearLists() {
        users = null
        repositories = null
    }
}