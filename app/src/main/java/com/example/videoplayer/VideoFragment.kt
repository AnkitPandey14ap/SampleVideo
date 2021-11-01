package com.example.videoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videoplayer.player.VideoPlayer
import com.example.videoplayer.viewpager2.VideoItem
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
    lateinit var playBean: VideoItem
    private var position = -1
    lateinit var source: String

    lateinit var dataSourceFactory: DataSource.Factory;


    companion object {

        const val SOURCE = "source"
        const val POSITION = "position"
        const val PLAY_BEAN = "play_bean"

        fun newInstance(args: Bundle): VideoFragment {
            val videoFragment = VideoFragment()
            videoFragment.arguments = args
            return videoFragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            requireArguments().getString(SOURCE)
            playBean = requireArguments().getParcelable(PLAY_BEAN)!!
            source = requireArguments().getString(SOURCE, SOURCE)
            position = requireArguments().getInt(POSITION, -1)
        }
        println("Ankit onViewCreated :$position")

        dataSourceFactory = DefaultDataSourceFactory(
            requireContext(), "todo-exoplayer-sample"
        )


    }

    override fun onStart() {
        player = VideoPlayer.getInstance(requireContext())
        playBean.videoURL?.let { player?.initVideo(it, exoplayerView, this, dataSourceFactory) }
        println("Ankit onStart $position")
        super.onStart()
    }

    override fun onResume() {
        println("Ankit onResume $position")
        player?.startVideo()
        super.onResume()
    }

    override fun onPause() {
        player?.pausePlayer()
        println("Ankit onPause $position")
        super.onPause()
    }

    override fun onStop() {
        player?.releasePlayer()
        println("Ankit onStop $position")
        super.onStop()
    }

    override fun onDestroy() {
        println("Ankit onDestroy $position")
        super.onDestroy()
    }
}