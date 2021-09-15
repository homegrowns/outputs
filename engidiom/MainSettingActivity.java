package com.example.engidiom;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engidiom.DB.AppDataFake;
import com.example.engidiom.DB.Member;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson; import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class MainSettingActivity extends AppCompatActivity {
    private EditText idText;
    private EditText Password;
    private EditText Name;
    private EditText age;
    List<Member> Members;
    String idtext;

    SharedPreferences sharedPreferences;

// 검색기능추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stting);


        idText = findViewById(R.id.idTextwith);
        Password = findViewById(R.id.Passwordwith);
        Name = findViewById(R.id.nametextwith);
        age = findViewById(R.id.et_age);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        String id = sharedPreferences.getString("ID", " ");
        idText.setText(id);

        int loginedMemberId = getIntent().getIntExtra("loginedMemberAge", 0);

        Member verifiedmember = LoginActivity.findmember2(loginedMemberId);     /// 같다쓴코드 한줄한줄 이해하도록 주석달기

        TextView textViewVeryfiedId = findViewById(R.id.et_age);
        textViewVeryfiedId.setText(String.valueOf(verifiedmember.getAge()));  //////////////editText에 나이전달


        ImageButton imb_logout = (ImageButton) findViewById(R.id.imb_logout);
        imb_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(MainSettingActivity.this, LoginActivity.class);
                sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(MainSettingActivity.this, "로그아웃", Toast.LENGTH_SHORT).show();
                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(logout);
            }
        });

        Button btn_withdraw = (Button) findViewById(R.id.WithdrawButton); // 탈퇴
        btn_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainSettingActivity.this, MainWithDrawActivity.class);
                intent1.putExtra("loginedMemberAge", verifiedmember.getAge());
                startActivity(intent1);

            }
        });



 // 웨이 인텐트에서 id받아옴


            ReadMembersData();
        Member member = null;
        for (Member me : Members) {
            if (me.getIdText().equals(id)) {
                member = me;
            }
        }


        Password.setText(member.getPasswordText());
        age.setText(String.valueOf(member.getAge()));
        Name.setText(member.getName());
        Member mem = member;

        Button btn_update = (Button) findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idtext = idText.getText().toString();

                int indexNum = Members.indexOf(mem);
                Member updateMember = new Member(indexNum, Integer.parseInt(age.getText().toString()),idtext, Password.getText().toString(), Name.getText().toString() );

                Members.set(indexNum, updateMember);
                sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("checkbox");
                editor.apply();


                Toast.makeText(v.getContext(), "정보수정", Toast.LENGTH_SHORT).show();
                Intent intentAdd = new Intent(MainSettingActivity.this, LoginActivity.class);
                intentAdd.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                MainSettingActivity.this.startActivity(intentAdd);


            }
        });

    }





        protected void ReadMembersData() {
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("MList", null);
        Type type = new TypeToken<LinkedList<Member>>() {
        }.getType();

        Members = gson.fromJson(json, type); // fromJson() 메소드 이용하여 Members 오브젝트로 읽어 들어 들이는
            if (Members == null) {
                Members = new LinkedList<>();
            }

    }



    @Override
    protected void onPause() {
        UpdataAndSaveData(Members);
        Toast.makeText(MainSettingActivity.this, "on pause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }



    private void UpdataAndSaveData(List<Member> member) {
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Members);
        editor.putString("MList", json);
        Toast.makeText(MainSettingActivity.this, "아이디 및 개인정보 저장", Toast.LENGTH_SHORT).show();

        editor.commit();
    }
}

