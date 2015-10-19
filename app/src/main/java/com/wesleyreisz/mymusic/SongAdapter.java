package com.wesleyreisz.mymusic;

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Julian on 10/19/2015.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");
    private Context nContext;
    private List<Song> nEntries;
    public SongAdapter(Context context, int textViewResourceId, List<Song> entries) {
        super(context, textViewResourceId, entries);
        nContext = context;
        nEntries = entries;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater)nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_for_each_song, parent, false);
        }

        final Song song = nEntries.get(position);

        TextView textViewTitle = (TextView)view.findViewById(R.id.textViewSongTitle);
        textViewTitle.setText(song.getSongTitle());

        TextView textViewArtist = (TextView)view.findViewById(R.id.textViewSongArtist);
        textViewArtist.setText(song.getArtistName());

        TextView textViewDate = (TextView)view.findViewById(R.id.textViewSongDate);
        textViewDate.setText(df.format(song.getSongPublishedDate()));

        return view;
    }
}
