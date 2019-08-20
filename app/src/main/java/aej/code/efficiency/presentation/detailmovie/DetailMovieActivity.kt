package aej.code.efficiency.presentation.detailmovie

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.MovieData
import aej.code.efficiency.external.constant.Constant
import aej.code.efficiency.external.extension.loadFromPosterName
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_movie.*

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class DetailMovieActivity : AppCompatActivity(), DetailMovieContract.View {

    private var presenter = DetailMoviePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setupConfig()
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    override fun setupConfig() {
        val movieData = intent.getParcelableExtra<MovieData.Movie>(Constant.INTENT_BUNDLE.MOVIE_DATA)
        presenter.setupView(this)
        presenter.fetchDetailMovie(movieData)
        setupToolbar(movieData.title)
    }

    override fun setupToolbar(title: String?) {
        supportActionBar?.apply {
            this.title = title
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun showData(movie: MovieData.Movie) {
        moviePoster.loadFromPosterName(movie.poster)
        movieReleaseDate.text = movie.release_date
        movieRateAverage.text = getString(R.string.movie_vote_average).format(movie.vote_average)
        movieOverview.text = movie.overview
        movieLanguage.text = movie.original_language?.toUpperCase()
    }

}