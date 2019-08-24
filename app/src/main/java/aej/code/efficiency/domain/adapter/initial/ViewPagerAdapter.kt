package aej.code.efficiency.domain.adapter.initial

import aej.code.efficiency.R
import aej.code.efficiency.presentation.main.fragments.movie.MoviesFragment
import aej.code.efficiency.presentation.main.fragments.tvshow.TvShowsFragment
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Yoga C. Pranata on 2019-08-24.
 * Android Engineer
 *
 * This class is for presentation purposes
 */
class ViewPagerAdapter (fm: FragmentManager, val context: Context) : FragmentPagerAdapter(fm) {

    private val MOVIES = 0
    private val TV_SHOWS = 1

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            MOVIES -> MoviesFragment()
            TV_SHOWS -> TvShowsFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            MOVIES -> context.getString(R.string.movie_tab_title)
            TV_SHOWS -> context.getString(R.string.tv_show_tab_title)
            else -> ""
        }
    }
}