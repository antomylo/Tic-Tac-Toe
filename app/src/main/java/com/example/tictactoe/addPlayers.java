package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText player1 = findViewById(R.id.playerOne);
        final EditText player2 = findViewById(R.id.playerTwo);
        final Button startBtn = findViewById(R.id.startGame);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String playerOneName = player1.getText().toString();
                final String playerTwoName = player2.getText().toString();

                if(playerOneName.isEmpty() || playerTwoName.isEmpty()){
                    Toast.makeText(addPlayers.this,"Please enter the required names", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(addPlayers.this, MainActivity.class);
                    intent.putExtra("playerOne", playerOneName);
                    intent.putExtra("playerTwo", playerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}