package com.example.engidiom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engidiom.DB.Member;
import com.example.engidiom.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainWithDrawActivity extends AppCompatActivity {

    private TextView idText;

    private TextView Name;


    List<Member>Members ;
    SharedPreferences sharedPreferences;
    String idtext,passwordtext, name;
    Member member;
    int IdNum, age ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_draw);

        idText = findViewById(R.id.et_Id);

        Name = findViewById(R.id.et_nametextwith);


        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editors = sharedPreferences.edit();

        String id = sharedPreferences.getString("ID", " ");
        /*idText.setText(id);*/





        int logind_MemId = getIntent().getIntExtra("loginedMemberAge", 0);
        Member verifiedmember = LoginActivity.findmember2(logind_MemId);
        TextView et_VeryfiedName = findViewById(R.id.et_nametextwith);
        et_VeryfiedName.setText(verifiedmember.getName());

    ReadMembersData();
        Member member = null;
        for (Member me : Members) {
            if (me.getIdText().equals(id)) {
                member = me;
            }
        }
        IdNum = member.getScore();
        idText.setText(member.getIdText());

        age = member.getAge();
        Name.setText(member.getName());

        Member mem = member;

        Button btn_withdraw = (Button) findViewById(R.id.btn_Withdraw);
        btn_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 idtext = idText.getText().toString().trim();
                 passwordtext = mem.getPasswordText().trim();
                 name = Name.getText().toString().trim();
                int indexNum = Members.indexOf(mem);
                Member members = new Member(IdNum, age ,idtext,passwordtext, name);
                Members.remove(indexNum);
                withDraw(members);
                finish();

                Toast.makeText(MainWithDrawActivity.this, "탈퇴", Toast.LENGTH_SHORT).show();

               /* editors.clear();

                editors.apply();*/


                Intent intent = new Intent(MainWithDrawActivity.this, LoginActivity.class); // Login clear top은 탈퇴가 되지않았다
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);

            }
        });
    }



    private void withDraw(Member members) {

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        //JSON 변환 (Serialization) {"1":"id","2":"PassWord","3":"name"}

        String jsonList = gson.toJson(Members);

        editor.putString("MList", jsonList);
        Toast.makeText(MainWithDrawActivity.this, "탈퇴", Toast.LENGTH_SHORT).show();

        editor.commit();
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
}

