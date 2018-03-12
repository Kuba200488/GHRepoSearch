package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuba on 10/03/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryJson {

    private RepositoryJson() {
        //no-op
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("stargazers_count")
    private Long starCount;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public Long getStarCount() {
        return starCount;
    }

    // builder only for test purposes --------------------------

    private RepositoryJson(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        starCount = builder.starCount;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private Long starCount;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withStarCount(Long val) {
            starCount = val;
            return this;
        }

        public RepositoryJson build() {
            return new RepositoryJson(this);
        }
    }
}
