package aej.code.efficiency.data.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
sealed class MovieData {

    data class Response(
        val data: List<Movie>
    )

    @Parcelize
    data class Movie (
        val id: Int? = null,
        val title: String? = null,
        val tagline: String? = null,
        val release_date: String? = null,
        val poster: String? = null,
        val backdrop: String? = null,
        val vote_average: Double? = null,
        val original_language: String? = null,
        val overview: String? = null
    ): Parcelable
}