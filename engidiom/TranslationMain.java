package com.example.engidiom;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static android.content.Intent.ACTION_GET_CONTENT;


public class TranslationMain extends AppCompatActivity {
    final private static String TAG = "권한";
    Button btn_photo, btn_ckeckbutton, btn_translation, btn_imageGallery;
    ImageView iv_photo;
    TextView tv_transText , tv_detectedText;

    final static int REQUEST_CAMERA_CODE= 1; //startActivityForResult 인텐트 값전달 (카메라)
    final static int REQUEST_CODE = 0; // startActivityForResult 인텐트 값전달 (갤러리접근)

    TextRecognizer recognizer;
    Bitmap bitmap;
    String getresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trans);

        setTitle("사진 번역");


        tv_transText = findViewById(R.id.tv_transText);

        tv_detectedText = findViewById(R.id.tv_detectedText);

        iv_photo = findViewById(R.id.photo);

        btn_ckeckbutton = findViewById(R.id.btn_ckeckbutton);

        btn_photo = findViewById(R.id.btn_photobutton);

        btn_translation =findViewById(R.id.btn_translation);

        btn_imageGallery = findViewById(R.id.btn_imageGallery);

        // 퍼미션 확인
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "권한 설정 완료");
            } else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(TranslationMain.this, new String[]
                        {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }

        btn_photo.setOnClickListener(new View.OnClickListener() { // 사진캡쳐
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_photobutton:
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, REQUEST_CAMERA_CODE);

                        break;
                }
            }
        });


        btn_imageGallery.setOnClickListener(new View.OnClickListener() { // 이미지 불러오기
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(ACTION_GET_CONTENT); //ACTION_GET_CONTENT라는 암시적 인텐트는 onActivityResult에 Intent 파라미터값에서 이미지 경로(path)만 넘긴다
                startActivityForResult(intent, REQUEST_CODE); // 0 onActivityResult 메소드에서 int값이용  if(requestCode == REQUEST_CODE)

            }
        });

        btn_ckeckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detect();
            } // 텍스트 감지
        });


        btn_translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Translate translate = new Translate();
                translate.execute();

            }
        });

        Button backButtom = (Button) findViewById(R.id.backButton);
        backButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if ( requestCode == REQUEST_CAMERA_CODE && resultCode == RESULT_OK )  {

            bitmap = (Bitmap) intent.getExtras().get("data");

                    iv_photo.setImageBitmap(bitmap);
                    btn_imageGallery.setVisibility(View.INVISIBLE);
                    btn_photo.setVisibility(View.INVISIBLE);

        } else if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                try{
                    InputStream in = getContentResolver().openInputStream(intent.getData());

                    bitmap = BitmapFactory.decodeStream(in);
                    in.close();

                    iv_photo.setImageBitmap(bitmap);
                }catch(Exception e)
                {

                }
                btn_imageGallery.setVisibility(View.INVISIBLE);
                btn_photo.setVisibility(View.INVISIBLE);
            }

        }else if(resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            btn_imageGallery.setVisibility(View.VISIBLE);
            btn_photo.setVisibility(View.VISIBLE);
        }


    }


    private void detect (){
                               //  이 vision API를 모바일 앱에서 사용하는 경우 Firebase 머신러닝 및 ML Kit를 사용해 보세요.
                InputImage image = InputImage.fromBitmap(bitmap, 0); // 캡처하거나 가져온 image

                recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS); // recognizer 생성


                Task<Text> result = recognizer.process(image).addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(@NonNull  Text text) {
                           // 인지된 텍스트 블록에서 추출하기
                        StringBuilder result = new StringBuilder();
                        for (Text.TextBlock block : text.getTextBlocks()) {  // 직사각형 블록록
                           String blockText = block.getText();
                            Point[] blockCornerPoints = block.getCornerPoints();
                            Rect blockFrame = block.getBoundingBox();
                            for (Text.Line line : block.getLines()) {
                                String lineText = line.getText();
                                Point[] lineCornerPoints = line.getCornerPoints();
                                Rect lineFrame = line.getBoundingBox();
                                for (Text.Element element : line.getElements()) {
                                    String elementText = element.getText();
                                    result.append(Arrays.toString(elementText.split(" ")));
                                }
                                tv_detectedText.setText(blockText); // 텍뷰에 값 언지기

                            }
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(getApplicationContext(), "에러", Toast.LENGTH_SHORT).show();
                    }
                });
            }

    class Translate extends AsyncTask<String ,Void, String > {   // <파라미터 타입, 작업 시 진행 단위의 타입, doInBackground 리턴값>
                                                                 //ASYNCTASK를 사용
                                                                 //스레드나 메시지 루프 등의 원리를 이해하지 않아도 하나의 클래스에서 UI 작업을 쉽게 할 수 있게 해준다.

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override

        //doInBackground( ) 에서 중간 중간 진행 상태를 UI에 업데이트 하도록 하려면 publishProgress( ) 메소드를 호출
        //핵심은 onPreExecute( ), onProgressUpadate( ), onPostExecute( ) 메소드는 메인 스레드에서 실행되므로 UI 객체에 자유롭게 접근할 수 있다다
        protected String doInBackground(String... strings) {

            //파파고 API

            String clientId = "GWP_naows5QRfH0_VIPF";//애플리케이션  아이디값";
            String clientSecret = "dCYUhZ_4iG";//애플리케이션 시크릿값";

            try {
                String text = URLEncoder.encode(tv_detectedText.getText().toString(), "UTF-8");  /// 번역할문장 텍뷰에서 받아옴, encoding후 서버에 전달방식

                String apiURL = "https://openapi.naver.com/v1/papago/n2mt"; //engineType":"N2MT"
                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection(); // 인터넷통신
                con.setRequestMethod("POST");
                con.setRequestProperty("X-Naver-Client-Id", clientId); // 	요청 헤더를 정의한다.  setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                // 포스트요청
                String postParams = "source=en&target=ko&text=" + text; // 소스언어 영어  , 타겟언어 한글 ,Text; THE+STOLEN+THRONE
                con.setDoOutput(true); //	OutputStream으로 POST 데이터를 넘겨주겠다는 옵션을 정의한다.
                DataOutputStream wr = new DataOutputStream(con.getOutputStream()); // 데이터변환하고 읽고 쓴다
                wr.writeBytes(postParams);
                wr.flush();
                wr.close();
                int responseCode = con.getResponseCode(); //  getResponseCode(); 웹서버에 요청과정 수행
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 결과값 읽어 오는부분
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                //        textView.setText(response.toString());
                getresult = response.toString();

                getresult = getresult.split("\"")[27];   //스플릿으로 정리된 결과값만 가져오기
                tv_transText.setText(getresult); //  텍스트뷰에  SET해주기


            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }
    }
            
}




