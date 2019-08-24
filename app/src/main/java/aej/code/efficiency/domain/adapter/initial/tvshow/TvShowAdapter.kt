package aej.code.efficiency.domain.adapter.initial.tvshow

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.TvShowData
import aej.code.efficiency.external.extension.inflate
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Yoga C. Pranata on 2019-08-24.
 * Android Engineer
 */
class TvShowAdapter (val context: Context, val tvShowList: List<TvShowData.TVShow>) : RecyclerView.Adapter<TvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = parent inflate R.layout.item_tv_shows
        return TvShowViewHolder(context, view)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShowData = tvShowList[position]
        holder.bind(tvShowData)
    }

}