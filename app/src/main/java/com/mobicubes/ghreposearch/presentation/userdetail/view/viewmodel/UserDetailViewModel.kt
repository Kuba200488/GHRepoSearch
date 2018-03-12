package com.mobicubes.ghreposearch.presentation.userdetail.view.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.mobicubes.ghreposearch.BR
import com.mobicubes.ghreposearch.domain.entity.UserItem

/**
 * Created by kuba on 11/03/2018.
 */
class UserDetailViewModel(
        val user: UserItem
) : BaseObservable() {

    private var fCount: Long? = null

    var followersCount: Long?
        @Bindable get() = fCount
        set(value) {
            fCount = value
            notifyPropertyChanged(BR.followersCount)
            notifyPropertyChanged(BR.followersCountText)
        }

    @Bindable
    fun getFollowersCountText() = if (followersCount == null) "" else "$followersCount"

    private var sCount: Long? = null

    var starsCount: Long?
        @Bindable get() = sCount
        set(value) {
            sCount = value
            notifyPropertyChanged(BR.starsCount)
            notifyPropertyChanged(BR.starsCountText)
        }

    @Bindable
    fun getStarsCountText() = if (starsCount == null) "" else "$starsCount"

    fun getName() = user.login
    fun getImageUrl() = user.avatarUrl
}