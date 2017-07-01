package com.example.ajaykumar.mediaplayer;


import android.media.MediaPlayer;
import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    private List<Songs> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter mAdapter;
    public TextView songName,startTimeField,endTimeField;
    private MediaPlayer mediaPlayer;
    private ArrayList<String> songs;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler() {
        @Override
        public void publish(LogRecord logRecord) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private ImageButton playButton,pauseButton;
    public static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.view2);

        mAdapter = new SongAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Songs movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();
        songs = new ArrayList<>();
        songName = (TextView)findViewById(R.id.textView4);
        startTimeField =(TextView)findViewById(R.id.textView1);
        endTimeField =(TextView)findViewById(R.id.textView2);
        seekbar = (SeekBar)findViewById(R.id.seekBar1);
        playButton = (ImageButton)findViewById(R.id.imageButton1);
        pauseButton = (ImageButton)findViewById(R.id.imageButton2);
        songName.setText("song.mp3");
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        seekbar.setClickable(false);
        pauseButton.setEnabled(false);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    public void play(View view) {
        Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        if (oneTimeOnly == 0) {
            seekbar.setMax((int) finalTime);
            oneTimeOnly = 1;

        }
        endTimeField.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) finalTime)))
        );

        startTimeField.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) startTime)))
        );

        seekbar.setProgress((int) startTime);
        //myHandler.postDelayed(UpdateSongTime, 100);
        pauseButton.setEnabled(true);
        playButton.setEnabled(false);
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            startTimeField.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
           // myHandler.postDelayed(this, 100);
      }
    };
    public void pause(View view){
        Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
        mediaPlayer.pause();
        pauseButton.setEnabled(false);
        playButton.setEnabled(true);
    }
    public void forward(View view){
        int temp = (int)startTime;
        if((temp+forwardTime)<=finalTime){
            startTime = startTime + forwardTime;
            mediaPlayer.seekTo((int) startTime);
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Cannot jump forward 5 seconds",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void rewind(View view){
        int temp = (int)startTime;
        if((temp-backwardTime)>0){
            startTime = startTime - backwardTime;
            mediaPlayer.seekTo((int) startTime);
        }
        else{ Toast.makeText(getApplicationContext(),
                "Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareMovieData() {
        Songs movie = new Songs("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Songs("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Songs("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Songs("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Songs("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Songs("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Songs("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Songs("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Songs("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Songs("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Songs("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Songs("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Songs("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Songs("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Songs("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Songs("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar
//        // if it is present.
//        getMenuInflater().inflate(R., menu);
//        return true;
//    }

