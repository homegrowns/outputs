package com.example.engidiom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.engidiom.DB.AppDataFake;
import com.example.engidiom.DB.Member;

public class HomeActivity extends AppCompatActivity {
TextView t_Id;
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("메인타이틀");

        t_Id = findViewById(R.id.textViewVeryfiedId);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        String id = sharedPreferences.getString("ID", " ");
        t_Id.setText(id+" 님 welcome");

////////////////////////////////////////////////////////////////////////////////////////////////////
        int loginedMemberId = getIntent().getIntExtra("loginedMemberAge", 0);

        Member verifiedmember = LoginActivity.findmember2(loginedMemberId);     /// 같다쓴코드 한줄한줄 이해하도록 주석달기

       /* TextView textViewVeryfiedId = findViewById(R.id.textViewVeryfiedId);
        textViewVeryfiedId.setText(verifiedmember.getName()+" 님 Welcome ");  //////////////메인 전광판 이름데이터전달*/

////////////////////////////////////////////////////////////////////////////////////////////////////


        ImageButton studyButtom = (ImageButton) findViewById(R.id.studyButton);

        studyButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studyb = new Intent(HomeActivity.this, studyActivity.class);
                HomeActivity.this.startActivity(studyb);
            }
        });
        ImageButton commuButton = (ImageButton) findViewById(R.id.commuButton);
        commuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commu = new Intent(HomeActivity.this, commuMainActivity.class);
                HomeActivity.this.startActivity(commu);
            }
        });
        ImageButton note = (ImageButton) findViewById(R.id.MynoteButton);
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mynote = new Intent(HomeActivity.this, noteActivity.class);

                HomeActivity.this.startActivity(mynote);

            }
        });

        ImageButton youtubebu = (ImageButton) findViewById(R.id.YoutubeButton);
        youtubebu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent youtube = new Intent(HomeActivity.this, yvideoActivity.class);
                HomeActivity.this.startActivity(youtube);
            }
        });
        ImageButton trans = (ImageButton) findViewById(R.id.transButton);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent ts = new Intent(HomeActivity.this, TranslationMain.class);
              HomeActivity.this.startActivity(ts);
            }
        });
        ImageButton setting = (ImageButton) findViewById(R.id.settingButton);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(HomeActivity.this, MainSettingActivity.class);
                settings.putExtra("loginedMemberAge", verifiedmember.getAge());
                HomeActivity.this.startActivity(settings);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"홈타이틀 사망",Toast.LENGTH_SHORT).show();
    }
}