package com.example.ajesh.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.ajesh.testapp.R.drawable.dice2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //EditText name, Email;
    TextView playerTurn, p1Turn, p2Turn, p1Total, p2Total;
    Button bRoll, bHold, bReset;
    int p1TurnScore,p2TurnScore,p1TotalScore,p2TotalScore,currentTurn;
    char diceValue;
    ImageView imageDice;
    int score=0;
    int WINNING_VALUE=20;
    boolean isP1Turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //name= (EditText)findViewById(R.id.edittext);
        playerTurn=(TextView)findViewById(R.id.tvturn);
        p1Turn=(TextView)findViewById(R.id.tvp1tscore);
        p2Turn=(TextView)findViewById(R.id.tvp2tscore);
        p1Total=(TextView)findViewById(R.id.tvp1fscore);
        p2Total=(TextView)findViewById(R.id.tvp2fscore);

        bRoll=(Button)findViewById(R.id.broll);
        bHold=(Button)findViewById(R.id.bhold);
        bReset=(Button)findViewById(R.id.breset);

        imageDice=(ImageView)findViewById(R.id.dice1);
        bRoll.setOnClickListener(this);
        bHold.setOnClickListener(this);
        bReset.setOnClickListener(this);

        //Email=(EditText)findViewById(R.id.edittext2);

    }
     /*public void submit (View v)
     {
     String n = name.getText().toString();
     String e = Email.getText().toString();
         Intent i = new Intent(this,Main2Activity.class);
         i.putExtra("name_Key",n);
         i.putExtra("Email_Key",e);
         startActivity(i);
     }*/

       public void roll() {
           Random random = new Random();
           int diceValue = random.nextInt(5) + 1;

           if (diceValue == 1) {
               score = 0;
               finalizeScore();
           } else {
               score += diceValue;
           }


       }

    private void gameOver()
    {
        if(isP1Turn)
        {
            playerTurn.setText("Player 1 Wins!!");
        }
        else
        {
            playerTurn.setText("Player 2 Wins!!");
            reset();
        }
    }



        public void finalizeScore() {
            if (isP1Turn) {
                p1TotalScore += score;

                if(p1TotalScore>=WINNING_VALUE)
                {
                    gameOver();
                }
            } else {
                p2TotalScore += score;
                if(p2TotalScore>=WINNING_VALUE)
                {
                    gameOver();
                }

            }
            if (isP1Turn != isP1Turn) {
                score = 0;
            }
             isP1Turn = true;
            updateViews();
        }


     public void updateViews()
     {
         if(isP1Turn)
         {
             playerTurn.setText("Player 1 turn");

         }
         else
         {
             playerTurn.setText("Player 2 turn");
         }

         switch(diceValue)
         {
             case 1:
                 imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                 break;
             case 2:
                 imageDice.setImageDrawable(getResources().getDrawable(dice2));
                 break;
             case 3:
                 imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                 break;
             case 4:
                 imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                 break;
             case 5:
                 imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                 break;
             case 6:
                 imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                 break;

         }
         if(isP1Turn)
         {
             p1Turn.setText("P1 Turn Score: "+score);
             p2Turn.setText("P2 Turn Score: 0");

         }
         else
         {
             p2Turn.setText("P2 Turn Score: "+score);
             p2Turn.setText("P1 Turn Score: 0");

         }
         p1Total.setText("P1 Total Score: "+p1TotalScore);
         p2Total.setText("P1 Total Score: "+p2TotalScore);

     }
    public void hold()
    {

    }

    public void reset()
    {

    }




         @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.broll:
                roll();
                break;

            case R.id.bhold:
                hold();
                break;

            case R.id.breset:
                reset();
                break;

        }
    }
}
