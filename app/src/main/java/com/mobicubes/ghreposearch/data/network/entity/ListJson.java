package com.mobicubes.ghreposearch.data.network.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kuba on 10/03/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ListJson {

    @JsonProperty("total_count")
    protected Long totalCount;

    @JsonProperty("incomplete_results")
    protected Boolean incompleteResults;

    @JsonIgnore
    public Long getTotalCount() {
        return totalCount;
    }

    @JsonIgnore
    public Boolean getIncompleteResults() {
        return incompleteResults;
    }
}
