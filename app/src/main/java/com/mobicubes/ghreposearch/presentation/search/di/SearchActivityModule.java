package com.mobicubes.ghreposearch.presentation.search.di;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.domain.interactor.SearchRepositoriesUseCase;
import com.mobicubes.ghreposearch.domain.interactor.SearchUsersUseCase;
import com.mobicubes.ghreposearch.presentation.search.SearchActivity;
import com.mobicubes.ghreposearch.presentation.search.presenter.SearchPresenter;
import com.mobicubes.ghreposearch.presentation.search.view.SearchView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuba on 11/03/2018.
 */

@Module
public class SearchActivityModule {

    private final SearchActivity activity;

    public SearchActivityModule(@NonNull final SearchActivity activity) {
        this.activity = activity;
    }

    @Provides
    public SearchView provideView() {
        return new SearchActivity();
    }

    @Provides
    public SearchPresenter providePresenter(
            @NonNull final SearchView view,
            @NonNull final SearchUsersUseCase searchUsersUseCase,
            @NonNull final SearchRepositoriesUseCase searchRepositoriesUseCase
            ) {
        return new SearchPresenter(
                view,
                searchUsersUseCase,
                searchRepositoriesUseCase
        );
    }
}
