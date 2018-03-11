package com.mobicubes.ghreposearch.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuba on 10/03/2018.
 */

@Module
public class AppModule {

    @NonNull final private MyApplication application;

    public AppModule(@NonNull MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @NonNull Context provideContext() {
        return application;
    }
}
