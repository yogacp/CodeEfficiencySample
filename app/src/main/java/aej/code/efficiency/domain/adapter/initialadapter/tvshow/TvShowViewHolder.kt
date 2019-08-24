package aej.code.efficiency.domain.adapter.initialadapter.tvshow

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.TvShowData
import aej.code.efficiency.external.constant.Constant
import aej.code.efficiency.external.extension.loadFromPosterName
import aej.code.efficiency.presentation.detailtvshow.DetailTvShowActivity
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
class TvShowViewHolder(val context: Context, val view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

    private var imagePhoto = view.findViewById<ImageView>(R.id.img_photo)
    private var textName = view.findViewById<TextView>(R.id.txt_name)
    private var textStatus = view.findViewById<TextView>(R.id.txt_status)
    private var firstDate = view.findViewById<TextView>(R.id.txt_first_air)
    private var lastDate = view.findViewById<TextView>(R.id.txt_last_air)
    private var tvShowData : TvShowData.TVShow? = null

    init {
        view.setOnClickListener(this)
    }

    fun bind(tvShow: TvShowData.TVShow) {
        tvShowData = tvShow
        textName.text = tvShowData?.name
        textStatus.text = tvShowData?.status
        firstDate.text = tvShowData?.first_air_date
        lastDate.text = tvShowData?.last_air_date
        imagePhoto.loadFromPosterName(tvShowData?.poster)
    }

    override fun onClick(v: View?) {
        tvShowData?.let {
            val detailTvShowPage = Intent(context, DetailTvShowActivity::class.java)
            detailTvShowPage.putExtra(Constant.INTENT_BUNDLE.TV_SHOW_DATA, it)
            context.startActivity(detailTvShowPage)
        }
    }

}