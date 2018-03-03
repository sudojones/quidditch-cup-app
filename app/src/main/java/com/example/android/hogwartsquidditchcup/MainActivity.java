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
        displayCurrentMatch(currentMatch);
        setCurrentHouses(currentMatch);
        displayHouses();
    }

    /**
     * Initializing global variables
     */
    int currentMatch = 1;

    /* Match Score */
    int houseAScore = 0;
    int houseBScore = 0;

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
        matchView.setText(String.valueOf("Match " + currentMatch + " of 6"));
    }

    public void setCurrentHouses(int currentMatch) {
        switch (currentMatch) {
            case 1:
                houseA = "Gryffindor";
                houseB = "Slytherin";
                break;
            case 2:
                houseA = "Hufflepuff";
                houseB = "Ravenclaw";
                break;
            case 3:
                houseA = "Ravenclaw";
                houseB = "Slytherin";
                break;
            case 4:
                houseA = "Gryffindor";
                houseB = "Hufflepuff";
                break;
            case 5:
                houseA = "Hufflepuff";
                houseB = "Slytherin";
                break;
            case 6:
                houseA = "Gryffindor";
                houseB = "Ravenclaw";
                break;
        }
    }

    public void displayHouses() {
        TextView currentHouseA = (TextView) findViewById(R.id.house_a);
        TextView currentHouseB = (TextView) findViewById(R.id.house_b);
        currentHouseA.setText(String.valueOf(houseA));
        currentHouseB.setText(String.valueOf(houseB));
    }


    /**
     * Displays House scores for current match
     */
    /*House A*/
    public void displayScoreHouseA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.house_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /*House B*/
    public void displayScoreHouseB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.house_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * House A Buttons
     */

    public void goalA(View view) {
        houseAScore = houseAScore + 10;
        displayScoreHouseA(houseAScore);
    }

    public void snitchA(View view) {
        houseAScore = houseAScore + 150;
        displayScoreHouseA(houseAScore);
    }

    /**
     * House B Buttons
     */

    public void goalB(View view) {
        houseBScore = houseBScore + 10;
        displayScoreHouseB(houseBScore);
    }

    public void snitchB(View view) {
        houseBScore = houseBScore + 150;
        displayScoreHouseB(houseBScore);
    }

    /**
     * Next Match Button
     */
    public void beginNextMatch() {
        houseAScore = 0;
        houseBScore = 0;
        currentMatch = currentMatch + 1;
        displayCurrentMatch(currentMatch);
        setCurrentHouses(currentMatch);
        displayHouses();
        displayScoreHouseA(houseAScore);
        displayScoreHouseB(houseBScore);
    }

    public void nextMatch(View view) {
        switch (currentMatch) {
            case 1:
                gryfScoreTotal = houseAScore;
                slyScoreTotal = houseBScore;
                break;
            case 2:
                huffScoreTotal = houseAScore;
                raveScoreTotal = houseBScore;
                break;
            case 3:
                raveScoreTotal = raveScoreTotal + houseAScore;
                slyScoreTotal = slyScoreTotal + houseBScore;
                break;
            case 4:
                gryfScoreTotal = gryfScoreTotal + houseAScore;
                huffScoreTotal = huffScoreTotal + houseBScore;
                break;
            case 5:
                huffScoreTotal = huffScoreTotal + houseAScore;
                slyScoreTotal = slyScoreTotal + houseBScore;
                break;
            case 6:
                gryfScoreTotal = gryfScoreTotal + houseAScore;
                raveScoreTotal = raveScoreTotal + houseBScore;
        }
        beginNextMatch();
    }

    /**
     * Reset Match Button
     */
    public void resetButton(View view) {
        houseAScore = 0;
        houseBScore = 0;
        displayScoreHouseA(houseAScore);
        displayScoreHouseB(houseBScore);
    }

}
