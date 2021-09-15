package com.example.engidiom;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Myservice3 extends Service {
    MediaPlayer mp1;
    MediaPlayer mp3;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("start", "onCreate");
        mp3 = MediaPlayer.create(this, R.raw.water);
        mp3.setLooping(false);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("startAgain", "onStartCommand");
        mp3.start(); // 노래 시작
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 서비스가 종료될 때 실행
        mp3.stop(); // 음악 종료
        Log.d("종료", "onDestroy");



    }
}
