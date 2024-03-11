package com.example.cc10624triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button tButton, fButton, nButton, pButton;
    private TextView tQuestion, tScore;
    private int currentIdx = 0, score =0;

    boolean[] doneAnswered = new boolean[10];
    private TrueFalse[] questionBank = new TrueFalse[]
            {
                    new TrueFalse(R.string.q1, true),
                    new TrueFalse(R.string.q2, true),
                    new TrueFalse(R.string.q3, true),
                    new TrueFalse(R.string.q4, false),
                    new TrueFalse(R.string.q5, true),
                    new TrueFalse(R.string.q6, false),
                    new TrueFalse(R.string.q7, true),
                    new TrueFalse(R.string.q8, false),
                    new TrueFalse(R.string.q9, true),
                    new TrueFalse(R.string.q10, false),
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < doneAnswered.length; i++) {
            doneAnswered[i] = false;
        }

        tButton = (Button) findViewById(R.id.btnTrue);
        fButton = (Button) findViewById(R.id.btnFalse);
        nButton = (Button) findViewById(R.id.btnNext);
        pButton = (Button) findViewById(R.id.txtPrevious);
        tQuestion = (TextView) findViewById(R.id.txtQuestion);
        tScore = (TextView) findViewById(R.id.txtScore);

        int idxQuestion = questionBank[currentIdx].getIdxQuestion();
        tQuestion.setText(idxQuestion);

        //next button
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add +1 itterate to next question
                if (currentIdx == 9){
                    return;
                }
                currentIdx += 1;
                int idxQuestion = questionBank[currentIdx].getIdxQuestion();
                tQuestion.setText(idxQuestion);

            }
        });

        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to go back to previous question
                if (currentIdx == 0){
                    return;
                }
                currentIdx -= 1;

                int idxQuestion = questionBank[currentIdx].getIdxQuestion();
                tQuestion.setText(idxQuestion);
            }
        });

        //true button
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean keyAnswer = questionBank[currentIdx].isKeyAnswer();
                if(doneAnswered[currentIdx] == true ) {
                    return;
                }
                else if (keyAnswer == true) {
                    score++;
                    Toast.makeText(MainActivity.this, R.string.msgcorrect, Toast.LENGTH_SHORT).show();
                    tScore.setText("Score: "+ score);
                }
                else
                {
                    Toast.makeText(MainActivity.this, R.string.msgincorrect, Toast.LENGTH_SHORT).show();
                }
                doneAnswered[currentIdx] = true;
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean keyAnswer = questionBank[currentIdx].isKeyAnswer();
                if(doneAnswered[currentIdx] == true ) {
                    return;
                }
                else if (keyAnswer == false) {
                    score++;
                    Toast.makeText(MainActivity.this, R.string.msgcorrect, Toast.LENGTH_SHORT).show();
                    tScore.setText("Score: " + score);
                } else {
                    Toast.makeText(MainActivity.this, R.string.msgincorrect, Toast.LENGTH_SHORT).show();
                }
                doneAnswered[currentIdx] = true;
            }
        });


    }
}