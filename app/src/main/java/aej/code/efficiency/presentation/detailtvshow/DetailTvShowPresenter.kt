package aej.code.efficiency.presentation.detailtvshow

import aej.code.efficiency.data.responses.TvShowData

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class DetailTvShowPresenter : DetailTvShowContract.UserActionListener {

    private var view: DetailTvShowContract.View? = null

    override fun setupView(view: DetailTvShowContract.View) {
        this.view = view
    }

    override fun fetchDetailTvShow(tvShow: TvShowData.TVShow?) {
        tvShow?.let { view?.showData(it) }
    }

}