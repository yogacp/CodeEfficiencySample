package aej.code.efficiency.domain.adapter.initial.movie

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.MovieData
import aej.code.efficiency.external.constant.Constant
import aej.code.efficiency.external.extension.loadFromPosterName
import aej.code.efficiency.presentation.detailmovie.DetailMovieActivity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Yoga C. Pranata on 2019-08-24.
 * Android Engineer
 *
 * This class is for presentation purposes
 */
class MovieViewHolder(val context: Context, val view: View) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    private var imgPhoto = view.findViewById<ImageView>(R.id.img_photo)
    private var textName = view.findViewById<TextView>(R.id.txt_name)
    private var textDesc = view.findViewById<TextView>(R.id.txt_description)
    private var movieData: MovieData.Movie? = null

    init {
        view.setOnClickListener(this)
    }

    fun bind(movie: MovieData.Movie) {
        movieData = movie
        textName.text = movieData?.title
        textDesc.text = movieData?.tagline
        imgPhoto.loadFromPosterName(movieData?.poster) //Extension
    }

    override fun onClick(v: View?) {
        movieData?.let {
            val detailPage = Intent(context, DetailMovieActivity::class.java)
            detailPage.putExtra(Constant.INTENT_BUNDLE.MOVIE_DATA, it)
            context.startActivity(detailPage)
        }
    }

}