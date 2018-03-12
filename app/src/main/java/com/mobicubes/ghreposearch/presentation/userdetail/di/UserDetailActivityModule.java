package com.mobicubes.ghreposearch.presentation.userdetail.di;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.domain.interactor.GetFollowersCountUseCase;
import com.mobicubes.ghreposearch.domain.interactor.GetStarsCountUseCase;
import com.mobicubes.ghreposearch.presentation.userdetail.UserDetailActivity;
import com.mobicubes.ghreposearch.presentation.userdetail.param.UserDetailParam;
import com.mobicubes.ghreposearch.presentation.userdetail.presenter.UserDetailPresenter;
import com.mobicubes.ghreposearch.presentation.userdetail.view.UserDetailView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuba on 11/03/2018.
 */

@Module
public class UserDetailActivityModule {

    private final UserDetailActivity activity;

    public UserDetailActivityModule(@NonNull final UserDetailActivity activity) {
        this.activity = activity;
    }

    @Provides
    public UserDetailView provideView() {
        return activity;
    }

    @Provides
    public UserDetailParam provideParam() {
        return activity.getExtra();
    }

    @Provides
    public UserDetailPresenter providePresenter(
            @NonNull final UserDetailView view,
            @NonNull final UserDetailParam param,
            @NonNull final GetFollowersCountUseCase getFollowersCountUseCase,
            @NonNull final GetStarsCountUseCase getStarsCountUseCase
    ) {
        return new UserDetailPresenter(view, param, getFollowersCountUseCase, getStarsCountUseCase);
    }
}
