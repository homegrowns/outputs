package com.example.engidiom.DB;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.engidiom.DB.MyApplication;
import com.example.engidiom.DB.IdiomCard;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.engidiom.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Question extends AppCompatActivity {
    private int CardsNumber;
    private int CardsAnswerNumber;
    private String answer;

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<IdiomCard> IdiomCardList;

    private String[] answerArray;

    private int answerPosition;
    Random randomLimit = new Random();
    private  int upperLimit;

    private String questionPhrase;

    // 램덤문제 발동



    public Question( int upperLimit){

            this.upperLimit = upperLimit;
            Random randomNumberMaker = new Random();

            IdiomCardList = MyApplication.getIdiomCardList();
            this.CardsNumber = upperLimit;
            this.answer = IdiomCardList.get(CardsNumber).getArrr(); // 정답 카드넘버
            this.questionPhrase = IdiomCardList.get(CardsNumber).getsDescription();  //문제 내기
            this.answerPosition = randomNumberMaker.nextInt(4);
            this.answerArray = new String[]{" ", " ", " ", " "};

              int a[] = new int[4];
            for (int i = 0; i < 4; i++)
            {
                a[i] = randomNumberMaker.nextInt(6);
                for (int j = 0; j < i ; j++)
                {
                 if(a[i]==a[j] )
                 {
                  i--;
                 }
                }
            }
            for (int d = 0; d < 4; d++) {
                int card_num = a[d];
                this.answerArray[d] = IdiomCardList.get(card_num).getArrr();
                if(CardsNumber == a[d]) {
                    this.answerArray[d] = answer;
                }
            }


                if (!this.answerArray[0].equals(answer) && !this.answerArray[1].equals(answer) && !this.answerArray[2].equals(answer) && !this.answerArray[3].equals(answer)) {
                    this.answerArray[answerPosition] = answer;

                } // 정답 포함안되있을때
    }


    public String getAnswer() {
        return answer;
    }
    public String[] getAnswerArray() {
        return answerArray;
    }
    public String getQuestionPhrase() {
        return questionPhrase;
    }



}

