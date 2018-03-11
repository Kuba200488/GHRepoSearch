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

    // builder only for test purposes --------------------------

    private RepositoryJson(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;

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

        public RepositoryJson build() {
            return new RepositoryJson(this);
        }
    }
}
