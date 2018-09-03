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
    int numberOfProbs=5;
    int numberOfQuestions=10;
    int sortQuestionNumber=0;
    int probRightAnswer=50;


    /**
     * Control the display of questions
     */
    public void displayNewQuestion(){

        TextView myStatus = (TextView) findViewById(R.id.status);
        String myCurrentStatus = "Current status: "+numberLives+" lives";
        //Log.v("MainActivity",myCurrentStatus);
        myStatus.setText(String.valueOf(myCurrentStatus));

        TextView myQuestion = (TextView) findViewById(R.id.question);
        //String questionIndex = "R.string.q"+1;
        //Log.v("MainActivity","questionIndex= "+questionIndex);
        //String packageName = getPackageName();
        //int resId = getResources().getIdentifier(questionIndex, String
        //Log.v("MainActivity","resID: "+resId);
       // String textQuestion = getString(resID);
        switch (sortQuestionNumber) {
            case 1:
                myQuestion.setText(R.string.q1);
                break;
            case 2:
                myQuestion.setText(R.string.q2);
                break;
            case 3:
                myQuestion.setText(R.string.q3);
                break;
            case 4:
                myQuestion.setText(R.string.q4);
                break;
            case 5:
                myQuestion.setText(R.string.q5);
                break;
            case 6:
                myQuestion.setText(R.string.q6);
                break;
            case 7:
                myQuestion.setText(R.string.q7);
                break;
            case 8:
                myQuestion.setText(R.string.q8);
                break;
            case 9:
                myQuestion.setText(R.string.q9);
                break;
            case 10:
                myQuestion.setText(R.string.q10);
                break;
        }
    }
    /**
     * Click on button "Yes"
     * @param view button Yes
     */
    public void answerYes(View view){
        //no changes numberLives
        Log.v("MainActivity","Yes");
        sortQuestion();
        displayNewQuestion();
    }
    /**
     * Click on button "No"
     * @param view button NO
     */
    public void answerNo(View view){
      //Lost one life after failing survival test
        if (!testSurvival()) {
            numberLives--;
            Log.v("MainActivity", "Answer no, number of lives: "+numberLives);
            if (numberLives == 0) {
                Log.v("MainActivity", "Game Over");
                GameOver();
            } else {
                Log.v("MainActivity", "Answer no, but still alive. Number of lives: "+numberLives);
                sortQuestion();
                displayNewQuestion();
            }
        } else {
            sortQuestion();
            displayNewQuestion();
        }
    }
    /**
     * Pick a random question number from 1 to the numberOfQuestions
     */
    public void sortQuestion(){
        //sortQuestionNumber++;
        double randomNumber = Math.random()*numberOfQuestions +1;
        sortQuestionNumber = (int) randomNumber;
        Log.v("MainActivity","sorting new question "+sortQuestionNumber);
        displayNewQuestion();
    }
    /**
     * Hide the buttons when the game is over (number of lives =0)
     */
    public void GameOver(){
        TextView myQuestion = (TextView) findViewById(R.id.question);
        myQuestion.setText(String.valueOf("Game Over"));
        View buttons_holder = findViewById(R.id.buttons_holder);
        buttons_holder.setVisibility(View.INVISIBLE);
    }
    /**
     * Test chance of survival after a negative answer
     * comparing a random number between 1 and 100
     * to the initial probRightAnswer
     */
    public boolean testSurvival(){
        double randomNumber = Math.random()*100 +1;
        int chanceSurvival = (int) randomNumber;
        Log.v("MainActivity","Chance of survival "+chanceSurvival+"%");
        if (chanceSurvival>= probRightAnswer) {
            Log.v("MainActivity", "You died " + probRightAnswer);
            return false;
        } else {
            Log.v("MainActivity", "You live " + probRightAnswer);
            return true;
        }

    }
}
