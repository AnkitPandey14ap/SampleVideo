package com.example.videoplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.videoplayer.player.VideoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VideoFragment : Fragment(), Player.EventListener {
    private var player: VideoPlayer? = null
    private val dashUrl = "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            requireContext(), "exoplayer-sample")
        player = VideoPlayer.getInstance(requireContext())
        player?.initVideo( dashUrl, exoplayerView, this, dataSourceFactory)
    }
}