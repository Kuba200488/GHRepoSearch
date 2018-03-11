package com.mobicubes.ghreposearch.presentation.search.di;

import com.mobicubes.ghreposearch.presentation.search.SearchActivity;

import dagger.Subcomponent;

/**
 * Created by kuba on 11/03/2018.
 */

@Subcomponent(modules = SearchActivityModule.class)
public interface SearchActivityComponent {

    void inject(SearchActivity activity);
}
