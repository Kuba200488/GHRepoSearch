package com.mobicubes.ghreposearch.di;

import com.mobicubes.ghreposearch.MyApplication;
import com.mobicubes.ghreposearch.presentation.search.di.SearchActivityComponent;
import com.mobicubes.ghreposearch.presentation.search.di.SearchActivityModule;
import com.mobicubes.ghreposearch.presentation.userdetail.di.UserDetailActivityComponent;
import com.mobicubes.ghreposearch.presentation.userdetail.di.UserDetailActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kuba on 10/03/2018.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {
    void inject(MyApplication application);

    SearchActivityComponent plus(SearchActivityModule module);

    UserDetailActivityComponent plus(UserDetailActivityModule module);
}
