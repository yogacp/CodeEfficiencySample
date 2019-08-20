package aej.code.efficiency.presentation.main.fragments.tvshow

import aej.code.efficiency.data.responses.TvShowData
import android.content.Context
import com.google.gson.Gson

/**
 * Created by Yoga C. Pranata on 2019-08-20.
 * Android Engineer
 */
class TvShowsPresenter(private val context: Context?) : TvShowsContract.UserActionListener {

    private var view: TvShowsContract.View? = null
    private var tvShowList: MutableList<TvShowData.TVShow> = mutableListOf()
    private val gson = Gson()

    override fun setupView(view: TvShowsContract.View) {
        this.view = view
    }

    override fun fetchTvShowList() {
        view?.showProgressbar()
        try {
            val inputStream = context?.assets?.open("json/tv_show_list.json")
            val inputString = inputStream?.bufferedReader().use { it?.readText() }
            val responses = gson.fromJson(inputString, TvShowData.Response::class.java)
            setupTvShowList(responses.data)
            view?.hideProgressbar()
        } catch (ex: Exception) {
            ex.printStackTrace()
            view?.hideProgressbar()
            view?.showError("Error while converting tv show list")
        }
    }

    override fun setupTvShowList(list: List<TvShowData.TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(list)
        view?.setupAdapter(tvShowList)
    }
}