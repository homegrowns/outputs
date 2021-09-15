package com.example.engidiom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engidiom.DB.AppDataFake;
import com.example.engidiom.DB.IdiomCard;
import com.example.engidiom.DB.IdiomDB;
import com.example.engidiom.DB.Member;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudyDetailActivity extends AppCompatActivity {
    ArrayList<IdiomCard> IdiomList ;
    IdiomCard idiomCard;
    TextToSpeech tts, ttskor;
    String tittle;
    SharedPreferences sp;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_detail);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        String id = sp.getString("ID", " ");

        ttskor = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    ttskor.setLanguage(Locale.KOREAN);
                } else{
                    showState("객체초기화 문제발생");
                }
            }
        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);

                } else{
                    showState("객체초기화 문제발생");
                }
            }
        });

        ReadMemberCard(id);


        tittle = getIntent().getStringExtra("title");

        TextView textViewTitle = findViewById(R.id.textTitle);
        textViewTitle.setText(tittle);
////////////////////////////////
        int image = getIntent().getIntExtra("image", 0);

        ImageView imageView = findViewById(R.id.imagestudy);
        imageView.setImageResource(image);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String subtittle = getIntent().getStringExtra("subtitle");
        TextView textViewSubTitle = findViewById(R.id.textViewSubTitle);
        textViewSubTitle.setText(subtittle);


        Button backButtom = (Button) findViewById(R.id.backButtonTeil);
        backButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button btn_addnote = (Button) findViewById(R.id.btn_noteAdd);
        btn_addnote.setOnClickListener(v -> {
            AddCard();
        });

        textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(textViewTitle.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        textViewSubTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttskor.speak(textViewSubTitle.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    private void AddCard() {
        sp = getSharedPreferences("login", MODE_PRIVATE);

        String id = sp.getString("ID", " ");

        String tittle = getIntent().getStringExtra("title");
        int image = getIntent().getIntExtra("image", 0);
        String subtittle = getIntent().getStringExtra("subtitle");
        String urls = getIntent().getStringExtra("urls");
//이미지 글라이드 삽입 해결하자
        IdiomCard iCard = null;
        ReadMemberCard(id);
        for (IdiomCard idiomCard : IdiomList) {
            if (idiomCard.getArrr().equals(tittle)) {
                iCard = idiomCard;
            }
        }


        if (iCard != null) {
            Toast.makeText(this, "이미저장한 숙어", Toast.LENGTH_SHORT).show();
            return;
        }

        /////////////////////////////////////////////////////////////////////////////////////
      /*  int id = IdiomList.get(IdiomList.size() - 1).getId()+1;*/

        IdiomCard idiomCards = new IdiomCard( tittle, subtittle, urls, image);
        IdiomList.add(idiomCards);
        SaveDB(id);
        finish();

    }



    private void SaveDB(String id) {
        sp = getSharedPreferences("StudySharedCard", MODE_PRIVATE);


        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(IdiomList);
        editor.putString(id, json);
        editor.apply();
    }

    protected void ReadMemberCard(String id) {
        sp = getSharedPreferences("StudySharedCard", MODE_PRIVATE);


        Gson gson = new Gson();
        String json = sp.getString(id, null);
        Type type = new TypeToken<ArrayList<IdiomCard>>() {
        }.getType();

        IdiomList = gson.fromJson(json, type); // fromJson() 메소드 이용하여 Members 오브젝트로 읽어 들어 들이는
        if (IdiomList == null) {
            IdiomList = new ArrayList<>();
        }

    }


    private void showState(String msg) {
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}

