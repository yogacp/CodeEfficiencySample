package aej.code.efficiency.presentation.main.fragments.movie

import aej.code.efficiency.data.responses.MovieData

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
interface MoviesFragmentContract {
    interface View {
        fun initConfig()
        fun setupAdapter(movieList: List<MovieData.Movie>)
        fun showError(message: String)
        fun showProgressbar()
        fun hideProgressbar()
    }

    interface UserActionListener {
        fun setupView(view: View)
        fun fetchMovieList()
        fun setupMovieList(list: List<MovieData.Movie>)
    }
}