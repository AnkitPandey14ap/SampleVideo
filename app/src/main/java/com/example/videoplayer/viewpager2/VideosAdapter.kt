package com.example.videoplayer.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.R
import com.example.videoplayer.viewpager2.VideosAdapter.VideoViewHolder

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
        RecyclerView.ViewHolder(itemView) {
        var mVideoView: VideoView
        var txtTitle: TextView
        var txtDesc: TextView
        var mProgressBar: ProgressBar
        fun setVideoData(videoItem: VideoItem) {
            txtTitle.text = videoItem.videoTitle
            txtDesc.text = videoItem.videoDesc
            mVideoView.setVideoPath(videoItem.videoURL)
            mVideoView.setOnPreparedListener { mp ->
                mProgressBar.visibility = View.GONE
                mp.start()
                val videoRatio =
                    mp.videoWidth / mp.videoHeight.toFloat()
                val screenRatio =
                    mVideoView.width / mVideoView.height.toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    mVideoView.scaleX = scale
                } else {
                    mVideoView.scaleY = 1f / scale
                }
            }
            mVideoView.setOnCompletionListener { mp -> mp.start() }
        }

        init {
            mVideoView = itemView.findViewById(R.id.videoView)
            txtTitle = itemView.findViewById(R.id.txtTitle)
            txtDesc = itemView.findViewById(R.id.txtDesc)
            mProgressBar = itemView.findViewById(R.id.progressBar)
        }
    }

}