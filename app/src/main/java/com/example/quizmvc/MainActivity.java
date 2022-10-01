package com.example.quizmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button tBtn, fBtn;
    ImageButton nextBtn, prevBtn;
    TextView myQuesText;
    int currentIndex = 0;

    private QuestionsModel[] myQuestions = new QuestionsModel[]{

            new QuestionsModel(R.string.my_question1,false),
            new QuestionsModel(R.string.my_question2,false),
            new QuestionsModel(R.string.my_question3,false),
            new QuestionsModel(R.string.my_question4,true),
            new QuestionsModel(R.string.my_question5,false),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tBtn = findViewById(R.id.trueBtn);
        fBtn = findViewById(R.id.falseBtn);
        nextBtn = findViewById(R.id.nextButton);
        prevBtn = findViewById(R.id.preButton);

        myQuesText = findViewById(R.id.quest);

        tBtn.setOnClickListener(this);
        fBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.trueBtn:

              //  Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                checkAnswer(true);
                break;
            case R.id.falseBtn:
            //    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                checkAnswer(false);
                break;
            case R.id.nextButton:
              /*  currentIndex = (currentIndex+1) % myQuestions.length;
                updateQues();*/
                if (currentIndex < myQuestions.length -1 ){
                    currentIndex = (currentIndex+1);
                    updateQues();
                }

                break;
            case R.id.preButton:

               /* if (currentIndex > 0){
                    currentIndex = (currentIndex-1) % myQuestions.length;
                    updateQues();
                }*/

                if (currentIndex > 0){
                    currentIndex = (currentIndex-1);
                    updateQues();
                }

                break;
        }
    }

    private void updateQues(){

        myQuesText.setText(myQuestions[currentIndex].getQuesRid());
    }

    private void checkAnswer(boolean userChoose){

        boolean cAnswer = myQuestions[currentIndex].isAnswer();

        if (userChoose == cAnswer){
            Toast.makeText(MainActivity.this,"Thats Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this,"Thats Wrong", Toast.LENGTH_SHORT).show();
        }


    }
}