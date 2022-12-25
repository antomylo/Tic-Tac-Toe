package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tictactoe.databinding.ActivityAddPlayersBinding;

public class AddPlayers extends AppCompatActivity {

    private ActivityAddPlayersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        binding = ActivityAddPlayersBinding.inflate(getLayoutInflater());

        final EditText player1 = binding.playerOneName;
        final EditText player2 = binding.playerTwoName;
        final Button startBtn = binding.startGame;

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String playerOneName = player1.getText().toString();
                final String playerTwoName = player2.getText().toString();

                if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "Please enter the required names", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("playerOne", playerOneName);
                    intent.putExtra("playerTwo", playerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}