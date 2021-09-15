package com.example.engidiom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engidiom.DB.IdiomCard;
import com.example.engidiom.DB.Member;
import com.example.engidiom.DB.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main_quizActivity extends AppCompatActivity {
    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3, btn_back;
    TextView tv_score, tv_question, tv_timer, tv_bottomM, tv_thread;
    ProgressBar prog_timer;
    SharedPreferences sharedPreferences;

    List<Member> Members;
    Handler handling = new Handler();
    int s ; // 초




    Game g = new Game();
    int secondRemaining = 30;

    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
           /* secondRemaining--;
            tv_timer.setText(Integer.toString(secondRemaining) + " sec");
            prog_timer.setProgress(30 - secondRemaining);*/
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer0.setEnabled(false);
            btn_answer0.setEnabled(false);
            btn_answer0.setEnabled(false);
            tv_bottomM.setText("Time is up" + g.getNumberCorrect() + "/" + (g.getTotalQuestion() - 1));

            Handler handler = new Handler();

         /*   handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            }, 1000);*/

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);

        tv_thread = findViewById(R.id.tv_thread);


        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_back = findViewById(R.id.btn_backback);

        tv_score = findViewById(R.id.tv_score);
        tv_bottomM = findViewById(R.id.tv_bottomM);
        tv_question = findViewById(R.id.tv_question);
        tv_timer = findViewById(R.id.tv_timer);
        prog_timer = findViewById(R.id.progressTimer);

        tv_timer.setText("0Sec");
        tv_question.setText("");
        tv_bottomM.setText("press");
        tv_score.setText("oPts");
        prog_timer.setProgress(0);


        View.OnClickListener startButtonClickListener = (v) -> {
            Button start_button = (Button) v;
            start_button.setVisibility(View.INVISIBLE);
            secondRemaining = 30;
            Game g = new Game();
            nextTurn();
            new Thread(new Runnable() { // 쓰레드 타이머
                @Override
                public void run() {

                    for ( s = 30; s >=0; s--){                               //원하는 타이머를 설정 현재 30초.
                        handling.post(new Runnable() {
                            @Override
                            public void run() {
                                secondRemaining--;
                                prog_timer.setProgress(30 - secondRemaining);
                                tv_thread.setText("time: "+ s);
                            }
                        });

                        try {
                            Thread.sleep(1000);                          //1초에 한번씩  반복문이 멈춤
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_start.setVisibility(View.VISIBLE);
                    }
                }, 30300);

                timer.start();
        };
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {  // 각각 answer들과 공유한다

            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;
                String answerSelected = buttonClicked.getText().toString();
                Toast.makeText(Main_quizActivity.this, "AnswerSelected=" + answerSelected, Toast.LENGTH_SHORT).show();

                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

                String id = sharedPreferences.getString("ID", " ");

                ReadMembersData();
                Member member = null;

                for (Member me : Members) {
                    if (me.getIdText().equals(id)) {
                        member = me;
                    }
                }

                String Password = member.getPasswordText();
                int age = member.getAge();
                String Name = member.getName();
                String idtext = member.getIdText();
                Member mem = member;

                int score = g.getScore(); // 점수 보내기

                int indexNum = Members.indexOf(mem);
                Member updateMember = new Member(score, age, idtext, Password, Name);
                Members.set(indexNum, updateMember);
                Intent intent = new Intent(Main_quizActivity.this, noteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("score", score);
                Main_quizActivity.this.startActivity(intent);
                finish();


            }
        });

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

    @Override
    protected void onPause() {
        UpdataAndSaveData(Members);
        Toast.makeText(Main_quizActivity.this, "on pause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }


    private void UpdataAndSaveData(List<Member> member) {
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Members);
        editor.putString("MList", json);
        Toast.makeText(Main_quizActivity.this, "아이디 및 개인정보 저장", Toast.LENGTH_SHORT).show();

        editor.commit();
    }

    @SuppressLint("SetTextI18n")
    private void nextTurn() {

        g.makeNewQuestion();
        String[] answer = g.getCurrentQuestion().getAnswerArray();

        btn_answer0.setText(answer[0]);
        btn_answer1.setText(answer[1]);
        btn_answer2.setText(answer[2]);
        btn_answer3.setText(answer[3]);

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_question.setText(g.getCurrentQuestion().getQuestionPhrase());

        tv_bottomM.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestion() - 1));
    }

    public class Game {

        private List<Question> questions;

        private int numberCorrect;
        private int numberIcorrect;
        private int totalQuestion;
        private int score;
        private Question currentQuestion;

        Random rand = new Random();

        public Game() {
            numberCorrect = 0;
            numberIcorrect = 0;
            totalQuestion = 0;
            score = 0;


            int upperLimit = rand.nextInt(9);

            currentQuestion = new Question(upperLimit);
            questions = new ArrayList<Question>();
        }

        public void makeNewQuestion() {
            int upperLimit = rand.nextInt(9);
            currentQuestion = new Question(upperLimit); //
            totalQuestion++;
            questions.add(currentQuestion);
        }

        public void checkAnswer(String submittedAnswer) {
            boolean isCorrect;
            if (currentQuestion.getAnswer().equals(submittedAnswer)) {
                numberCorrect++;
            } else {
                numberIcorrect++;

            }
            score = numberCorrect * 10 - numberIcorrect * 10;
        }


        public int getNumberCorrect() {
            return numberCorrect;
        }

        public void setNumberCorrect(int numberCorrect) {
            this.numberCorrect = numberCorrect;
        }

        public int getTotalQuestion() {
            return totalQuestion;
        }

        public void setTotalQuestion(int totalQuestion) {
            this.totalQuestion = totalQuestion;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Question getCurrentQuestion() {
            return currentQuestion;
        }

        public void setCurrentQuestion(Question currentQuestion) {
            this.currentQuestion = currentQuestion;
        }
    }


}