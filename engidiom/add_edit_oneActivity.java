package com.example.engidiom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engidiom.DB.Member;
import com.example.engidiom.DB.MyApplication;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class add_edit_oneActivity extends AppCompatActivity {

    Button btn_Ok, btn_Cancel, btn_Remove;

    ArrayList<YoutubeContent> youtubeContentList;
    MyApplication myApplication = (MyApplication) this.getApplication();
    EditText et_title, et_Suntitle, et_youtubeUrl, et_date;
    TextView tv_Idview;
    SharedPreferences sharedPreferences;
    String forIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        btn_Ok = findViewById(R.id.btn_Ok);
        btn_Cancel = findViewById(R.id.btn_Cancel);


        ReadMember_Data();

        et_title = findViewById(R.id.et_title);
        et_Suntitle = findViewById(R.id.et_Subt);
        et_youtubeUrl = findViewById(R.id.et_youtubeUrl);
        et_date = findViewById(R.id.et_date);
        tv_Idview = findViewById(R.id.tv_Idview);

        Intent intent = getIntent();
        forIndex = intent.getStringExtra("videoUrl"); //  디폴트 값을-1로 설정하여 업데이트와 추가를 나눈다.
      YoutubeContent youtubeContent = null;

        for (YoutubeContent y : youtubeContentList) {
            if (y.getVideoURL().equals(forIndex) ) {
                youtubeContent = y;
            }
        }
        YoutubeContent youconForIdex = youtubeContent;
        int youIndex = youtubeContentList.indexOf(youconForIdex);

        if ( youIndex >= 0 ) {
                // 동영상 수정 위해 인터페이스 띄우기
            tv_Idview.setText(String.valueOf(youIndex));
            et_title.setText(youtubeContent.getTitle());
            et_Suntitle.setText(youtubeContent.getSubTitle());
            et_youtubeUrl.setText(youtubeContent.getVideoURL());
            et_date.setText(String.valueOf(youtubeContent.getDateOfPost()));
            // String.valyeOf int ->문자열로
        }

        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (youIndex >= 0) {
                        //  업데이트  // 아이디 넘버로 받으면 자꾸꼬여버린다 다른 파라미터 이용

                        YoutubeContent updateYoutubeContent = new YoutubeContent(youIndex, Integer.parseInt(et_date.getText().toString()), et_title.getText().toString(), et_Suntitle.getText().toString(), "https://img.youtube.com/vi/"+et_youtubeUrl.getText().toString()+"/default.jpg", et_youtubeUrl.getText().toString());

                        youtubeContentList.set(youIndex, updateYoutubeContent);
                    } else {
                        // 새 유뷰드동영상 더하기기
                        // Create youtubecontent object

                      int upId = youtubeContentList.size();


                        YoutubeContent youcon = findIndexyou(upId);
                        if (youtubeContentList.size() == 0) {
                            YoutubeContent youtubeContent1 = new YoutubeContent(0, Integer.parseInt(et_date.getText().toString()), et_title.getText().toString(), et_Suntitle.getText().toString(), "https://img.youtube.com/vi/"+et_youtubeUrl.getText().toString()+"/default.jpg", et_youtubeUrl.getText().toString());
                            youtubeContentList.add(youtubeContent1);

                        }  else if (youcon == null) {


                            YoutubeContent youtubeContent1 = new YoutubeContent(upId, Integer.parseInt(et_date.getText().toString()), et_title.getText().toString(), et_Suntitle.getText().toString(), "https://img.youtube.com/vi/"+et_youtubeUrl.getText().toString()+"/default.jpg", et_youtubeUrl.getText().toString());
                            youtubeContentList.add(youtubeContent1);



                        } else if(youcon.getId() == upId) { // 같은 인덱스 id 를 걸러넬 메소드만든다

                            YoutubeContent youtubeContent1 = new YoutubeContent(upId+1, Integer.parseInt(et_date.getText().toString()), et_title.getText().toString(), et_Suntitle.getText().toString(), "https://img.youtube.com/vi/"+et_youtubeUrl.getText().toString()+"/default.jpg", et_youtubeUrl.getText().toString());
                            youtubeContentList.add(youtubeContent1);

                        }



                        }

                    // 메인으로 돌아간다.


                    Intent intentAdd = new Intent(add_edit_oneActivity.this, yvideoActivity.class);
                    intentAdd.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    add_edit_oneActivity.this.startActivity(intentAdd);


                    Toast.makeText(add_edit_oneActivity.this, "UpdataAndSaveData", Toast.LENGTH_SHORT).show();

                }

        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @Override
    protected void onPause() {
        UpdataAndSaveData(youtubeContentList);
        super.onPause();
    }

    public void UpdataAndSaveData(List<YoutubeContent> youtubeContents) {
        sharedPreferences = getSharedPreferences("SHAREDPRE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(youtubeContentList);
        editor.putString("List", json);
        Toast.makeText(add_edit_oneActivity.this, "edit and save info", Toast.LENGTH_SHORT).show();

        editor.commit();
    }



    public void ReadMember_Data() {
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
    public YoutubeContent findIndexyou(int upId) {
        for (YoutubeContent youcon : youtubeContentList) {
            if (youcon.getId() == (upId)) {
                return youcon;
            }
        }
        return null;
    }

    @Override
    public void onConfigurationChanged(@NonNull @NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "가로", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "세로", Toast.LENGTH_SHORT).show();
        }
    }
}