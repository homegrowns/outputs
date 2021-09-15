package com.example.engidiom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.engidiom.DB.MyApplication;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class yvideoActivity extends AppCompatActivity {
    Button Addbtn, back, btn_save;
    Menu menu;
    private static final String TAG = "Youtubecontent App";
    MyApplication myApplication = (MyApplication) this.getApplication();
    ArrayList<YoutubeContent> youtubeContentList;
    SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yvideo);


        ReadMember_Data();


        Log.d(TAG, "onCreate" + youtubeContentList.toString() );


       Addbtn = findViewById(R.id.Addbtn);

       Addbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(yvideoActivity.this, add_edit_oneActivity.class);
               startActivity(intent);
           }
       });

       back = findViewById(R.id.youtubackButtony);
     back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });

     btn_save =findViewById(R.id.btn_save);
     btn_save.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(yvideoActivity.this, "현아이템 배열순서 저장", Toast.LENGTH_SHORT).show();
             UpdataAndSaveData(); // 아이템 순서 저장
         }
     });

        recyclerView = findViewById(R.id.Recyc);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdepter(youtubeContentList, yvideoActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    private void UpdataAndSaveData() {
        sharedPreferences = getSharedPreferences("SHAREDPRE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(youtubeContentList);
        editor.putString("List", json);
        editor.apply();
    }

    protected void ReadMember_Data() {
        sharedPreferences = getSharedPreferences("SHAREDPRE", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("List", null);
        Type type = new TypeToken<List<YoutubeContent>>() {
        }.getType();

        youtubeContentList = gson.fromJson(json, type); // fromJson() 메소드 이용하여 Members 오브젝트로 읽어 들어 들이는
        if (youtubeContentList == null) {
            youtubeContentList = new ArrayList<>();
        }

    }





    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {

            case R.id.menu_dateAscending:
                Collections.sort(youtubeContentList, YoutubeContent.YoutubeContenttitl날짜오름차순Comparator);
                Toast.makeText(yvideoActivity.this, "오래된 업데이트순", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_dateDiscending:
                Collections.sort(youtubeContentList, YoutubeContent.YoutubeContenttitle날짜내림차순Comparator);
                Toast.makeText(yvideoActivity.this, "최근 업데이트먼저", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


}