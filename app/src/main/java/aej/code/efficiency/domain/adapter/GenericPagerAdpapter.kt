package aej.code.efficiency.domain.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class GenericPagerAdpapter(
    fragmentManager: FragmentManager,
    private val fragments: List<Fragment>,
    private val titles: List<String?>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
    override fun getPageTitle(position: Int) = titles[position]

}