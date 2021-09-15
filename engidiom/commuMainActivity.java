package com.example.engidiom;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.engidiom.DB.IdiomCard;
import com.example.engidiom.DB.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class commuMainActivity extends AppCompatActivity {
    MyApplication myApplication = (MyApplication) this.getApplication();
    SpeechRecognizer speachRecognizer;
    TextView tv_Description, tv_voiceAnswer, tv_idiom ;
    Button btn_RecordButton, btn_quizCheck, btn_Cheating;
    List<IdiomCard> IdiomCardList;

    String idiom, Description;

    int questionNum = 0;

    final int PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commu_main);

        setTitle("발음연습 퀴즈(녹음해주세요)");

        IdiomCardList = MyApplication.getIdiomCardList();

        tv_Description = findViewById(R.id.tv_Description);
        tv_voiceAnswer = findViewById(R.id.tv_voiceAnswer);
        tv_idiom = findViewById(R.id.tv_idiom);

        btn_quizCheck = findViewById(R.id.btn_quizCheck);
        btn_RecordButton = findViewById(R.id.btn_RecordButton);
        btn_Cheating = findViewById(R.id.btn_Cheating);

        // 문제얻기
        Description = IdiomCardList.get(questionNum).getsDescription();
        tv_Description.setText(Description);

        //답안지
        idiom = IdiomCardList.get(questionNum).getArrr();
        tv_idiom.setVisibility(View.INVISIBLE);
        tv_idiom.setText(idiom);

        // 퍼미션 체크
        if ( Build.VERSION.SDK_INT >= 23 ){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO}, PERMISSION);
        }

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName()); // 키
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");

        btn_RecordButton.setOnClickListener(v -> {
            speachRecognizer = SpeechRecognizer.createSpeechRecognizer(this); // SpeechRecognizer생성
            speachRecognizer.setRecognitionListener(listener); // 리스너 설정시작
            speachRecognizer.startListening(intent); // 레코드 시작
        });


        Button backButtom = (Button) findViewById(R.id.btn_BackButton);
        backButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        });

    }


    private  RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(commuMainActivity.this, "음성인식 시작", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {

        }

        @Override
        public void onRmsChanged(float rmsdB) {

        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onError(int error) {
            // 네트워크 또는 인식 오류가 발생했을 때 호출
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 에러";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류";
                    break;
            }

            Toast.makeText(getApplicationContext(), "에러 발생 : " + message,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {

            ArrayList<String> match = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for (int i=0; i < match.size(); i++ ) {
                tv_voiceAnswer.setText(match.get(i)); // view에 값 산입
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        btn_quizCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = tv_voiceAnswer.getText().toString();
                String idioms = tv_idiom.getText().toString();
                if (idioms.equals(answer)) {
                    //onPause에 생명주기 이용 데이터값 (int mquestion = questionNum++;) 업데이트후 다음 문제 획득
                    onPause();
                    Toast.makeText(commuMainActivity.this, "정답! : "+idioms, Toast.LENGTH_SHORT).show();
                } else {
                    onStart();
                    Toast.makeText(commuMainActivity.this, "녹음버튼을 누루고 답을 해당 숙어를 말하시오", Toast.LENGTH_LONG).show();
                }

            }

        });

        btn_Cheating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_idiom.setVisibility(View.VISIBLE);
                Toast.makeText(commuMainActivity.this, "Show me", Toast.LENGTH_SHORT).show();
            }
        });
        tv_idiom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_idiom.setVisibility(View.INVISIBLE);
                Toast.makeText(commuMainActivity.this, "Hide it", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        int mquestion = questionNum++;
        if (mquestion == IdiomCardList.size()){ //size:7
            mquestion = 0;
            Toast.makeText(commuMainActivity.this, "전부 맞추었습니다!" , Toast.LENGTH_SHORT).show();
            Toast.makeText(commuMainActivity.this, "처음부터" , Toast.LENGTH_SHORT).show();
            quizStart(mquestion);
        }else {
            quizStart(mquestion);
        }
    }

    private void quizStart(int mquestion) {

        if (IdiomCardList.get(mquestion).getsDescription() != null) {
            // STT 텍스트 비우기
            tv_voiceAnswer.setText(" ");
            // 문제얻기
            Description = IdiomCardList.get(mquestion).getsDescription();
            tv_Description.setText(Description);

            //답안지
            idiom = IdiomCardList.get(mquestion).getArrr();
            tv_idiom.setText(idiom);

        }

    }

}
