package com.example.tayyeb.cricketscoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreTeamA = 0;
    private int outTeamA = 0;
    private int oversTeamA = 0;
    private int ballsTeamA = 0;
    private int scoreTeamB = 0;
    private int outTeamB = 0;
    private int oversTeamB = 0;
    private int ballsTeamB = 0;
    private int totalOvers = 0;
    private int addScore=0;
    private int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScores(String Scores) {
        TextView scoreView = (TextView) findViewById(R.id.show_scores);
        scoreView.setText(Scores);
    }
    public void displayNeed(String need) {
        TextView scoreView = (TextView) findViewById(R.id.need);
        scoreView.setText(need);
    }
        public void displayPositionA(String position) {
            TextView scoreView = (TextView) findViewById(R.id.show_position_a);
            scoreView.setText(position);
    }
    public void displayPositionB(String position) {
        TextView scoreView = (TextView) findViewById(R.id.show_position_b);
        scoreView.setText(position);
    }
    public void displayScoresB(String Scores) {
        TextView scoreView = (TextView) findViewById(R.id.show_scores_b);
        scoreView.setText(Scores);
    }
    public void displayOutTeamA(int Out) {
        TextView scoreView = (TextView) findViewById(R.id.out_team_a);
        scoreView.setText(""+Out);
    }
    public void displayOutTeamB(int Out) {
        TextView scoreView = (TextView) findViewById(R.id.out_team_b);
        scoreView.setText(""+Out);
    }

    public void displayOverTeamA(String Over) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_balls);
        scoreView.setText(""+Over);
    }

    public void displayOverTeamB(String Over) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_balls);
        scoreView.setText(""+Over);
    }
    public void displayTotalOverTeamA(String Over) {
        TextView scoreView = (TextView) findViewById(R.id.total_overs);
        scoreView.setText(Over);
    }

    public void addSixToTeam(View view) {
        addScore=6;
       addScore(addScore);
       addPosition("(Bating)","(Balling)");
       n=1;
    }
    public void addFourToTeam(View view) {
        addScore=4;
        addScore(addScore);
        addPosition("(Bating)","(Balling)");
        n=1;
    }
    public void addThreeToTeam(View view) {
        addPosition("(Bating)","(Balling)");
        addScore=3;
        addScore(addScore);
        n=1;
    }
    public void addTwoToTeam(View view) {
        addPosition("(Bating)","(Balling)");
        addScore=2;
        addScore(addScore);
        n=1;
    }
    public void addOneToTeam(View view) {
        addPosition("(Bating)","(Balling)");
        addScore=1;
        addScore(addScore);
        n=1;
    }
    public void addZeroToTeam(View view) {
        addPosition("(Bating)","(Balling)");
        addScore=0;
        addScore(addScore);
        n=1;
    }

    public void addScore(int score) {
        if (this.oversTeamA < this.totalOvers && this.outTeamA < 11) {
                this.scoreTeamA = this.scoreTeamA + score;

                displayScores(this.scoreTeamA + "/");
                addOverTeamA();
        }
        else if (this.oversTeamB<this.totalOvers &&  this.scoreTeamB<this.scoreTeamA && this.outTeamB < 11) {

            this.scoreTeamB = this.scoreTeamB + score;

            displayScoresB(this.scoreTeamB + "/");
            addOverTeamB();
            if (this.scoreTeamB < this.scoreTeamA) {
                int needR = this.scoreTeamA - this.scoreTeamB;
                int needB = (this.totalOvers * 6) - ((this.oversTeamB * 6) + this.ballsTeamB);
                displayNeed("Need " + needR + " Runs at " + needB + " balls");
            }
            else{
                displayNeed("");
            }
        }

    }
    public void addPosition(String positionA,String positionB){
        if (this.oversTeamA < this.totalOvers && this.outTeamA < 11) {
            displayPositionA(positionA);
            displayPositionB(positionB);
        }
        else if (this.oversTeamB<this.totalOvers && this.scoreTeamB<this.scoreTeamA && this.outTeamB < 11){
            displayPositionA(positionB);
            displayPositionB(positionA);
        }
        else {
            if (this.scoreTeamA > this.scoreTeamB) {
                displayPositionA("WINNER!");
                displayPositionB("(Good Try..)");
                displayTotalOverTeamA("---");
            }
            else if (this.scoreTeamB>this.scoreTeamA){
                displayPositionB("WINNER!");
                displayPositionA("(Good Try..)");
                displayTotalOverTeamA("---");
            }
        }


    }

    public void addOverTeamA() {

        if (this.oversTeamA < this.totalOvers && this.outTeamA<11) {
            this.ballsTeamA++;
            if (this.ballsTeamA > 5) {
                this.oversTeamA++;
                this.ballsTeamA = 0;
            }
            displayOverTeamA("Overs" + this.oversTeamA + "." + this.ballsTeamA);

        }
        addPosition("(Bating)","(Balling)");
    }
    public void addOverTeamB() {

        if (this.oversTeamB < this.totalOvers && this.outTeamB<11) {
            this.ballsTeamB++;
            if (this.ballsTeamB > 5) {
                this.oversTeamB++;
                this.ballsTeamB = 0;
            }
            displayOverTeamB("Overs" + this.oversTeamB + "." + this.ballsTeamB);
        }
        addPosition("(Bating)","(Balling)");
    }
    public void incrementTotalOvers(View view) {
        if (this.ballsTeamA == 0 && this.ballsTeamB == 0 && this.oversTeamB == 0 && this.oversTeamA == 0) {
            this.totalOvers++;
            displayTotalOverTeamA(""+this.totalOvers);
            displayPositionA("(Bating)");
            displayPositionB("(Balling)");
        }

    }
    public void decrementTotalOvers(View view) {
        if (this.ballsTeamA == 0 && this.ballsTeamB == 0 && this.oversTeamB == 0 && this.oversTeamA == 0) {
            if (this.totalOvers > 0) {
                this.totalOvers--;
            }
            displayTotalOverTeamA(""+this.totalOvers);
            if(this.totalOvers<1){
                displayPositionA("-----");
                displayPositionB("-----");
            }
        }
    }
    public void addOutTeamA(View view) {
        if (this.oversTeamA < this.totalOvers && this.outTeamA < 11) {
            this.outTeamA++;
            displayOutTeamA(this.outTeamA);
            addOverTeamA();
        }
      else  if (this.oversTeamB < this.totalOvers &&  this.scoreTeamB<this.scoreTeamA && this.outTeamB < 11) {
            this.outTeamB++;
            displayOutTeamB(this.outTeamB);
            addOverTeamB();
            int needR=this.scoreTeamA-this.scoreTeamB;
            int needB=(this.totalOvers*6)-((this.oversTeamB*6)+this.ballsTeamB);
            displayNeed("Need "+needR+" Runs at "+needB+" balls");
        }
    }
    public void Undo(View view){
        if(this.totalOvers>0 && n==1){
            if(this.scoreTeamB==0)
            {
                setUndo(scoreTeamA,ballsTeamA,oversTeamA);

            }
            else if((this.oversTeamA==this.totalOvers || this.outTeamA==11) && this.oversTeamB < this.totalOvers && this.outTeamB < 11)
            {
                setUndo(scoreTeamB,ballsTeamB,oversTeamB);
            }

        }

    }
    public void setUndo(int scoreT,int ballsT,int oversT){
        scoreT=scoreT-addScore;
        displayScores(scoreT+"/");
        this.addScore=0;
        this.n=0;
        if(ballsT>0){
            ballsT--;
        }
        else{
            ballsT=5;
            oversT--;
        }
        displayOverTeamB("Overs" +oversT + "." + ballsT);

    }
    public void Reset(View view){
          this.scoreTeamA = 0;
          displayScores("0/");

        this.scoreTeamB = 0;
        displayScoresB("0/");

          this.outTeamA = 0;
          displayOutTeamA(this.outTeamA);

          this.oversTeamA = 0;
        this.ballsTeamA = 0;
        displayOverTeamA("Overs:" + this.oversTeamA + "." + this.ballsTeamA);

        this.outTeamB = 0;
        displayOutTeamB(this.outTeamB);

        this.oversTeamB = 0;
        this.ballsTeamB = 0;
        displayOverTeamB("Overs:" + this.oversTeamB + "." + this.ballsTeamB);

        this.totalOvers = 0;
        displayTotalOverTeamA(""+this.totalOvers);
        displayPositionA("-----");
        displayPositionB("-----");
        displayNeed("");
    }

}
