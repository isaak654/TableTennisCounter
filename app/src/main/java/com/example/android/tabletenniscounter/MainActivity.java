package com.example.android.tabletenniscounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.tabletenniscounter.R.id.team_a_fault;
import static com.example.android.tabletenniscounter.R.id.team_a_score;

public class MainActivity extends AppCompatActivity {
    //Tracks the score for Team A
    int scoreTeamA = 0;

    //Tracks the score for Team B
    int scoreTeamB = 0;

    //Tracks the set for Team A
    int setTeamA = 0;

    //Tracks the set for Team B
    int setTeamB = 0;

    //Tracks the fault for Team A
    int faultTeamA = 0;

    //Tracks the fault for Team B
    int faultTeamB = 0;

    //Declaring onCreate variables
    TextView scoreViewA;
    TextView scoreViewB;
    TextView setViewA;
    TextView setViewB;
    TextView faultViewA;
    TextView faultViewB;

    /////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Move findViewById to onCreate to minimize the number of expensive findViewById method calls */
        scoreViewA = (TextView) findViewById(team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        setViewA = (TextView) findViewById(R.id.team_a_set);
        setViewB = (TextView) findViewById(R.id.team_b_set);
        faultViewA = (TextView) findViewById(team_a_fault);
        faultViewB = (TextView) findViewById(R.id.team_b_fault);

    }

    /////////////////////////////////////////////

    /* Increase the score for Team A by 1 point. */
    public void addOnePointForTeamA(View v) {

        //Increase and display Team A score by 1 point
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

        // Team A wins if gets 11 points, then display a toast and reset all scores to 0.
        if ((scoreTeamA == 11) & (scoreTeamB < 10)) {
            setTeamA = setTeamA + 1;
            displaySetForTeamA(setTeamA);
            if (setTeamA == 3) {
                Toast.makeText(this, getString(R.string.victoryA), Toast.LENGTH_LONG).show();
                this.resetTeams(v);
                return;
            }
            Toast.makeText(this, getString(R.string.roundWinnerA), Toast.LENGTH_LONG).show();
            scoreTeamA = 0;
            displayForTeamA(scoreTeamA);
            scoreTeamB = 0;
            displayForTeamB(scoreTeamB);

        }

        //Beginning of Tiebreak is at 10-10. In this case 2 additional points are required to win.
        if ((scoreTeamA == 10) && (scoreTeamB == 10)) {
            Toast.makeText(this, getString(R.string.tieBreak), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == 12) {
            setTeamA = setTeamA + 1;
            displaySetForTeamA(setTeamA);
            if (setTeamA == 3) {
                Toast.makeText(this, getString(R.string.victoryA), Toast.LENGTH_LONG).show();
                this.resetTeams(v);
                return;
            }
            Toast.makeText(this, getString(R.string.roundWinnerA), Toast.LENGTH_LONG).show();
            scoreTeamA = 0;
            displayForTeamA(scoreTeamA);
            scoreTeamB = 0;
            displayForTeamB(scoreTeamB);
        }
    }

    /* Increase the score for Team B by 1 point. */
    public void addOnePointForTeamB(View v) {

        //Increase and display Team B score by 1 point
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);

        // Team B wins if gets 11 points, then display a toast and reset all scores to 0.
        if ((scoreTeamB == 11) & (scoreTeamA < 10)) {
            setTeamB = setTeamB + 1;
            displaySetForTeamB(setTeamB);
            if (setTeamB == 3) {
                Toast.makeText(this, getString(R.string.victoryB), Toast.LENGTH_LONG).show();
                this.resetTeams(v);
                return;
            }
            Toast.makeText(this, getString(R.string.roundWinnerB), Toast.LENGTH_LONG).show();
            scoreTeamB = 0;
            displayForTeamB(scoreTeamB);
            scoreTeamA = 0;
            displayForTeamA(scoreTeamA);

        }

        //Beginning of Tiebreak is at 10-10. In this case 2 additional points are required to win.
        if ((scoreTeamB == 10) && (scoreTeamA == 10)) {
            Toast.makeText(this, getString(R.string.tieBreak), Toast.LENGTH_LONG).show();
        } else if (scoreTeamB == 12) {
            setTeamB = setTeamB + 1;
            displaySetForTeamB(setTeamB);
            if (setTeamB == 3) {
                Toast.makeText(this, getString(R.string.victoryB), Toast.LENGTH_LONG).show();
                this.resetTeams(v);
                return;
            }
            Toast.makeText(this, getString(R.string.roundWinnerB), Toast.LENGTH_LONG).show();
            scoreTeamB = 0;
            displayForTeamB(scoreTeamB);
            scoreTeamA = 0;
            displayForTeamA(scoreTeamA);
        }
    }

    /* Increase the fault value for Team A by 1 fault. */

    public void addOneFaultForTeamA(View v) {
        faultTeamA = faultTeamA + 1;
        displayFaultForTeamA(faultTeamA);
    }

    /* Increase the fault value for Team B by 1 fault. */

    public void addOneFaultForTeamB(View v) {
        faultTeamB = faultTeamB + 1;
        displayFaultForTeamB(faultTeamB);
    }

    /////////////////////////////////////////////

    /* Displays the given score for Team A. */

    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    /* Displays the given score for Team B. */

    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    /* Displays the given set for Team A. */

    public void displaySetForTeamA(int set) {
        setViewA.setText(String.valueOf(set));
    }

    /* Displays the given set for Team B. */

    public void displaySetForTeamB(int set) {
        setViewB.setText(String.valueOf(set));
    }

    /* Displays the given fault for Team A. */

    public void displayFaultForTeamA(int fault) {
        faultViewA.setText(String.valueOf(fault));
    }

    /* Displays the given fault for Team B. */

    public void displayFaultForTeamB(int fault) {
        faultViewB.setText(String.valueOf(fault));
    }

    /////////////////////////////////////////////

    /* Reset button for Team A and B.    */
    public void resetTeams(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        setTeamA = 0;
        setTeamB = 0;
        faultTeamA = 0;
        faultTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetForTeamA(setTeamA);
        displaySetForTeamB(setTeamB);
        displayFaultForTeamA(faultTeamA);
        displayFaultForTeamB(faultTeamB);
    }

    /////////////////////////////////////////////

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("scoreTeamB", scoreTeamB);
        savedInstanceState.putInt("scoreTeamA", scoreTeamA);
        savedInstanceState.putInt("scoreTeamB", scoreTeamB);
        savedInstanceState.putInt("setTeamA", setTeamA);
        savedInstanceState.putInt("setTeamB", setTeamB);
        savedInstanceState.putInt("faultTeamA", faultTeamA);
        savedInstanceState.putInt("faultTeamB", faultTeamB);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        setTeamA = savedInstanceState.getInt("setTeamA");
        setTeamB = savedInstanceState.getInt("setTeamB");
        faultTeamA = savedInstanceState.getInt("faultTeamA");
        faultTeamB = savedInstanceState.getInt("faultTeamB");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetForTeamA(setTeamA);
        displaySetForTeamB(setTeamB);
        displayFaultForTeamA(faultTeamA);
        displayFaultForTeamB(faultTeamB);
    }

}