package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuba on 10/03/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJson {

    private UserJson() {
        //no-op
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("login")
    private String login;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public String getLogin() {
        return login;
    }

    @JsonIgnore
    public String getAvatarUrl() {
        return avatarUrl;
    }

    // builder only for test purposes --------------------------

    private UserJson(Builder builder) {
        id = builder.id;
        login = builder.login;
        avatarUrl = builder.avatarUrl;
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

        public UserJson build() {
            return new UserJson(this);
        }
    }
}
