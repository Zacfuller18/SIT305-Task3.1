package com.zfuller.task31_zacharyfuller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textScore, textCongrats;
    Button btnNewQuiz, btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textScore = (TextView) findViewById(R.id.textScore);
        textCongrats = (TextView) findViewById(R.id.textCongrats);
        btnNewQuiz = (Button) findViewById(R.id.btnNewQuiz);
        btnFinish = (Button) findViewById(R.id.btnFinish);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String score = i.getStringExtra("score");
        textCongrats.setText("Congratulations " + name + "!");
        textScore.setText(score + "/5");

        btnNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reset = new Intent(ResultActivity.this, MainActivity.class);
                reset.putExtra("name", name);
                startActivity(reset);
                finish();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}