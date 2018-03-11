package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by kuba on 10/03/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponseJson extends ListJson {

    private UsersResponseJson() {
        //no-op
    }

    @JsonProperty("items")
    private List<UserJson> items;

    @JsonIgnore
    public List<UserJson> getItems() {
        return items;
    }

    // builder only for test purposes --------------------------

    private UsersResponseJson(Builder builder) {
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
        private List<UserJson> items;

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

        public Builder withItems(List<UserJson> val) {
            items = val;
            return this;
        }

        public UsersResponseJson build() {
            return new UsersResponseJson(this);
        }
    }
}
