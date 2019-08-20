package aej.code.efficiency.presentation.main.fragments.movie

import aej.code.efficiency.data.responses.MovieData
import android.content.Context
import com.google.gson.Gson

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class MoviesFragmentPresenter(private val context: Context?) : MoviesFragmentContract.UserActionListener {

    private var view: MoviesFragmentContract.View? = null
    private var movieList: MutableList<MovieData.Movie> = mutableListOf()
    private val gson = Gson()

    override fun setupView(view: MoviesFragmentContract.View) {
        this.view = view
    }

    override fun fetchMovieList() {
        view?.showProgressbar()
        try {
            val inputStream = context?.assets?.open("json/movie_list.json")
            val inputString = inputStream?.bufferedReader().use { it?.readText() }
            val responses = gson.fromJson(inputString, MovieData.Response::class.java)
            setupMovieList(responses.data)
            view?.hideProgressbar()
        } catch (ex: Exception) {
            ex.printStackTrace()
            view?.hideProgressbar()
            view?.showError("Error while converting movie list")
        }
    }

    override fun setupMovieList(list: List<MovieData.Movie>) {
        movieList.clear()
        movieList.addAll(list)
        view?.setupAdapter(movieList)
    }

}