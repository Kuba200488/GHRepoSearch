package com.mobicubes.ghreposearch.data;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.data.network.Service;
import com.mobicubes.ghreposearch.data.network.mapper.RepositoryMapper;
import com.mobicubes.ghreposearch.data.network.mapper.UserMapper;
import com.mobicubes.ghreposearch.domain.entity.RepositoryItem;
import com.mobicubes.ghreposearch.domain.entity.UserItem;
import com.mobicubes.ghreposearch.domain.repository.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by kuba on 10/03/2018.
 */

public class RepositoryImpl implements Repository {

    private static final Map<String, String> HEADER_MAP = Collections.singletonMap("User-Agent", "kuba200488"); // TODO move it

    @NonNull
    private final Service service;

    public RepositoryImpl(@NonNull Service service) {
        this.service = service;
    }

    @NonNull
    @Override
    public Observable<List<UserItem>> searchUsers(@NonNull final String query) {
        return service.searchUsers(HEADER_MAP, query)
                .map(UserMapper::mapList);
    }

    @NonNull
    @Override
    public Observable<List<RepositoryItem>> searchRepositories(@NonNull final String query) {
        return service.searchRepositories(HEADER_MAP, query)
                .map(RepositoryMapper::mapList);
    }
}
