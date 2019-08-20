package aej.code.efficiency.presentation.main.fragments.movie

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.MovieData
import aej.code.efficiency.external.extension.setUp
import aej.code.efficiency.external.constant.Constant
import aej.code.efficiency.external.extension.debugMode
import aej.code.efficiency.external.extension.loadFromPosterName
import aej.code.efficiency.presentation.detailmovie.DetailMovieActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class MoviesFragment : Fragment(), MoviesFragmentContract.View, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: MoviesFragmentPresenter? = null
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mLayoutManager = GridLayoutManager(context, 1)
        initConfig()
    }

    override fun initConfig() {
        movieListSwipeLayout.setOnRefreshListener(this)
        presenter = MoviesFragmentPresenter(context)
        presenter?.setupView(this)
        presenter?.fetchMovieList()
    }

    override fun setupAdapter(movieList: List<MovieData.Movie>) {
        rvMovies.setUp(
            movieList,
            R.layout.item_movie,
            {
                img_photo.loadFromPosterName(it.poster)
                txt_name.text = it.title
                txt_description.text = it.tagline
            },
            {
                val detailPage = Intent(context, DetailMovieActivity::class.java)
                detailPage.putExtra(Constant.INTENT_BUNDLE.MOVIE_DATA, it)
                startActivity(detailPage)
            },
            mLayoutManager
        )
    }

    override fun showError(message: String) {
        debugMode {
            toast(message)
        }
    }

    override fun onRefresh() {
        presenter?.fetchMovieList()
    }

    override fun showProgressbar() {
        movieListSwipeLayout.isRefreshing = true
    }

    override fun hideProgressbar() {
        movieListSwipeLayout.isRefreshing = false
    }
}