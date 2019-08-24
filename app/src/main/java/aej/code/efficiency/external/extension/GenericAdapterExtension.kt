package aej.code.efficiency.external.extension

import aej.code.efficiency.domain.adapter.generic.GenericPagerAdpapter
import aej.code.efficiency.domain.adapter.generic.GenericRecyclerviewAdapter
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
fun FragmentManager.setUp(
    fragments: List<Fragment>,
    titles: List<String?>? = null
) : GenericPagerAdpapter {
    return GenericPagerAdpapter(
        this,
        fragments,
        titles ?: listOf()
    )
}

fun <ITEM> RecyclerView.setUp(items: List<ITEM>,
                              layoutResId: Int,
                              bindHolder: View.(ITEM) -> Unit,
                              itemClick: View.(ITEM) -> Unit = {},
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
)
        : GenericRecyclerviewAdapter<ITEM> {

    val genericAdapter by kotlin.lazy {
        GenericRecyclerviewAdapter(items, layoutResId, {
            bindHolder(it)
        }, {
            itemClick(it)
        })
    }

    layoutManager = manager
    adapter = genericAdapter
    (adapter as GenericRecyclerviewAdapter<*>).notifyDataSetChanged()

    return genericAdapter
}