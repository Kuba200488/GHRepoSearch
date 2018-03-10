package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuba on 10/03/2018.
 */

public class RepositoryJson {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;
}
