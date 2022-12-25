package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tictactoe.databinding.ActivityAddPlayersBinding;

public class AddPlayers extends AppCompatActivity {

    private ActivityAddPlayersBinding binding;
    public static final String TAG = "AddPlayers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlayersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startGame.setOnClickListener(view -> {
            Log.d(TAG, "onCreate: button clicked");
            final String playerOneName = binding.playerOneName.getText().toString();
            final String playerTwoName = binding.playerTwoName.getText().toString();

            if (playerOneName.isBlank() || playerTwoName.isBlank()) {
                Toast.makeText(getApplicationContext(), "Names fields cannot be empty!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                intent.putExtra("playerOne", playerOneName);
                intent.putExtra("playerTwo", playerTwoName);
                startActivity(intent);
            }
        });
    }
}