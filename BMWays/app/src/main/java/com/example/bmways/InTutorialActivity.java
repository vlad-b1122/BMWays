package com.example.bmways;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class InTutorialActivity extends AppCompatActivity {

    public TextView inTutorialTitle;
    public TextView inTutorialDescription;
    public YouTubePlayerView youtube_player_view;

    public String titulo;
    public String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_tutorial);

        inTutorialTitle = findViewById(R.id.inTutorialTitle);
        inTutorialDescription = findViewById(R.id.inTutorialDescription);

        Bundle bundle = getIntent().getExtras();
        this.titulo = bundle.getString("titulo");
        this.descripcion = bundle.getString("descripcion");
        inTutorialTitle.setText(titulo);
        inTutorialDescription.setText("Link: https://www.youtube.com/watch?v=" + descripcion);

        youtube_player_view = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youtube_player_view);

        youtube_player_view.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = descripcion;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }
}