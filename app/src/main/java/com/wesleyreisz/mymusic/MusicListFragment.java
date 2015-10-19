package com.wesleyreisz.mymusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Julian on 10/19/2015.
 */
public class MusicListFragment extends Fragment {

    private List<Song> songs;
    ListView listView;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        listView.findViewById(R.id.listViewSongs);
        MockMusicService service = new MockMusicService();
        List<Song> songs = service.findAll();
        SongAdapter songAdapter = new SongAdapter(this, R.layout.activity_my_music, songs);

        //inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list, container, false);

    }
}
