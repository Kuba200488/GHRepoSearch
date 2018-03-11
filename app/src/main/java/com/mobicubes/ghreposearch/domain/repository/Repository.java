package com.mobicubes.ghreposearch.domain.repository;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.domain.entity.RepositoryItem;
import com.mobicubes.ghreposearch.domain.entity.UserItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kuba on 10/03/2018.
 */

public interface Repository {

    @NonNull
    Observable<List<UserItem>> searchUsers(@NonNull String query);

    @NonNull
    Observable<List<RepositoryItem>> searchRepositories(@NonNull String query);
}
