package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score_team_A = 0;
    int score_team_B = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           }
    public void displayForTeamA(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public  void plusThree_A(View view)
    {
        score_team_A = score_team_A+3;
        displayForTeamA(score_team_A);

    }
    public  void plusTwo_A(View view)
    {
        score_team_A = score_team_A+2;
        displayForTeamA(score_team_A);
    }
    public  void freeThrow_A(View view)
    {
        score_team_A = score_team_A+1;
        displayForTeamA(score_team_A);
    }
    public  void plusThree_B(View view)
    {
        score_team_B = score_team_B+3;
        displayForTeamB(score_team_B);

    }
    public  void plusTwo_B(View view)
    {
        score_team_B = score_team_B+2;
        displayForTeamB(score_team_B);
    }
    public  void freeThrow_B(View view)
    {
        score_team_B = score_team_B+1;
        displayForTeamB(score_team_B);
    }
    public  void  reset (View view){
        score_team_A=0;
        score_team_B=0;
        displayForTeamB(score_team_B);
        displayForTeamA(score_team_A);
    }
}