package com.mobicubes.ghreposearch.domain.interactor;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.domain.entity.RepositoryItem;
import com.mobicubes.ghreposearch.domain.repository.Repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kuba on 10/03/2018.
 */

public class SearchRepositoriesUseCase extends BaseUseCase<String, List<RepositoryItem>> {

    @NonNull private final Repository repository;

    public SearchRepositoriesUseCase(@NonNull Repository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<List<RepositoryItem>> buildObservable(String query) {
        return repository.searchRepositories(query);
    }
}
