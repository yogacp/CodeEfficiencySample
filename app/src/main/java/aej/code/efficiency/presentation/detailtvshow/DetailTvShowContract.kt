package aej.code.efficiency.presentation.detailtvshow

import aej.code.efficiency.data.responses.TvShowData

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
interface DetailTvShowContract {
    interface View {
        fun setupConfig()
        fun setupToolbar(title: String?)
        fun showData(tvShow: TvShowData.TVShow)
    }

    interface UserActionListener {
        fun setupView(view: View)
        fun fetchDetailTvShow(tvShow: TvShowData.TVShow?)
    }
}