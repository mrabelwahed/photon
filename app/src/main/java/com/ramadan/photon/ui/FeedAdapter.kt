package com.ramadan.photon.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imageloadinglib.core.Photon
import com.ramadan.photon.R
import com.ramadan.photon.model.Feed
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedAdapter (val context:Context) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private val data = ArrayList<Feed>()
    private val imageLoader = Photon.getInstance(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.feed_item,parent,false)
        return FeedViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.likeCount.text = data[position].likeCount.toString().plus(" likes")
        imageLoader.displayImage(data[position].imgUrl,holder.userImage,R.drawable.place_holder)
    }


    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name = view.name
        var likeCount = view.likeCount
        var userImage = view.userImage


    }

     fun setData(feed:ArrayList<Feed>){
        data.addAll(feed)
        notifyDataSetChanged()
    }
}