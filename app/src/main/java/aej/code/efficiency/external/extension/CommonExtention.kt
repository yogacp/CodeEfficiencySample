package aej.code.efficiency.external.extension

import aej.code.efficiency.BuildConfig
import aej.code.efficiency.R
import aej.code.efficiency.external.constant.Constant
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
infix fun ViewGroup.inflate(layoutResId: Int): View =
    LayoutInflater.from(context).inflate(layoutResId, this, false)

fun debugMode(function: () -> Unit) {
    if (BuildConfig.DEBUG) {
        function()
    }
}

fun <T : Any> T?.notNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}

fun ImageView.loadFromPosterName(posterName: String?) {
    Picasso.get()
        .load(loadPosterFromString(posterName))
        .fit()
        .centerCrop()
        .into(this)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun String?.notNullOrEmpty(f: (it: String) -> Unit) {
    if (this != null && !this.isEmpty()) f(this)
}

fun String?.truncateText(defaultLimit: Int = 5): String {
    return this?.split(' ')?.joinToString(limit = defaultLimit, truncated = "")?.replace(",","").toString()
}

private fun loadPosterFromString(posterName: String?) : Int {
    return when(posterName) {
        Constant.MOVIE_POSTER.AQUAMAN -> R.drawable.poster_aquaman
        Constant.MOVIE_POSTER.AVENGER -> R.drawable.poster_infinity_war
        Constant.MOVIE_POSTER.ALITA -> R.drawable.poster_alita
        Constant.MOVIE_POSTER.CREED -> R.drawable.poster_creed
        Constant.MOVIE_POSTER.HOW_TO_TRAIN_YOUR_DRAGON -> R.drawable.poster_how_to_train
        Constant.MOVIE_POSTER.CRIMES -> R.drawable.poster_crimes
        Constant.MOVIE_POSTER.GLASS -> R.drawable.poster_glass
        Constant.MOVIE_POSTER.MORTAL_ENGINE -> R.drawable.poster_mortal_engines
        Constant.MOVIE_POSTER.COLD_PURSUIT -> R.drawable.poster_cold_persuit
        Constant.MOVIE_POSTER.SPIDERMAN -> R.drawable.poster_spiderman
        Constant.MOVIE_POSTER.RALPH -> R.drawable.poster_ralph
        Constant.TV_SHOWS_POSTER.ARROW -> R.drawable.poster_arrow
        Constant.TV_SHOWS_POSTER.DOOM_PATROL -> R.drawable.poster_doom_patrol
        Constant.TV_SHOWS_POSTER.DRAGON_BALL -> R.drawable.poster_dragon_ball
        Constant.TV_SHOWS_POSTER.FLASH -> R.drawable.poster_flash
        Constant.TV_SHOWS_POSTER.GOT -> R.drawable.poster_god
        Constant.TV_SHOWS_POSTER.NARUTO -> R.drawable.poster_naruto_shipudden
        Constant.TV_SHOWS_POSTER.NCIS -> R.drawable.poster_ncis
        Constant.TV_SHOWS_POSTER.SHAMELESS -> R.drawable.poster_shameless
        Constant.TV_SHOWS_POSTER.SUPERGIRL -> R.drawable.poster_supergirl
        Constant.TV_SHOWS_POSTER.SUPERNATURAL -> R.drawable.poster_supernatural
        Constant.TV_SHOWS_POSTER.THE_SIMPSONS -> R.drawable.poster_the_simpson
        else -> R.drawable.ic_launcher_background
    }
}