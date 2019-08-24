package aej.code.efficiency.domain.adapter.initial.movie

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.MovieData
import aej.code.efficiency.external.extension.inflate
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Yoga C. Pranata on 2019-08-24.
 * Android Engineer
 *
 * This class is for presentation purposes
 */
class MovieViewAdapter (val context: Context, val movieList: List<MovieData.Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = parent inflate R.layout.item_movie //Extension
        return MovieViewHolder(context, view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }


}