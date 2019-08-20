package aej.code.efficiency.data.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
sealed class TvShowData {

    data class Response(
        val data: List<TVShow>
    )

    @Parcelize
    data class TVShow (
        val id: Int? = null,
        val name: String? = null,
        val last_air_date: String? = null,
        val first_air_date: String? = null,
        val number_of_episodes: Int? = null,
        val poster: String? = null,
        val backdrop: String? = null,
        val vote_average: Double? = null,
        val original_language: String? = null,
        val overview: String? = null,
        val status: String? = null
    ): Parcelable
}