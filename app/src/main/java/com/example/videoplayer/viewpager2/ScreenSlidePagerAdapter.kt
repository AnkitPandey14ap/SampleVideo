package com.example.videoplayer.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.videoplayer.VideoFragment

class ScreenSlidePagerAdapter(
    fa: FragmentActivity?,
    var generateList: List<VideoItem>
) : FragmentStateAdapter(fa!!) {
    override fun createFragment(position: Int): Fragment {

        val bundle = Bundle()
        bundle.putParcelable(VideoFragment.PLAY_BEAN, generateList[position])
        bundle.putString(VideoFragment.SOURCE, "source")
        bundle.putInt(VideoFragment.POSITION, position)

        return VideoFragment.newInstance(bundle)
    }

    override fun getItemCount(): Int {
        return generateList.size
    }
}