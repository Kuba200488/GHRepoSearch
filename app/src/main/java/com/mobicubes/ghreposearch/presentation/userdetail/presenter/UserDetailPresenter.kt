package com.mobicubes.ghreposearch.presentation.userdetail.presenter

import com.mobicubes.ghreposearch.domain.interactor.GetFollowersCountUseCase
import com.mobicubes.ghreposearch.domain.interactor.GetStarsCountUseCase
import com.mobicubes.ghreposearch.presentation.userdetail.param.UserDetailParam
import com.mobicubes.ghreposearch.presentation.userdetail.view.UserDetailView
import com.mobicubes.ghreposearch.presentation.userdetail.view.viewmodel.UserDetailViewModel
import com.mobicubes.ghreposearch.util.ErrorMapper
import io.reactivex.observers.DisposableObserver

/**
 * Created by kuba on 11/03/2018.
 */
class UserDetailPresenter(
        val view: UserDetailView,
        private val param: UserDetailParam,
        private val getFollowersCountUseCase: GetFollowersCountUseCase,
        private val getStarsCountUseCase: GetStarsCountUseCase
) {
    private val viewModel = UserDetailViewModel(param.user)

    fun onCreate() {
        view.setViewModel(viewModel)

        getFollowersCountUseCase.execute(param.user.login, object : DisposableObserver<Long>() {
            override fun onError(e: Throwable) {
                displayError(e)
            }

            override fun onComplete() {}

            override fun onNext(t: Long) {
                viewModel.followersCount = t
            }
        })

        getStarsCountUseCase.execute(param.user.login, object : DisposableObserver<Long>() {
            override fun onError(e: Throwable) {
                displayError(e)
            }

            override fun onComplete() {}

            override fun onNext(t: Long) {
                viewModel.starsCount = t
            }
        })
    }

    private fun displayError(e: Throwable) {
        view.displayMessage("Error: ${ErrorMapper.mapThrowable(e)}")
    }
}