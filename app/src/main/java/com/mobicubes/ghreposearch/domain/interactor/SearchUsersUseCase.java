package com.mobicubes.ghreposearch.domain.interactor;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.domain.entity.UserItem;
import com.mobicubes.ghreposearch.domain.repository.Repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kuba on 10/03/2018.
 */

public class SearchUsersUseCase extends BaseUseCase<String, List<UserItem>> {

    @NonNull private final Repository repository;

    public SearchUsersUseCase(@NonNull Repository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<List<UserItem>> buildObservable(String query) {
        return repository.searchUsers(query);
    }
}
