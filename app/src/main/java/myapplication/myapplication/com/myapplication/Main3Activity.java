package myapplication.myapplication.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    int teamAScore = 0, teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void addTeamA3Points(View view)
    {
        teamAScore +=3;
        displayTeamAScore(teamAScore);
    }

    public void addTeamA2Points(View view)
    {
        teamAScore +=2;
        displayTeamAScore(teamAScore);
    }

    public void addTeamAFreePoints(View view)
    {
        teamAScore +=1;
        displayTeamAScore(teamAScore);
    }

    private void displayTeamAScore(int teamAScore)
    {
        TextView textViewTeamAScore = (TextView) findViewById(R.id.textViewTeamAScore);
        textViewTeamAScore.setText(""+teamAScore);
    }

    public void addTeamB3Points(View view)
    {
        teamBScore +=3;
        displayTeamBScore(teamBScore);
    }

    public void addTeamB2Points(View view)
    {
        teamBScore +=2;
        displayTeamBScore(teamBScore);
    }

    public void addTeamBFreePoints(View view)
    {
        teamBScore +=1;
        displayTeamBScore(teamBScore);
    }

    private void displayTeamBScore(int teamBScore)
    {
        TextView textViewTeamBScore = (TextView) findViewById(R.id.textViewTeamBScore);
        textViewTeamBScore.setText(""+teamBScore);
    }

    public void ResetScore(View view)
    {
        teamAScore = teamBScore = 0;
        displayTeamAScore(teamAScore);
        displayTeamBScore(teamBScore);
    }
}
