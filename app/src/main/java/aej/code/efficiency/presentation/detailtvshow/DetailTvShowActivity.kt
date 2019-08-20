package aej.code.efficiency.presentation.detailtvshow

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.TvShowData
import aej.code.efficiency.external.constant.Constant
import aej.code.efficiency.external.extension.loadFromPosterName
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class DetailTvShowActivity : AppCompatActivity(), DetailTvShowContract.View {

    private var presenter = DetailTvShowPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
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
        val tvData = intent.getParcelableExtra<TvShowData.TVShow>(Constant.INTENT_BUNDLE.TV_SHOW_DATA)
        presenter.setupView(this)
        presenter.fetchDetailTvShow(tvData)
        setupToolbar(tvData.name)
    }

    override fun setupToolbar(title: String?) {
        supportActionBar?.apply {
            this.title = title
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun showData(tvShow: TvShowData.TVShow) {
        tvPoster.loadFromPosterName(tvShow.poster)
        tvFirstAirDate.text = tvShow.first_air_date
        tvLastAirDate.text = tvShow.last_air_date
        tvStatus.text = tvShow.status
        tvVoteAverage.text = getString(R.string.movie_vote_average).format(tvShow.vote_average)
        tvOverview.text = tvShow.overview
        tvLanguage.text = tvShow.original_language?.toUpperCase()
    }
}