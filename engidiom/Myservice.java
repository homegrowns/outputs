package com.example.engidiom;

import android.app.Service;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Myservice extends Service {
 MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("start", "onCreate");
        mp = MediaPlayer.create(this, R.raw.barkingup);
        mp.setLooping(false);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("startAgain", "onStartCommand");
        mp.start(); // 노래 시작
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 서비스가 종료될 때 실행
        mp.stop(); // 음악 종료
        Log.d("종료", "onDestroy");



    }


}
