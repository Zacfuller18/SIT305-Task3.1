package com.zfuller.task31_zacharyfuller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    TextView welcomeText, progressText, titleText, detailText;
    ProgressBar progressBar;
    Button answer1Button, answer2Button, answer3Button, submitButton;

    int currentQuestionNumber = 1;
    int correctAnswers = 0;
    int answerSelected = 0;
    int hasSubmitted = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        welcomeText = (TextView) findViewById(R.id.welcomeText);
        progressText = (TextView) findViewById(R.id.progressText);
        titleText = (TextView) findViewById(R.id.titleText);
        detailText = (TextView) findViewById(R.id.detailText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        answer1Button = (Button) findViewById(R.id.answer1Button);
        answer2Button = (Button) findViewById(R.id.answer2Button);
        answer3Button = (Button) findViewById(R.id.answer3Button);
        submitButton = (Button) findViewById(R.id.submitButton);

        Intent i = getIntent();
        String input = i.getStringExtra("name");
        welcomeText.setText("Welcome " + input + "!");

        progressBar.setProgress(20);
        titleText.setText("Question 1");
        detailText.setText("What does API stand for?");
        answer1Button.setText("Application Profiler Inspection");
        answer2Button.setText("Application Programming Interface");
        answer3Button.setText("Application Print Interface");

        Intent result = new Intent(QuizActivity.this, ResultActivity.class);

        //Couldn't figure out how to change colours correctly, just turning other buttons invisible for now instead
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasSubmitted == 0) {
                    answerSelected = 1;
                    answer2Button.setVisibility(View.INVISIBLE);
                    answer3Button.setVisibility(View.INVISIBLE);
                }
            }
        });

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasSubmitted == 0) {
                    answerSelected = 2;
                    answer1Button.setVisibility(View.INVISIBLE);
                    answer3Button.setVisibility(View.INVISIBLE);
                }
            }
        });

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasSubmitted == 0) {
                    answerSelected = 3;
                    answer1Button.setVisibility(View.INVISIBLE);
                    answer2Button.setVisibility(View.INVISIBLE);
                }
            }
        });
        //
        //
        //
        // Not the cleanest way, but the only way I could get working
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasSubmitted == 0) {
                    if (answerSelected == 0) {
                        Toast.makeText(QuizActivity.this, "Please select an answer first!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (currentQuestionNumber == 1) {
                            if (answerSelected == 1) {
                                checkSelectedAnswer(1, 2);
                            } else if (answerSelected == 2) {
                                checkSelectedAnswer(2, 2);
                            } else if (answerSelected == 3) {
                                checkSelectedAnswer(3, 2);
                            }
                        } else if (currentQuestionNumber == 2) {
                            if (answerSelected == 1) {
                                checkSelectedAnswer(1, 2);
                            } else if (answerSelected == 2) {
                                checkSelectedAnswer(2, 2);
                            } else if (answerSelected == 3) {
                                checkSelectedAnswer(3, 2);
                            }
                        } else if (currentQuestionNumber == 3) {
                            if (answerSelected == 1) {
                                checkSelectedAnswer(1, 1);
                            } else if (answerSelected == 2) {
                                checkSelectedAnswer(2, 1);
                            } else if (answerSelected == 3) {
                                checkSelectedAnswer(3, 1);
                            }
                        } else if (currentQuestionNumber == 4) {
                            if (answerSelected == 1) {
                                checkSelectedAnswer(1, 3);
                            } else if (answerSelected == 2) {
                                checkSelectedAnswer(2, 3);
                            } else if (answerSelected == 3) {
                                checkSelectedAnswer(3, 3);
                            }
                        } else if (currentQuestionNumber == 5) {
                            if (answerSelected == 1) {
                                checkSelectedAnswer(1, 1);
                            } else if (answerSelected == 2) {
                                checkSelectedAnswer(2, 1);
                            } else if (answerSelected == 3) {
                                checkSelectedAnswer(3, 1);
                            }
                        }
                    }
                } else if (hasSubmitted == 1) {
                    hasSubmitted = 0;
                    answerSelected = 0;
                    submitButton.setText("Submit");
                    answer1Button.setBackgroundColor(Color.WHITE);
                    answer2Button.setBackgroundColor(Color.WHITE);
                    answer3Button.setBackgroundColor(Color.WHITE);
                    if (currentQuestionNumber == 1) {
                        currentQuestionNumber += 1;
                        progressText.setText("2/5");
                        progressBar.setProgress(40);
                        titleText.setText("Question 2");
                        detailText.setText("In terms of Android development, what is a layout?");
                        answer1Button.setText("A defined way to structure code effectively");
                        answer2Button.setText("Defines the structure for a user interface");
                        answer3Button.setText("The blueprint of an activity");
                    } else if (currentQuestionNumber == 2) {
                        currentQuestionNumber += 1;
                        progressText.setText("3/5");
                        progressBar.setProgress(60);
                        titleText.setText("Question 3");
                        detailText.setText("What is Android 8.0's dessert codename?");
                        answer1Button.setText("Oreo");
                        answer2Button.setText("Lollipop");
                        answer3Button.setText("Pie");
                    } else if (currentQuestionNumber == 3) {
                        currentQuestionNumber += 1;
                        progressText.setText("4/5");
                        progressBar.setProgress(80);
                        titleText.setText("Question 4");
                        detailText.setText("What order are the three lifecycle callbacks called in?");
                        answer1Button.setText("onStart(), onCreate(), onResume()");
                        answer2Button.setText("onResume(), onCreate(), onStart()");
                        answer3Button.setText("onCreate(), onStart(), onResume()");
                    } else if (currentQuestionNumber == 4) {
                        currentQuestionNumber += 1;
                        progressText.setText("5/5");
                        progressBar.setProgress(100);
                        titleText.setText("Question 5");
                        detailText.setText("Which of the following data types can be saved using a shared preferences interface?");
                        answer1Button.setText("Boolean");
                        answer2Button.setText("Array");
                        answer3Button.setText("Datetime");
                    } else if (currentQuestionNumber == 5) {
                        String score = Integer.toString(correctAnswers);
                        result.putExtra("score", score);
                        result.putExtra("name", i.getStringExtra("name"));
                        startActivity(result);
                        finish();
                    }
                }
            }
        });
    }

    public void checkSelectedAnswer(int selectedAnswer, int correctAnswer) {
        hasSubmitted = 1;
        submitButton.setText("Next");
        answer1Button.setVisibility(View.VISIBLE);
        answer2Button.setVisibility(View.VISIBLE);
        answer3Button.setVisibility(View.VISIBLE);

        if (correctAnswer == 1) {
            answer1Button.setBackgroundColor(Color.GREEN);
        } else if (correctAnswer == 2) {
            answer2Button.setBackgroundColor(Color.GREEN);
        } else if (correctAnswer == 3) {
            answer3Button.setBackgroundColor(Color.GREEN);
        }

        if (selectedAnswer == correctAnswer) {
            correctAnswers += 1;
        } else if (selectedAnswer == 1) {
            answer1Button.setBackgroundColor(Color.RED);
        } else if (selectedAnswer == 2) {
            answer2Button.setBackgroundColor(Color.RED);
        } else if (selectedAnswer == 3) {
            answer3Button.setBackgroundColor(Color.RED);
        }
    }
}