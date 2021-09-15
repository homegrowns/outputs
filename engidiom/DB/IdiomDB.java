package com.example.engidiom.DB;



import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdiomDB extends Application {
    static List<IdiomCard> IdiomList = new ArrayList<IdiomCard>();
    SharedPreferences sp;


    private static  IdiomCard idiomCard;

          static {
              /*IdiomList = new ArrayList()*/;



        //IdiomCard idiomCard =null;

       /*IdiomCard idiomCard = new IdiomCard("","","",0);
        IdiomList.add(idiomCard);*/




    }

    public static List<IdiomCard> getIdiomList() {
        return IdiomList;
    }



    /*public static IdiomCard findCard(String tittle) {
        for (IdiomCard idiomCard : IdiomList) {
            if (idiomCard.getArrr().equals(tittle)) {

                return idiomCard;
            }
        }
        return null;
    }
*/



       /*private void SaveDB() {
        sp = getSharedPreferences("StudySharedCard", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(IdiomList);
        editor.putString("List", json);
        editor.apply();
    }*/
}

