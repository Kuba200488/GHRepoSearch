package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by kuba on 10/03/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoriesResponseJson extends ListJson {

    private RepositoriesResponseJson() {
        //no-op
    }

    @JsonProperty("items")
    private List<RepositoryJson> items;

    @JsonIgnore
    public List<RepositoryJson> getItems() {
        return items;
    }

    // builder only for test purposes --------------------------

    private RepositoriesResponseJson(Builder builder) {
        totalCount = builder.totalCount;
        incompleteResults = builder.incompleteResults;
        items = builder.items;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Long totalCount;
        private Boolean incompleteResults;
        private List<RepositoryJson> items;

        private Builder() {
        }

        public Builder withTotalCount(Long val) {
            totalCount = val;
            return this;
        }

        public Builder withIncompleteResults(Boolean val) {
            incompleteResults = val;
            return this;
        }

        public Builder withItems(List<RepositoryJson> val) {
            items = val;
            return this;
        }

        public RepositoriesResponseJson build() {
            return new RepositoriesResponseJson(this);
        }
    }
}
