package com.example.quizapp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView timerText,TimerCounter,QuestionCouter,QuestionDisplay;
    Button Op1,Op2,Op3,Op4,next;
    CountDownTimer tm;
    View yet;
    boolean isClicked=false;
    String clickedButtonText;
    int counter,questionIndex;
    Model_Object obj;
    int correctCount=0,wrongCounter;
    ArrayList<Model_Object> myList=new ArrayList<Model_Object>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerText=findViewById(R.id.TimeLeftTextView);
        TimerCounter=findViewById(R.id.timerView);
        QuestionCouter=findViewById(R.id.questionCounterView);
        QuestionDisplay=findViewById(R.id.questionView);
        Op1=findViewById(R.id.option1);
        Op2=findViewById(R.id.option2);
        Op3=findViewById(R.id.option3);
        Op4=findViewById(R.id.option4);
        next=findViewById(R.id.next);


        myList.add(new Model_Object("Dummy Question No.1","right","wrong","wrong","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.2","wrong","wrong","right","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.3","wrong","right","wrong","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.4","wrong","wrong","right","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.5","wrong","right","wrong","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.6","right","wrong","wrong","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.7","wrong","wrong","wrong","right","right"));
        myList.add(new Model_Object("Dummy Question No.8","right","wrong","wrong","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.9","wrong","wrong","right","wrong","right"));
        myList.add(new Model_Object("Dummy Question No.10","wrong","wrong","wrong","right","right"));
        Collections.shuffle(myList);
        counter=0;
        TimerCounter.setText("" +12);
        setData(counter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isClicked==true)
                {
                    Log.i("bool", "onClick: "+isClicked);
                    ClickNext(view,clickedButtonText,questionIndex);
                }
                else
                {
                    Log.i("bool", "else: "+isClicked);
                    ClickNext(yet,"Nothing",0);
                }


            }
        });

      /////////////Timer/////////////
       tm= new CountDownTimer(12*1000,1000)
        {
            @Override
            public void onTick(long l) {
                TimerCounter.setText(String.format("%d", l / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time Over", Toast.LENGTH_SHORT).show();

                ClickNext(yet,"Nothing",0);
            }
        };
    }
///////Display_Data///////
    public  void setData(final int val)
    {
        final Model_Object obj=myList.get(val);
        QuestionCouter.setText((val+1)+"/"+myList.size());
        if (tm!=null)
        {
            tm.start();
        }
        QuestionDisplay.setText("#"+(val+1)+" "+obj.getQuestion());
        Op1.setText(obj.getOpt1());
        Op2.setText(obj.getOpt2());
        Op3.setText(obj.getOpt3());
        Op4.setText(obj.getOpt4());


      Op1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isClicked=true;
            clickedButtonText = Op1.getText().toString();
            questionIndex = val;

        }
      });

        Op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                clickedButtonText=Op2.getText().toString();
                questionIndex=val;

            }
        });

        Op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                clickedButtonText=Op3.getText().toString();
                questionIndex=val;
            }
        });

        Op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                clickedButtonText=Op4.getText().toString();
                questionIndex=val;
            }
        });

    }
////////New Intent/////
    public void newActivity(View view,int val,int total,int wrong)
    {
        Intent intent = new Intent(this,ResultCard.class);
        String result="Your Result is\n  "+"Correct: "+val+"/"+total+"\n"+"Wrong: "+wrong+"/"+total;
        intent.putExtra("Result",result);
        startActivity(intent);

    }
    //////Next Click Activity//////
    public void ClickNext(View view,String clickedButtonText,int questionIndex)
    {
        final Model_Object obj1=myList.get(questionIndex);

       if(counter<(myList.size()-1))
       {
           if(clickedButtonText.equals(obj1.getAnswer())) {
               correctCount++;
           }
           else {
                    wrongCounter++;
           }

            tm.cancel();
          isClicked=false;
            counter++;
            setData(counter);
            if(counter==(myList.size()-1)){
                next.setText("Finish");
            }
     }

        else
        {

            if(clickedButtonText.equals(obj1.getAnswer()))
            {
                correctCount++;
            }
            else {
                wrongCounter++;
            }
            tm.cancel();

            Toast.makeText(MainActivity.this, "Questions are completed", Toast.LENGTH_SHORT).show();
            newActivity(view,correctCount,myList.size(),wrongCounter);
        }
    }

}