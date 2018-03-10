package com.mobicubes.ghreposearch.util;

import android.support.annotation.Nullable;

/**
 * Created by kuba on 10/03/2018.
 */

public final class Preconditions {

    private Preconditions() {
        //no-op
    }

    public static <T> T checkNotNull(@Nullable T reference) {
        if (reference == null) {
            throw new RuntimeException("Null Argument");
        }
        return reference;
    }

    public static String checkNotEmpty(@Nullable String value) {
        if (checkNotNull(value).isEmpty()) {
            throw new RuntimeException("Empty String");
        }
        return value;
    }
}
