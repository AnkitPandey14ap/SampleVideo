package com.example.videoplayer.player

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource

enum class StreamType {
    DEFAULT,
    DASH
}

class VideoPlayer {
    private var playbackPosition: Long? = 0
    private var simpleExoplayer: SimpleExoPlayer? = null


    private constructor() {}
    private constructor(context: Context) {
        if (simpleExoplayer == null)
            simpleExoplayer = SimpleExoPlayer.Builder(context).build()
    }

    companion object {
        private var instance: VideoPlayer? = null
        fun getInstance(context: Context): VideoPlayer? {
            if (instance == null) {
//                synchronized(VideoPlayer::class.java) {
//                    if (instance == null) {
                        instance = VideoPlayer(context)
//                    }
//                }
            }
            return instance
        }
    }

    fun initVideo(
        url: String,
        exoplayerView: PlayerView,
        eventListner: Player.EventListener,
        dataSourceFactory: DataSource.Factory
    ): Boolean {

        preparePlayer(url, dataSourceFactory)
        exoplayerView.player = simpleExoplayer
        if (playbackPosition == null)
            playbackPosition = 0
        simpleExoplayer?.seekTo(playbackPosition!!)
        simpleExoplayer?.playWhenReady = true
        simpleExoplayer?.addListener(eventListner)

        return true
    }


    private fun preparePlayer(videoUrl: String, dataSourceFactory: DataSource.Factory) {
        val uri = Uri.parse(videoUrl)
        var type = if (videoUrl.contains(".mp4")) StreamType.DEFAULT else StreamType.DASH
        val mediaSource = buildMediaSource(uri, type, dataSourceFactory)
        simpleExoplayer?.prepare(mediaSource)
    }

    private fun buildMediaSource(
        uri: Uri,
        type: StreamType,
        dataSourceFactory: DataSource.Factory
    ): MediaSource {
        return if (type == StreamType.DASH) {
            DashMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        } else {
            ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        }
    }

    fun releasePlayer() {
        playbackPosition = simpleExoplayer?.currentPosition
        simpleExoplayer?.release()
    }
}
