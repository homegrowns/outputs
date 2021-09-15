package com.example.engidiom.DB;

import android.app.Application;

import com.example.engidiom.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyApplication extends Application {  //1. 안드로이드에서 Application Class란 어플리케이션 컴포넌트들 사이에서 공동으로 멤버들을 사용할 수 있게 해주는 편리한 공유 클래스를 제공합니다.
    //2. 공통으로 전역 변수를 사용하고 싶을 때 Application 클래스를 상속받아 사용할 수 있다.

    public static List<IdiomCard> IdiomCardList = new ArrayList<IdiomCard>();



    public MyApplication() {
        fillidiomList();
    }

    private void fillidiomList() {
        IdiomCard Card0 = new IdiomCard("barking up the wrong tree", "헛다리집다","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card1 = new IdiomCard("around the corner", "~가 목전이다","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card2 = new IdiomCard("water under the bridge", "이미 지나간일이야","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card3 = new IdiomCard("it never rains but it pours", "엎친데 덮친다더니","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card4 = new IdiomCard("catch a break", "운이 따르다","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card5 = new IdiomCard("wipe the floor with", "~에게 압승하다","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card6 = new IdiomCard("this round is on me", "이번 잔은 제가 살게요","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card7 = new IdiomCard("sleep in", "늦잠 퍼자다","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCard Card8 = new IdiomCard("come up roses", "썩 잘 돼가다","https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75", R.drawable.idiom1 );
        IdiomCardList.addAll(Arrays.asList ( new IdiomCard[] {Card0,Card1,Card2,Card3,Card4,Card5,Card6,Card7,Card8}));
    }

    public static List<IdiomCard> getIdiomCardList() {
        return IdiomCardList;
    }




}

