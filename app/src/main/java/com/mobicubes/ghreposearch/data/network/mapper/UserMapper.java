package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.annotation.NonNull;

import com.mobicubes.ghreposearch.data.network.entity.UserJson;
import com.mobicubes.ghreposearch.domain.entity.User;

/**
 * Created by kuba on 10/03/2018.
 */

public class UserMapper {

    private UserMapper() {
        //no-op
    }

    @NonNull
    public static User map(@NonNull final UserJson json) {
        return User.newBuilder()
                .withId(json.getId())
                .withLogin(json.getLogin())
                .withAvatarUrl(json.getAvatarUrl())
                .build();
    }
}
