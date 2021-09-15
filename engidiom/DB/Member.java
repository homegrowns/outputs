package com.example.engidiom.DB;

import android.widget.EditText;

public class Member {
    private int score;
    private int age;
    private String idText;
    private String PasswordText;
    private String name;


    public Member(int score , int age, String idText, String PasswordText, String name) {
        this.score = score;
        this.age = age;
        this.idText = idText;
        this.PasswordText = PasswordText;
        this.name = name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdText() {
        return idText;
    }

    public void setIdText(String idText) {
        this.idText = idText;
    }

    public String getPasswordText() {
        return PasswordText;
    }

    public void setPasswordText(String passwordText) {
        PasswordText = passwordText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "score=" + score +
                ", age=" + age +
                ", idText='" + idText + '\'' +
                ", PasswordText='" + PasswordText + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
