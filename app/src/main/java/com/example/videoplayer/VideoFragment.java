package com.example.videoplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videoplayer.viewpager2.VideoItem;
import com.example.videoplayer.viewpager2.VideosAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ViewPager2 videosViewPager = view.findViewById(R.id.viewPagerVideos);
        videosViewPager.setAdapter(new VideosAdapter(generateList()));
    }


    private List<VideoItem> generateList() {
        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem item = new VideoItem();
        item.videoURL = "https://liciolentimo.co.ke/img/videos/facebook.mp4";
        item.videoTitle = "Women In Tech";
        item.videoDesc = "International Women's Day 2019";
        videoItems.add(item);

        VideoItem item2 = new VideoItem();
        item2.videoURL = "https://liciolentimo.co.ke/img/videos/facebook3.mp4";
        item2.videoTitle = "Sasha Solomon";
        item2.videoDesc = "How Sasha Solomon Became a Software Developer at Twitter";
        videoItems.add(item2);

        VideoItem item3 = new VideoItem();
        item3.videoURL = "https://liciolentimo.co.ke/img/videos/facebook2.mp4";
        item3.videoTitle = "Happy Hour Wednesday";
        item3.videoDesc = " Depth-First Search Algorithm";
        videoItems.add(item3);

        return videoItems;

    }
}