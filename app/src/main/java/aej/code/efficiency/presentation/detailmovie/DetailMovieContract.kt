package aej.code.efficiency.presentation.detailmovie

import aej.code.efficiency.data.responses.MovieData

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
interface DetailMovieContract {

    interface View {
        fun setupConfig()
        fun setupToolbar(title: String?)
        fun showData(movie: MovieData.Movie)
    }

    interface UserActionListener {
        fun setupView(view: View)
        fun fetchDetailMovie(movie: MovieData.Movie?)
    }
}