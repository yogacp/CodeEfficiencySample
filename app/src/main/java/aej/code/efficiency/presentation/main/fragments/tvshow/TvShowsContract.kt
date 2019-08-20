package aej.code.efficiency.presentation.main.fragments.tvshow

import aej.code.efficiency.data.responses.TvShowData

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
interface TvShowsContract {
    interface View {
        fun initConfig()
        fun setupAdapter(tvShowList: List<TvShowData.TVShow>)
        fun showError(message: String)
        fun showProgressbar()
        fun hideProgressbar()
    }

    interface UserActionListener {
        fun setupView(view: View)
        fun fetchTvShowList()
        fun setupTvShowList(list: List<TvShowData.TVShow>)
    }
}