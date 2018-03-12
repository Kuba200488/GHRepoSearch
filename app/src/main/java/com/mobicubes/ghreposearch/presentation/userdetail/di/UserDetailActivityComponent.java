package com.mobicubes.ghreposearch.presentation.userdetail.di;

import com.mobicubes.ghreposearch.presentation.userdetail.UserDetailActivity;

import dagger.Subcomponent;

/**
 * Created by kuba on 11/03/2018.
 */

@Subcomponent(modules = UserDetailActivityModule.class)
public interface UserDetailActivityComponent {

    void inject(UserDetailActivity activity);
}
