package aej.code.efficiency.presentation.main.fragments.tvshow

import aej.code.efficiency.R
import aej.code.efficiency.data.responses.TvShowData
import aej.code.efficiency.domain.adapter.initialadapter.tvshow.TvShowAdapter
import aej.code.efficiency.external.extension.debugMode
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class TvShowsFragment : Fragment(), TvShowsContract.View, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: TvShowsPresenter? = null
    private var tvShowAdapter: TvShowAdapter? = null //Initial Adapter
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mLayoutManager = GridLayoutManager(context, 1)
        initConfig()
    }

    override fun initConfig() {
        tvShowsSwipeLayout.setOnRefreshListener(this)
        presenter = TvShowsPresenter(context)
        presenter?.setupView(this)
        presenter?.fetchTvShowList()
    }

    override fun showError(message: String) {
        debugMode {
            toast(message)
        }
    }

    override fun onRefresh() {
        presenter?.fetchTvShowList()
    }

    override fun showProgressbar() {
        tvShowsSwipeLayout.isRefreshing = true
    }

    override fun hideProgressbar() {
        tvShowsSwipeLayout.isRefreshing = false
    }

    override fun setupAdapter(tvShowList: List<TvShowData.TVShow>) {
        tvShowAdapter = context?.let {
            TvShowAdapter(it, tvShowList)
        }

        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = mLayoutManager
        }

//        rvTvShows.setUp(
//            tvShowList,
//            R.layout.item_tv_shows,
//            {
//                img_photo.loadFromPosterName(it.poster)
//                txt_name.text = it.name
//                txt_status.text = it.status
//                txt_first_air.text = it.first_air_date
//                txt_last_air.text = it.last_air_date
//            },
//            {
//                val detailTvShowPage = Intent(context, DetailTvShowActivity::class.java)
//                detailTvShowPage.putExtra(Constant.INTENT_BUNDLE.TV_SHOW_DATA, it)
//                startActivity(detailTvShowPage)
//            },
//            mLayoutManager
//        )
    }
}