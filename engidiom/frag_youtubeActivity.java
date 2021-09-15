package com.example.engidiom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;


public class frag_youtubeActivity extends AppCompatActivity {

    YouTubePlayerView yv_youtubeview;
    String videoIdUrl;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_youtube);

        Intent intent = getIntent();

        videoIdUrl = intent.getStringExtra("VdURL"); // 해당영상 아이디

    yv_youtubeview =findViewById(R.id.yv_youtubeview);

    getLifecycle().addObserver(yv_youtubeview);
  // 유튜브 라이브러리 listener 설정
    yv_youtubeview.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
        @Override
        public void onError(@NotNull YouTubePlayer youTubePlayer, PlayerConstants.@NotNull PlayerError error) {
            super.onError(youTubePlayer, error);
            Toast.makeText(frag_youtubeActivity.this, "error", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onReady(@NotNull YouTubePlayer youTubePlayer) {
            super.onReady(youTubePlayer);
            String videoId = videoIdUrl;

            youTubePlayer.loadVideo(videoId, 0); // 영상 업로드
        }
    });


        Button backButtom = (Button) findViewById(R.id.Bbutton);
        backButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}