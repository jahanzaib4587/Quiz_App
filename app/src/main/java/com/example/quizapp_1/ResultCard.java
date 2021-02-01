package com.example.quizapp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultCard extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_card);
        resultView=findViewById(R.id.resultView);

        String s=getIntent().getStringExtra("Result");
        resultView.setText(s);



    }


}