package com.mobicubes.ghreposearch.di;

import com.mobicubes.ghreposearch.MyApplication;
import com.mobicubes.ghreposearch.presentation.search.MainActivity;

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

    void inject(MainActivity mainActivity);
}
