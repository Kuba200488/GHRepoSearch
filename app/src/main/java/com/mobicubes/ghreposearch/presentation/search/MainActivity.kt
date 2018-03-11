package com.mobicubes.ghreposearch.presentation.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobicubes.ghreposearch.MyApplication
import com.mobicubes.ghreposearch.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MyApplication).appComponent.inject(this)
    }
}
