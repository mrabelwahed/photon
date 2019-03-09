package com.ramadan.photon.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ramadan.photon.R
import com.ramadan.photon.network.NetworkUtil
import com.ramadan.photon.ui.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutmg = LinearLayoutManager(applicationContext)
        val divider = DividerItemDecoration(feedList.context, DividerItemDecoration.VERTICAL)
        feedList.layoutManager = linearLayoutmg
        feedAdapter = FeedAdapter(applicationContext)
        feedList.adapter = feedAdapter
        feedList.addItemDecoration(divider)

        swipeRefreshLayout.setOnRefreshListener(this)

        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)

        observeFeed()

        swipeRefreshLayout.post {
            swipeRefreshLayout.isRefreshing = true
            getFeed("wgkJgazE")
        }

    }

    override fun onRefresh() {
        getFeed("wgkJgazE")
    }

    fun getFeed(user: String) {
        if (NetworkUtil.isNetworkAvailable(this)) {
            feedList.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
            feedViewModel.getFeed(user)
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


}
