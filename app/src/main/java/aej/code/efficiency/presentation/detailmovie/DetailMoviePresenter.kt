package aej.code.efficiency.presentation.detailmovie

import aej.code.efficiency.data.responses.MovieData

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class DetailMoviePresenter : DetailMovieContract.UserActionListener {

    private var view: DetailMovieContract.View? = null

    override fun setupView(view: DetailMovieContract.View) {
        this.view = view
    }

    override fun fetchDetailMovie(movie: MovieData.Movie?) {
        movie?.let { view?.showData(it) }
    }

}