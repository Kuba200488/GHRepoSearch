package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.annotation.NonNull;

import com.annimon.stream.Stream;
import com.mobicubes.ghreposearch.data.network.entity.UserJson;
import com.mobicubes.ghreposearch.data.network.entity.UsersResponseJson;
import com.mobicubes.ghreposearch.domain.entity.UserItem;

import java.util.List;

/**
 * Created by kuba on 10/03/2018.
 */

public class UserMapper {

    private UserMapper() {
        //no-op
    }

    @NonNull
    public static UserItem map(@NonNull final UserJson json) {

        return UserItem.newBuilder()
                .withId(json.getId())
                .withLogin(json.getLogin())
                .withAvatarUrl(json.getAvatarUrl())
                .build();
    }

    @NonNull
    public static List<UserItem> mapList(@NonNull final UsersResponseJson json) {
        return Stream.of(json.getItems())
                .withoutNulls()
                .map(userJson -> {
                    try {
                        return UserMapper.map(userJson);
                    } catch (RuntimeException e) {
                        return null;
                    }
                })
                .withoutNulls()
                .toList();
    }
}
