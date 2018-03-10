package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuba on 10/03/2018.
 */

public class UserJson {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("login")
    private String login;

    @JsonProperty("avatar_url")
    private String avatarUrl;
}
