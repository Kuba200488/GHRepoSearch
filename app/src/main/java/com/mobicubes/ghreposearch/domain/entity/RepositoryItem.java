package com.mobicubes.ghreposearch.domain.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mobicubes.ghreposearch.util.Preconditions;

/**
 * Created by kuba on 10/03/2018.
 */

public class RepositoryItem {

    @NonNull
    private final Long id;
    @NonNull
    private final String name;
    @Nullable
    private final String description;

    private RepositoryItem(Builder builder) {
        id = Preconditions.checkNotNull(builder.id);
        name = Preconditions.checkNotEmpty(builder.name);
        description = builder.description;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepositoryItem that = (RepositoryItem) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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

        public RepositoryItem build() {
            return new RepositoryItem(this);
        }
    }
}
