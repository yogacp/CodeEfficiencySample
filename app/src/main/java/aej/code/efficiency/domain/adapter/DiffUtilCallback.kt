package aej.code.efficiency.domain.adapter

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
internal class DiffUtilCallback<ITEM>(private val oldItems: List<ITEM>,
                                      private val newItems: List<ITEM>)
    : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

}