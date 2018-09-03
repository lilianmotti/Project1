package com.wordpress.liliangmader.gameengine1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //displayQuestion();
    }

    int numberLives=5;
    int numberOfQuestions=10;
    int sortQuestionNumber=0;
    int probRightAnswer=50;


    public void displayNewQuestion(){

        TextView myStatus = (TextView) findViewById(R.id.status);
        String myCurrentStatus = "Current status: "+numberLives+" lives";
        //Log.v("MainActivity",myCurrentStatus);
        myStatus.setText(String.valueOf(myCurrentStatus));

        TextView myQuestion = (TextView) findViewById(R.id.question);
        myQuestion.setText(String.valueOf(sortQuestionNumber));
    }

    public void answerYes(View view){
        //no changes numberLives
        Log.v("MainActivity","Yes");
        sortQuestion();
        displayNewQuestion();
    }

    public void answerNo(View view){
        numberLives--;
        Log.v("MainActivity","No");
        if (numberLives == 0) {
            Log.v("MainActivity", "Game Over");
            GameOver();
        } else {
            sortQuestion();
            displayNewQuestion();
        }

    }

    public void sortQuestion(){
        //sortQuestionNumber++;
        //pick a random question number from 1 to the numberOfQuestions
        double randomNumber = Math.random()*numberOfQuestions +1;
        sortQuestionNumber = (int) randomNumber;
        Log.v("MainActivity","sorting new question "+sortQuestionNumber);
        displayNewQuestion();
    }


    public void GameOver(){
        TextView myQuestion = (TextView) findViewById(R.id.question);
        myQuestion.setText(String.valueOf("Game Over"));
        View buttons_holder = findViewById(R.id.buttons_holder);
        buttons_holder.setVisibility(View.INVISIBLE);
    }
}
