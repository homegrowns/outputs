package com.example.engidiom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.engidiom.DB.Member;
import com.example.engidiom.DB.YoutubeContent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static com.example.engidiom.LoginActivity.findmember;

public class RegisterActivity extends AppCompatActivity {
    private EditText idText;
    private EditText Password;
    private EditText PasswordConfirm;
    private EditText Name;
    private EditText ageText;
    private CheckBox SurveyText;
    private Member member;
    SharedPreferences sharedPreferences;

    List<Member>Members;



    private Spinner spinner;
     String passwordtext, idtext ,name, person, personPas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         ReadMembersData();


        idText = findViewById(R.id.idText);
        Password = findViewById(R.id.Password);
        PasswordConfirm = findViewById(R.id.PasswordConfirm);
        Name = findViewById(R.id.nametext);
        ageText = findViewById(R.id.ageText);
        SurveyText = findViewById(R.id.SurveyText);

        Button button = (Button) findViewById(R.id.btn_join);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idtext = idText.getText().toString().trim();  // 제이슨 어레이리스트에 추가
                passwordtext = Password.getText().toString().trim();
                String passwordconfirm = PasswordConfirm.getText().toString().trim();
                name = Name.getText().toString().trim();


                if (idtext.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "아이디 입력", Toast.LENGTH_SHORT).show();
                    idText.requestFocus();
                    return;
                }
                if (passwordtext.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "비밀번호 입력", Toast.LENGTH_SHORT).show();
                    Password.requestFocus();
                    return;
                }
                if (passwordtext.equals(passwordconfirm) == false) {
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치 하지 않습니다.", Toast.LENGTH_SHORT).show();
                    Password.requestFocus();
                    return;
                }

                if (name.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "이름입력", Toast.LENGTH_SHORT).show();
                    Name.requestFocus();
                    return;
                }

                String myage = ageText.getText().toString();



                if (myage.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "나이입력", Toast.LENGTH_SHORT).show();
                    Name.requestFocus();
                    return;
                }
                Member member = findmember(idtext);

                if (member != null) {

                    if (member.getIdText().equals(idtext)) {
                        Toast.makeText(RegisterActivity.this, "이미사용중인 아이디", Toast.LENGTH_SHORT).show();
                        idText.requestFocus();
                        return;
                    }
                }


                if (SurveyText.isChecked()) {


                    int upId = Members.size();


                      Member memId = findIndex(upId);
                      if (Members.size() == 0) {
                          Member members = new Member(0, Integer.parseInt(ageText.getText().toString()), idtext, passwordtext, name);
                          JoinAndSaveData(members);
                          finish();
                      }

                    else if (memId == null) {


                            Member members = new Member(upId, Integer.parseInt(ageText.getText().toString()), idtext, passwordtext, name);
                            JoinAndSaveData(members);
                            finish();


                    } else if(memId.getScore() == upId) { // 같은 인덱스 id 를 걸러넬 메소드만든다

                        Member members = new Member(upId, Integer.parseInt(ageText.getText().toString()), idtext, passwordtext, name);
                        JoinAndSaveData(members);

                        finish();
                    }

                } else {
                    Toast.makeText(RegisterActivity.this, "약관엔 동의하십시오.", Toast.LENGTH_SHORT).show();
                    SurveyText.requestFocus();
                    return;


                }
            }


        });

    }


    public Member findIndex(int upId) {
        for (Member mId : Members) {
            if (mId.getScore() == (upId)) {
                return mId;
            }
        }
        return null;
    }
    private void JoinAndSaveData(Member members) {
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        Members.add(members);
        String jsonList = gson.toJson(Members);


        editor.putString("MList", jsonList);


        Toast.makeText(RegisterActivity.this, "아이디 및 개인정보 저장", Toast.LENGTH_SHORT).show();

        editor.commit();
    }



    protected void ReadMembersData() {
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("MList", null);
        Type type = new TypeToken<LinkedList<Member>>() {
        }.getType();

        Members = gson.fromJson(json, type); // fromJson() 메소드 이용하여 Members 오브젝트로 읽어 들어 들이는 // List 사용시 type 으로 형변환
        if (Members == null) {
            Members = new LinkedList<>();
        }

        }

    }







