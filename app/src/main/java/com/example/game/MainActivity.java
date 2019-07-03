package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.game.R.id.b_rock;
import static com.example.game.R.id.iv_computer;
import static com.example.game.R.id.iv_user;

public class MainActivity extends AppCompatActivity {

    Button rock,scissor,paper;
    ImageView user,computer;
    TextView score;
     Integer userscore =0,computerscore=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock =findViewById(b_rock);
        scissor = findViewById(R.id.b_scissor);
        paper =findViewById(R.id.b_paper);
        user = findViewById(R.id.iv_user);
        computer =findViewById(R.id.iv_computer);
        score =findViewById(R.id.score);



        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setImageResource(R.drawable.rock);
               String message = play_turn("rock");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                 score.setText("User " +Integer.toString(userscore) + " Computer "+ Integer.toString(computerscore));
            }
        });


        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                user.setImageResource(R.drawable.scissor);
                String message = play_turn("scissor");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("User " +Integer.toString(userscore) + " Computer "+ Integer.toString(computerscore));

            }
        });



        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                user.setImageResource(R.drawable.paper);
               String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("User " +Integer.toString(userscore) + " Computer "+ Integer.toString(computerscore));
            }
        });


    }

    private String play_turn(String user_choice) {

        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3) + 1;


        if (computer_choice_number == 1) {
            computer_choice = "rock";

        } else if (computer_choice_number == 2) {
            computer_choice = "scissor";

        } else if (computer_choice_number == 3) {
            computer_choice = "paper";
        }


        if (computer_choice == "paper") {
            computer.setImageResource(R.drawable.paper);

        } else if (computer_choice == "scissor") {
            computer.setImageResource(R.drawable.scissor);

        } else if (computer_choice == "rock") {
            computer.setImageResource(R.drawable.rock);

        }


        if (computer_choice == user_choice) {

            return "Draw Nobody Win";
        } else if (computer_choice == "rock" && user_choice == "scissor") {
            computerscore++;
            return "Rock crushes Scissors, Computer win";

        } else if (computer_choice == "rock" && user_choice == "paper") {
            userscore++;
            return "paper covers rock , You  Win ";

        } else if (computer_choice == "paper" && user_choice == "rock") {
            computerscore++;
            return "paper covers rock, Computer Win ";

        } else if (computer_choice == "paper" && user_choice == "scissor ") {
            userscore++;
            return "Scissor cut paper , You  Win ";

        } else if (computer_choice == "scissor" && user_choice == "rock") {
            userscore++;
            return "Rock crushes scissor, you Win ";

        } else if (computer_choice == "scissor" && user_choice == "paper") {
            computerscore++;
            return "Scissor cut paper , Computer  Win ";

        }

      else

          return  "Not Sure";
    }
}
