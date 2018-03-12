package com.mobicubes.ghreposearch.presentation.search.view.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Created by kuba on 11/03/2018.
 */

public final class RecyclerViewBindingAdapter {

    private RecyclerViewBindingAdapter() {
        //no-op
    }

    @BindingAdapter("adapter")
    public static void setAdapter(
            @NonNull final RecyclerView recyclerView,
            @NonNull final RecyclerView.Adapter adapter
    ) {
        recyclerView.setAdapter(adapter);
    }
}
