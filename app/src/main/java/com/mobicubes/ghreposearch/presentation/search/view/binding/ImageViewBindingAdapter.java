package com.mobicubes.ghreposearch.presentation.search.view.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by kuba on 12/03/2018.
 */

public final class ImageViewBindingAdapter {

    private ImageViewBindingAdapter() {
        //no-op
    }

    @BindingAdapter("loadUrl")
    public static void loadUrl(
            @NonNull final ImageView imageView,
            @NonNull final String url
    ) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
