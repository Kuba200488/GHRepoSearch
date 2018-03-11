package com.mobicubes.ghreposearch;

import android.app.Application;

import com.mobicubes.ghreposearch.di.AppComponent;

import com.mobicubes.ghreposearch.di.AppModule;
import com.mobicubes.ghreposearch.di.DaggerAppComponent;
import com.mobicubes.ghreposearch.di.NetworkModule;

/**
 * Created by kuba on 10/03/2018.
 */

public class MyApplication extends Application {

    public AppComponent appComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();

        appComponent.inject(this);
    }
}
