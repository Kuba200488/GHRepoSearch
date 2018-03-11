package com.mobicubes.ghreposearch.presentation.search.presenter

import android.util.Log
import com.mobicubes.ghreposearch.domain.entity.UserItem
import com.mobicubes.ghreposearch.domain.interactor.SearchRepositoriesUseCase
import com.mobicubes.ghreposearch.domain.interactor.SearchUsersUseCase
import com.mobicubes.ghreposearch.presentation.search.view.SearchView
import com.mobicubes.ghreposearch.presentation.search.view.viewmodel.SearchViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by kuba on 11/03/2018.
 */

class SearchPresenter(
        val view: SearchView,
        val searchUsersUseCase: SearchUsersUseCase,
        val searchRepositoriesUseCase: SearchRepositoriesUseCase
) : SearchView.Listener {

    val viewModel: SearchViewModel = SearchViewModel()

    override fun onQueryChanged(query: String) {
        searchUsersUseCase.execute(query, object : DisposableObserver<List<UserItem>>() {
            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

            override fun onNext(t: List<UserItem>) {
                Log.d("RECEIVED", "${t.size}")
            }

        })
    }
}