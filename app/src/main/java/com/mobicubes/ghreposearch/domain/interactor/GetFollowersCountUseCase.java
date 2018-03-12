package com.mobicubes.ghreposearch.domain.interactor;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.domain.repository.Repository;

import io.reactivex.Observable;

/**
 * Created by kuba on 12/03/2018.
 */

public class GetFollowersCountUseCase extends BaseUseCase<String, Long> {

    @NonNull
    private final Repository repository;

    public GetFollowersCountUseCase(@NonNull final Repository repository) {
        this.repository = repository;
    }


    @Override
    protected Observable<Long> buildObservable(@NonNull final String login) {
        return repository.getFollowersCount(login);
    }
}
