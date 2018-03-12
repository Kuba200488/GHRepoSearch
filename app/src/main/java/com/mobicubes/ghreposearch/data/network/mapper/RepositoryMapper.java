package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.annotation.NonNull;

import com.annimon.stream.Stream;
import com.mobicubes.ghreposearch.data.network.entity.RepositoriesResponseJson;
import com.mobicubes.ghreposearch.data.network.entity.RepositoryJson;
import com.mobicubes.ghreposearch.domain.entity.RepositoryItem;

import java.util.List;

/**
 * Created by kuba on 10/03/2018.
 */

public final class RepositoryMapper {

    private RepositoryMapper() {
        //no-op
    }

    @NonNull
    public static RepositoryItem map(@NonNull final RepositoryJson json) {

        return RepositoryItem.newBuilder()
                .withId(json.getId())
                .withName(json.getName())
                .withDescription(json.getDescription())
                .withStarCount(json.getStarCount())
                .build();
    }

    @NonNull
    public static List<RepositoryItem> mapListFromRepositoriesResponse(@NonNull final RepositoriesResponseJson json) {
        return mapList(json.getItems());
    }

    @NonNull
    public static List<RepositoryItem> mapList(@NonNull final List<RepositoryJson> jsonList) {
        return Stream.ofNullable(jsonList)
                .withoutNulls()
                .map(repositoryJson -> {
                    try {
                        return RepositoryMapper.map(repositoryJson);
                    } catch (RuntimeException e) {
                        return null;
                    }
                })
                .withoutNulls()
                .toList();
    }

    @NonNull
    public static Long mapListToStarsCount(@NonNull final List<RepositoryJson> jsonList) {
        return Stream.of(jsonList)
                .withoutNulls()
                .mapToLong(RepositoryJson::getStarCount)
                .sum();
    }
}
