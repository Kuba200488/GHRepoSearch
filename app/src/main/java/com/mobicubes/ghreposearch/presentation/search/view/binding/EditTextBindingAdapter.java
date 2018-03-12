package com.mobicubes.ghreposearch.presentation.search.view.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by kuba on 11/03/2018.
 */

public final class EditTextBindingAdapter {

    private EditTextBindingAdapter() {
        //no-op
    }

    @BindingAdapter("onTextChanged")
    public static void onTextChanged(
            @NonNull final EditText editText,
            @NonNull final TextChangedListener listener
    ) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    final CharSequence s,
                    final int start,
                    final int count,
                    final int after
            ) {

            }

            @Override
            public void onTextChanged(
                    final CharSequence s,
                    final int start,
                    final int before,
                    final int count
            ) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                listener.onTextChanged();
            }
        });
    }

    public interface TextChangedListener {

        void onTextChanged();
    }
}
