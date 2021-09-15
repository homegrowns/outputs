package com.example.engidiom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
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


public class LoginActivity extends AppCompatActivity {
    private Member member;
    TextView contactb;
    private EditText idText;
    private EditText PaswordText;

    String  idtext;
    CheckBox autologin;
    Boolean loginChecked = false;

    SharedPreferences sharedPreferences;
    static List<Member>Members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "로그인 onCreate", Toast.LENGTH_SHORT).show();


       ReadMembersData();

        idText = findViewById(R.id.idText);
        PaswordText = findViewById(R.id.PaswordText);
        autologin = findViewById(R.id.cb_autoLogin);



        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        loginChecked = sharedPreferences.getBoolean("checkbox", false);




            findViewById(R.id.LoginButtom).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idtext = idText.getText().toString().trim();
                    String passwordtext = PaswordText.getText().toString().trim();
                    boolean checked = autologin.isChecked();


                    if (idtext.length() == 0) {
                        Toast.makeText(LoginActivity.this, "아이디 입력", Toast.LENGTH_SHORT).show();
                        idText.requestFocus();
                        return;
                    }
                    if (passwordtext.length() == 0) {
                        Toast.makeText(LoginActivity.this, "비밀번호 입력", Toast.LENGTH_SHORT).show();
                        PaswordText.requestFocus();
                        return;
                    }

                    Member member = findmember(idtext);

                    if (member == null) {
                        Toast.makeText(LoginActivity.this, "찾을수 없는 아이디", Toast.LENGTH_SHORT).show();
                        idText.requestFocus();
                        return;
                    } else if (member.getPasswordText().equals(passwordtext) == false) {
                        Toast.makeText(LoginActivity.this, "비밀번호 불일치", Toast.LENGTH_SHORT).show();
                        PaswordText.requestFocus();
                        return;
                    }

                    if (autologin.isChecked()) {
                        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("ID", idtext);
                        editor.putString("password", passwordtext);
                        editor.putBoolean("checkbox", checked);

                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("loginedMemberAge", member.getAge());

                        startActivity(intent);

                    } else {
                        // 자동 로그인 체크가 해제되면 폰에 저장된 정보 모두 삭제

                        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("ID", idtext);
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("loginedMemberAge", member.getAge());

                        startActivity(intent);

                    }

                }
            });





        contactb = findViewById(R.id.contact);

        contactb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 010-3563-6442"));
                startActivity(i3);
            }
        });

        TextView registerButton = (TextView) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(register);

            }
        });



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ReadMembersData();
        Toast.makeText(this,"재시작", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {


        if (loginChecked) {


            sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
            String id = sharedPreferences.getString("ID", " ");
            idText.setText(id);
            String idregain = idText.getText().toString().trim();

            Member member = findmember(idregain);
            autologin.setChecked(true);


            Intent intent2 = new Intent(LoginActivity.this, HomeActivity.class);

            intent2.putExtra("loginedMemberAge", member.getAge());
            Toast.makeText(LoginActivity.this, "자동로그인", Toast.LENGTH_SHORT).show();
            startActivity(intent2);
            finish();
        }
        super.onStart();


    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this," onDestroy ", Toast.LENGTH_SHORT).show();
    }



   /* private void doLogin() {
        String idtext = idText.getText().toString().trim();
        String passwordtext = PaswordText.getText().toString().trim();

        if (idtext.length() == 0) {
            Toast.makeText(this, "아이디 입력", Toast.LENGTH_SHORT).show();
            idText.requestFocus();
            return;
        }
        if (passwordtext.length() == 0) {
            Toast.makeText(this, "비밀번호 입력", Toast.LENGTH_SHORT).show();
            PaswordText.requestFocus();
            return;
        }

            Member member = findmember(idtext);

            if (member == null) {
                Toast.makeText(this, "찾을수 없는 아이디", Toast.LENGTH_SHORT).show();
                idText.requestFocus();
                return;
            } else if (member.getPasswordText().equals(passwordtext) == false) {
                Toast.makeText(this, "비밀번호 불일치", Toast.LENGTH_SHORT).show();
                PaswordText.requestFocus();
                return;
            }

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        loginChecked = sharedPreferences.getBoolean("LoginChecked", false);


        if (loginChecked) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("loginedMemberAge", member.getAge());
            Toast.makeText(this, "자동로그인", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();

        }else {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("loginedMemberAge", member.getAge()); // id값을 AppDataFake.findmember(idtext);를 걸쳐 얻어온다
            LoginActivity.this.startActivity(intent);
        }



        }*/

    public static Member findmember2(int age) {
        for (Member member : Members) {
            if (member.getAge() == age) {
                return member;
            }
        }
        return null;
    }

    public static Member findmember3(int score) {
        for (Member member : Members) {
            if (member.getScore() == score) {
                return member;
            }
        }
        return null;
    }


    public static Member findmember(String idtext) {
        for (Member m : Members) {
            if (m.getIdText().equals(idtext)) {
                return m;
            }
        }
        return null;

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