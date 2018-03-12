package com.mobicubes.ghreposearch.util

import retrofit2.HttpException

/**
 * Created by kuba on 12/03/2018.
 */
class ErrorMapper {
    companion object {
        fun mapThrowable(e: Throwable) =
                when (e) {
                    is HttpException -> mapHttpException(e)
                    else -> e.localizedMessage
                }

        fun mapHttpException(e: HttpException) =
                when (e.code()) {
                    403 -> "Looks like you're doing too much!"
                    else -> e.localizedMessage
                }
    }
}