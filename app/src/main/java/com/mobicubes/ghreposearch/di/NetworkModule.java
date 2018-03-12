package com.mobicubes.ghreposearch.di;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.BuildConfig;
import com.mobicubes.ghreposearch.data.RepositoryImpl;
import com.mobicubes.ghreposearch.data.network.Service;
import com.mobicubes.ghreposearch.domain.interactor.GetFollowersCountUseCase;
import com.mobicubes.ghreposearch.domain.interactor.GetStarsCountUseCase;
import com.mobicubes.ghreposearch.domain.interactor.SearchRepositoriesUseCase;
import com.mobicubes.ghreposearch.domain.interactor.SearchUsersUseCase;
import com.mobicubes.ghreposearch.domain.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by kuba on 10/03/2018.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(
            @NonNull final Converter.Factory converterFactory,
            @NonNull final CallAdapter.Factory callAdapterFactory
    ) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    @Provides
    @Singleton
    public CallAdapter.Factory provideCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public Converter.Factory provideConverterFactory() {
        return JacksonConverterFactory.create();
    }

    @Provides
    @Singleton
    public Service provideService(
            @NonNull final Retrofit retrofit
    ) {
        return retrofit.create(Service.class);
    }

    @Provides
    @Singleton
    public Repository provideRepository(
            @NonNull final Service service
    ) {
        return new RepositoryImpl(service);
    }

    @Provides
    @Singleton
    public SearchUsersUseCase provideSearchUsersUseCase(
            @NonNull final Repository repository
    ) {
        return new SearchUsersUseCase(repository);
    }

    @Provides
    @Singleton
    public SearchRepositoriesUseCase provideSearchRepositoriesUseCase(
            @NonNull final Repository repository
    ) {
        return new SearchRepositoriesUseCase(repository);
    }

    @Provides
    @Singleton
    public GetFollowersCountUseCase provideGetFollowersCountUseCase(
            @NonNull final Repository repository
    ) {
        return new GetFollowersCountUseCase(repository);
    }

    @Provides
    @Singleton
    public GetStarsCountUseCase provideGetUserStarsCountUseCase(
            @NonNull final Repository repository
    ) {
        return new GetStarsCountUseCase(repository);
    }
}
