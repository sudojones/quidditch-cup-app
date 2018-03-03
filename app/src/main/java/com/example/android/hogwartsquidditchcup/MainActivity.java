package com.example.android.hogwartsquidditchcup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Initializing global variables
     */
    int currentMatch = 1;

    /* Match Score */
    int houseAScore = 0;
    int houseBScore = 0;
    int gryfScore = 0;
    int huffScore = 0;
    int raveScore = 0;
    int slyScore = 0;

    /*Total Score*/
    int gryfScoreTotal = 0;
    int huffScoreTotal = 0;
    int raveScoreTotal = 0;
    int slyScoreTotal = 0;

    /*Current Houses in Match*/
    String houseA;
    String houseB;

    /**
     * Sets up which Houses are currently playing
     */
    public void displayCurrentMatch(int currentMatch) {
        TextView matchView = (TextView) findViewById(R.id.currentMatch);
        matchView.setText(String.valueOf(currentMatch));
    }

    public void setCurrentHouses(int currentMatch) {
        switch (currentMatch) {
            case 1:
                houseA = "gryf";
                houseB = "sly";
                break;
            case 2:
                houseA = "huff";
                houseB = "rave";
                break;
            case 3:
                houseA = "rave";
                houseB = "sly";
                break;
            case 4:
                houseA = "gryf";
                houseB = "huff";
                break;
            case 5:
                houseA = "huff";
                houseB = "sly";
                break;
            case 6:
                houseA = "gryf";
                houseB = "rave";
                break;
        }
    }


    /**
     * Displays House scores for current match
     */
    /*House A*/
    public void displayForHouseA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.house_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /*House B*/
    public void displayForHouseB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.house_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * House A Buttons
     */

    public void goalA(View view) {
        houseAScore = houseAScore + 10;
        displayForHouseA(houseAScore);
    }

    public void snitchA(View view) {
        houseAScore = houseAScore + 150;
        displayForHouseA(houseAScore);
    }

    /**
     * House B Buttons
     */

    public void goalB(View view) {
        houseBScore = houseBScore + 10;
        displayForHouseB(houseAScore);
    }

    public void snitchB(View view) {
        houseBScore = houseBScore + 150;
        displayForHouseB(houseBScore);
    }

}
