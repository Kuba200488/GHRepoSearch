package com.mobicubes.ghreposearch.presentation

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by kuba on 12/03/2018.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var toast: Toast? = null

    override fun displayMessage(message: String) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast?.show()
    }
}