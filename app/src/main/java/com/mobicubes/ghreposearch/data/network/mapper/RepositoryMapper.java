package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.data.network.entity.RepositoryJson;
import com.mobicubes.ghreposearch.domain.entity.Repository;

/**
 * Created by kuba on 10/03/2018.
 */

public final class RepositoryMapper {

    private RepositoryMapper() {
        //no-op
    }

    @NonNull
    public static Repository map(@NonNull final RepositoryJson json) {
        return Repository.newBuilder()
                .withId(json.getId())
                .withName(json.getName())
                .withDescription(json.getDescription())
                .build();
    }
}
