package com.example.engidiom.DB;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.engidiom.RegisterActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AppDataFake extends AppCompatActivity {

    private static Member member;
    private static ArrayList<Member> Members;
    String text = "";







 /*   public static Member findmember(String idtext) {

        for ( Member member : Members) {
            if (member.getIdText().equals(idtext)) {
                return member;
            }
        }
        return null;
    }*/

   /* public static Member findmember2(int id) {
        for (Member member : Members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }*/




    /*public static void withdraw(String idText, String PaswordText, String name) {
        int id = Members.get(Members.size() - 1).getId() - 1;
        Member member = new Member(id, idText, PaswordText, name);
        Members.remove(member);
    }*/


}
