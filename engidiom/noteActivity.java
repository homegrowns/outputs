package com.example.engidiom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engidiom.DB.AppDataFake;
import com.example.engidiom.DB.IdiomCard;
import com.example.engidiom.DB.IdiomDB;
import com.example.engidiom.DB.Member;
import com.example.engidiom.DB.MyApplication;
import com.example.engidiom.DB.YoutubeContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class noteActivity extends AppCompatActivity {

    private YouMainAdapter mainAdapter;
    private LinearLayoutManager linearLayoutManager;
    List<Member> Members;

    ArrayList<IdiomCard> IdiomList;
    TextView t_name, tv_score;
    SharedPreferences sp, sharedPreferences , shared;
    private boolean fabMain_status = false;
    FloatingActionButton fab, fabGame;

    ///리사이클뷰로 노트장만들기 추가 제거 수정 편집 방식 가짜 데이터 베이스 적용
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        setTitle("My note");

        t_name = findViewById(R.id.t_mynote);
        tv_score = findViewById(R.id.tv_score);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        String id = sharedPreferences.getString("ID", " ");


        t_name.setText(id+" 님 welcome");


        Member member = null;
        ReadMembersData();
        for (Member me : Members) {
            if (me.getIdText().equals(id)) {
                member = me;
            }
        }

        int Score = member.getScore();

        tv_score.setText(String.valueOf(Score));


        sp = getSharedPreferences("StudySharedCard", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString(id, null);
        Type type = new TypeToken<ArrayList<IdiomCard>>() {
        }.getType();

        IdiomList = gson.fromJson(json, type);
        if (IdiomList == null) {
            IdiomList = new ArrayList<>();
        }

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////


            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.folder);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        mainAdapter = new YouMainAdapter(IdiomList, noteActivity.this);
        recyclerView.setAdapter(mainAdapter);



        Button backButtom = (Button) findViewById(R.id.backButtonno);
        backButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  toggleFab();
            }
        });

        fabGame = findViewById(R.id.ft_game);
        fabGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_quiz = new Intent(noteActivity.this, Main_quizActivity.class);
                Toast.makeText(noteActivity.this, "퀴즈 버튼 클릭", Toast.LENGTH_SHORT).show();
                noteActivity.this.startActivity(intent_quiz);
                finish();

            }
        });


    }

    // 플로팅 액션 버튼 클릭시 애니메이션 효과
// 플로팅 액션 버튼 클릭시 애니메이션 효과
    public void toggleFab() {
        if(fabMain_status) {
            // 플로팅 액션 버튼 닫기
            // 애니메이션 추가
            ObjectAnimator fc_animation = ObjectAnimator.ofFloat(fabGame, "translationY", 0f);
            fc_animation.start();

            // 메인 플로팅 이미지 변경
            fab.setImageResource(R.drawable.ic_baseline_create_new_folder_24);

        }else {
            // 플로팅 액션 버튼 열기
            ObjectAnimator fc_animation = ObjectAnimator.ofFloat(fabGame, "translationY", -200f);
            fc_animation.start();

            // 메인 플로팅 이미지 변경
            fab.setImageResource(R.drawable.ic_baseline_create_new_folder_24);
        }
        // 플로팅 버튼 상태 변경
        fabMain_status = !fabMain_status;
    }



    private void SaveDB(String id) {
        sp = getSharedPreferences("StudySharedCard", MODE_PRIVATE);


        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(IdiomList);
        editor.putString(id, json);
        editor.apply();
    }

/*    @Override
    protected void onStart() {
        super.onStart();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sch = searchingCard.getText().toString();
                IdiomCard icard = null;
                for (IdiomCard idiomCard : IdiomList) {
                    if (idiomCard.getArrr().equals(sch)) {
                        icard = idiomCard;
                    }
                }

                if (icard != null) {
                    Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(icard.getUrls())));
                    Toast.makeText(noteActivity.this, "숙어 사전검색!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                } else {
                    Toast.makeText(noteActivity.this, "error!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }*/

    protected void ReadMembersData() {

        shared = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = shared.getString("MList", null);
        Type type = new TypeToken<LinkedList<Member>>() {
        }.getType();

        Members = gson.fromJson(json, type); // fromJson() 메소드 이용하여 Members 오브젝트로 읽어 들어 들이는
        if (Members == null) {
            Members = new LinkedList<>();
        }

    }

}