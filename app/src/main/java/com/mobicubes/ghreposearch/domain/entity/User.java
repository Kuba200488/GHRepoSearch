package com.mobicubes.ghreposearch.domain.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mobicubes.ghreposearch.util.Preconditions;

/**
 * Created by kuba on 10/03/2018.
 */

public class User {

    @NonNull
    private final Long id;
    @NonNull
    private final String login;
    @Nullable
    private final String avatarUrl;

    private User(Builder builder) {
        id = Preconditions.checkNotNull(builder.id);
        login = Preconditions.checkNotEmpty(builder.login);
        avatarUrl = builder.avatarUrl;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!login.equals(user.login)) return false;
        return avatarUrl != null ? avatarUrl.equals(user.avatarUrl) : user.avatarUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        return result;
    }


    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String login;
        private String avatarUrl;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withLogin(String val) {
            login = val;
            return this;
        }

        public Builder withAvatarUrl(String val) {
            avatarUrl = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
