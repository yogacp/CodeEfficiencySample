package aej.code.efficiency.presentation.main.view

import aej.code.efficiency.R
import aej.code.efficiency.domain.adapter.GenericPagerAdpapter
import aej.code.efficiency.external.extension.setUp
import aej.code.efficiency.external.extension.notNull
import aej.code.efficiency.presentation.main.contract.MainContract
import aej.code.efficiency.presentation.main.fragments.movie.MoviesFragment
import aej.code.efficiency.presentation.main.fragments.tvshow.TvShowsFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class MainActivity : AppCompatActivity(), MainContract.View {

    var mActiveFragment: Fragment? = null
    var mAdapter: GenericPagerAdpapter? = null
    var mViewPosition: Int = 0

    override val fragments: List<Fragment>
        get() = listOf(
            MoviesFragment(),
            TvShowsFragment()
        )

    override val fragmentTitles: List<String?>
        get() = listOf(
            getString(R.string.movie_tab_title),
            getString(R.string.tv_show_tab_title)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPagerAndTabLayout()
    }

    override fun setupViewPagerAndTabLayout() {
        mAdapter = supportFragmentManager.setUp(fragments, fragmentTitles)
        mainViewPager.adapter = mAdapter
        mainViewPager.currentItem = mViewPosition
        mainViewPager.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(mainTabLayout)
        )

        mainTabLayout.setupWithViewPager(mainViewPager)
        mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                mViewPosition = tab.position
                mViewPosition.notNull {
                    mainViewPager.currentItem = it
                    mActiveFragment = mAdapter?.getItem(it)
                }
            }
        })
    }
}