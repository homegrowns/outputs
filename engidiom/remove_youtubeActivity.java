package com.example.engidiom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.engidiom.DB.MyApplication;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class remove_youtubeActivity extends AppCompatActivity {
    Button btn_remove, btn_Cancel ;
    ImageView imgUrl;
    List<YoutubeContent> youtubeContentList;
    /*MyApplication myApplication = (MyApplication) this.getApplication();*/

    EditText et_title2, et_Suntitle2, et_date2;
    TextView t_youtubeId;
    SharedPreferences sharedPreferences;
    int date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_youtube);

        btn_Cancel = findViewById(R.id.btn_취소);
        btn_remove = findViewById(R.id.btn_확인);


        ReadMember_Data();


        Intent intent = getIntent();
        date = intent.getIntExtra("date", 0); //  디폴트 값을-1로 설정하여 업데이트와 추가를 나눈다.
        YoutubeContent youtubeContent = null;




        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                date = intent.getIntExtra("date", 0); //  디폴트 값을-1로 설정하여 업데이트와 추가를 나눈다.
                YoutubeContent youtubeContent = null;



                // 동영상 찾기
                for (YoutubeContent y : youtubeContentList) {
                    if (y.getId() == date) {
                        youtubeContent = y;
                    }
                }

                youtubeContentList.remove(youtubeContent);

                Intent intentre = new Intent(remove_youtubeActivity.this, yvideoActivity.class);
                intentre.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               remove_youtubeActivity.this.startActivity(intentre);
            }
        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCan = new Intent(remove_youtubeActivity.this, yvideoActivity.class);
                intentCan.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                remove_youtubeActivity.this.startActivity(intentCan);
            }
        });

    }




    @Override
    protected void onPause() {
        UpdataAndSaveData(youtubeContentList);
        super.onPause();
    }

    private void UpdataAndSaveData(List<YoutubeContent> youtubeContents) {
        sharedPreferences = getSharedPreferences("SHAREDPRE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(youtubeContentList);
        editor.putString("List", json);
        Toast.makeText(remove_youtubeActivity.this, "edit and save info", Toast.LENGTH_SHORT).show();

        editor.commit();
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

}


