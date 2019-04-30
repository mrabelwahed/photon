package com.photon.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.imageloadinglib.core.Photon
import com.photon.common.FEED_PARAM
import com.photon.R
import com.photon.network.NetworkUtil
import com.photon.ui.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var feedViewModel: FeedViewModel
    private lateinit var feedAdapter: FeedAdapter

    override fun initUI() {
        val linearLayoutmg = LinearLayoutManager(applicationContext)
        val divider = DividerItemDecoration(feedList.context, DividerItemDecoration.VERTICAL)
        feedList.layoutManager = linearLayoutmg
        feedAdapter = FeedAdapter(applicationContext)
        feedList.adapter = feedAdapter
        feedList.addItemDecoration(divider)
        swipeRefreshLayout.setOnRefreshListener(this)

        feedViewModel = ViewModelProviders.of(this,viewModelFactory)[FeedViewModel::class.java]
        observeFeed()
        swipeRefreshLayout.post {
            swipeRefreshLayout.isRefreshing = true
            getFeed(FEED_PARAM)
        }
    }

    override fun getLayoutById() = R.layout.activity_main

    override fun onRefresh() {
        getFeed(FEED_PARAM)
    }

    fun getFeed(user: String) {
        if (NetworkUtil.isNetworkAvailable(this)) {
            feedList.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
            feedViewModel.getFeed(user)
            swipeRefreshLayout.isRefreshing = false
        } else {
            feedList.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
            swipeRefreshLayout.isRefreshing = false
        }

    }

    fun observeFeed() {
        feedViewModel.getLiveData().observe(this, Observer {
            swipeRefreshLayout.isRefreshing = false
            feedAdapter.setData(ArrayList(it))
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Photon.getInstance(this).cancelAll()
    }

}
