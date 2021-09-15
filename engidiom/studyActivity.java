package com.example.engidiom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;

public class studyActivity extends AppCompatActivity implements TextToSpeech.OnInitListener { // 커스텀후 네이버 사전uri 삽입


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);


        String[] tarr = new String[9];
        tarr[0] = "Barking up the wrong tree";
        tarr[1] = "Around the corner";
        tarr[2] = "Water under the bridge";
        tarr[3] = "It never rains but it pours";
        tarr[4] = "Catch a break";
        tarr[5] = "wipe the floor with";
        tarr[6] = "This round's on me";
        tarr[7] = "Sleep in";
        tarr[8] = "come up roses";

        String[] Description = {"헛다리집다","~가 목전이다","이미 지나간일이야", "엎친데 덮친다더니", "운이 따르다", "~에게 압승하다", "이번 잔은 제가 살게요", "쿨쿨 퍼자다"
        ,"썩 잘 돼가다"};

        String[] urls = {"https://en.dict.naver.com/#/entry/enko/3cf87873bd314760a32e4d35c2672a75",
                "https://en.dict.naver.com/#/entry/enko/4975dc2010484e76be2321315680f4c2",
                "https://en.dict.naver.com/#/entry/enko/9b602b59e7654a4c8fa60e4f99e21cb9",
                "https://en.dict.naver.com/#/entry/enko/472de58b691947f5b586f478761bf7ac",
                "https://open-pro.dict.naver.com/?mode=pc/#!/dictmain/readmode?dictEnName=cyiqcnhwcxgmbgcteucqmudsqyofimmruaqw&entryId=4e9c263476f343e8b051b06fcbc53074",
        "https://open-pro.dict.naver.com/?mode=pc/#!/dictmain/readmode?dictEnName=cyiqcnhwcxgmbgcteucqmudsqyofimmruaqw&entryId=4f3c0484691644ab97d759aee5f72490&itemIndex=2",
                "https://en.dict.naver.com/#/entry/koen/7398f8730e834db78aa821dbb6343024",
                "https://en.dict.naver.com/#/entry/enko/ec10555aec084637a5720f0a3c7b136c",
                "https://en.dict.naver.com/#/entry/enko/6d468586cb9e4115b08c5e8a69f2f6b3"
        };

        int image[] = {R.drawable.idiom1,R.drawable.corner, R.drawable.londonbridge, R.drawable.itneverrainsbut,  R.drawable.catcha_break,
                R.drawable.wipe_with_floor, R.drawable.thisroundonme, R.drawable.sleepin,R.drawable.comeup};



        ListView listView1 = findViewById(R.id.listView1);

        studyimageItem adapter = new studyimageItem(this, tarr, Description, image, urls); // adapter 변환기

        listView1.setAdapter(adapter);

//////////////////////////////////// image layout details

        Button backButtom = (Button) findViewById(R.id.backButton);
        backButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

       listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override // item이 클릭 되면 밑에 문장이 실행된다.
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String title = tarr[position];
               String subtitle = Description[position];
               int images = image[position];
               String url = urls[position];
               Intent intent = new Intent(studyActivity.this, StudyDetailActivity.class);
               intent.putExtra("title", title);
               intent.putExtra("subtitle", subtitle);
               intent.putExtra("image", images);
               intent.putExtra("urls", url);
               startActivity(intent);


               
           }
       });

    }

    @Override
    public void onInit(int status) {

    }


    class studyimageItem extends ArrayAdapter<String> {
        Context context;
        String arrr[];
        String rDescription[];
        int rimage[];
        String urls[];

        studyimageItem(Context con, String[] sarr, String[] sDescription, int imgs[], String urls[] ) {
            super(con, R.layout.image_layout, R.id.textViewItem1, sarr);
            this.context = con;
            this.arrr = sarr;
            this.rDescription = sDescription;
            this.rimage = imgs;
            this.urls = urls;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.image_layout, parent, false); //메모리에 ㅅ실제적으로 올려두기

            ImageView images = view.findViewById(R.id.imageViewItem);
            TextView arrt = view.findViewById(R.id.textViewItem1);
            TextView myDescription = view.findViewById(R.id.textViewItem2);

            images.setImageResource(rimage[position]);
            arrt.setText(arrr[position]);
            myDescription.setText(rDescription[position]);

            return view;

        }


    }


}

