package com.zfuller.task31_zacharyfuller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        editTextName = (EditText) findViewById(R.id.editTextName);

        Intent i = getIntent();
        String input = i.getStringExtra("name");
        editTextName.setText(input);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextName.getText().toString().isEmpty()) {
                    String name = editTextName.getText().toString();
                    Intent i = new Intent(MainActivity.this, QuizActivity.class);
                    i.putExtra("name", name);
                    startActivity(i);
                    finish();
                } else {
                    error();
                }
            }
        });
    }

    public void error() {
        Toast.makeText(MainActivity.this, "Please enter your name first!", Toast.LENGTH_SHORT).show();
    }
}
