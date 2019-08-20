package aej.code.efficiency.presentation.main.contract

import androidx.fragment.app.Fragment

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
interface MainContract {
    interface View {
        val fragments: List<Fragment>
        val fragmentTitles: List<String?>
        fun setupViewPagerAndTabLayout()
    }
}