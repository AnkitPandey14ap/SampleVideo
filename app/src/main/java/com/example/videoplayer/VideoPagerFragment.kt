package com.example.videoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.videoplayer.viewpager2.ScreenSlidePagerAdapter
import com.example.videoplayer.viewpager2.VideoItem
import com.example.videoplayer.viewpager2.VideosAdapter
import java.util.*

class VideoPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val videosViewPager: ViewPager2 = view.findViewById(R.id.viewPagerVideos)
        videosViewPager.adapter = VideosAdapter(generateList())

        val generateList = generateList()
        val screenSlidePagerAdapter = ScreenSlidePagerAdapter(activity)
//        screenSlidePagerAdapter.add
        videosViewPager.adapter= screenSlidePagerAdapter
    }

    private fun generateList(): List<VideoItem> {
//        private val dashUrl = "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd"
//        private val mp4Url = "https://html5demos.com/assets/dizzy.mp4"


        val videoItems: MutableList<VideoItem> = ArrayList()
        val item = VideoItem()
        item.videoURL = "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd"
        item.videoTitle = "Women In Tech"
        item.videoDesc = "International Women's Day 2019"
        videoItems.add(item)
        val item2 = VideoItem()
        item2.videoURL = "https://html5demos.com/assets/dizzy.mp4"
        item2.videoTitle = "Sasha Solomon"
        item2.videoDesc = "How Sasha Solomon Became a Software Developer at Twitter"
        videoItems.add(item2)
        val item3 = VideoItem()
        item3.videoURL = "https://liciolentimo.co.ke/img/videos/facebook2.mp4"
        item3.videoTitle = "Happy Hour Wednesday"
        item3.videoDesc = " Depth-First Search Algorithm"
        videoItems.add(item3)
        return videoItems
    }
}