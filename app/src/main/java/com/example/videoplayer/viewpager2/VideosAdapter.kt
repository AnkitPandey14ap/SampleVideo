package com.example.videoplayer.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.R
import com.example.videoplayer.player.VideoPlayer
import com.example.videoplayer.viewpager2.VideosAdapter.VideoViewHolder
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.item_videos_container.view.*


class VideosAdapter(private val mVideoItems: List<VideoItem>) :
    RecyclerView.Adapter<VideoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_videos_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(mVideoItems[position])
    }

    override fun getItemCount(): Int {
        return mVideoItems.size
    }

    class VideoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), Player.EventListener {
        private var player: VideoPlayer? = null

        var dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            itemView.context, "exoplayer-sample")

        fun setVideoData(videoItem: VideoItem) {
            player = VideoPlayer.getInstance(itemView.context)
            videoItem.videoURL?.let { player?.initVideo(it, itemView.exoplayerView, this, dataSourceFactory) }
        }

    }

}