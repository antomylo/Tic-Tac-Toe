package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<int[]> combinations = new ArrayList<>();

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int playerTurn;
    private int totalSelectedBoxes;

    private TextView player1Name, player2Name;
    private LinearLayout player1Layout, player2Layout;

    private ImageView img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8, img_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView player1Name = findViewById(R.id.playerOneName);
        TextView player2Name = findViewById(R.id.playerTwoName);

        LinearLayout player1Layout = findViewById(R.id.playerOneLayout);
        LinearLayout player2Layout = findViewById(R.id.playerTwoLayout);

        ImageView img_1 = findViewById(R.id.img_1);
        ImageView img_2 = findViewById(R.id.img_2);
        ImageView img_3 = findViewById(R.id.img_3);
        ImageView img_4 = findViewById(R.id.img_4);
        ImageView img_5 = findViewById(R.id.img_5);
        ImageView img_6 = findViewById(R.id.img_6);
        ImageView img_7 = findViewById(R.id.img_7);
        ImageView img_8 = findViewById(R.id.img_8);
        ImageView img_9 = findViewById(R.id.img_9);

        combinations.add(new int[]{0, 1, 2});
        combinations.add(new int[]{3, 4, 5});
        combinations.add(new int[]{6, 7, 8});
        combinations.add(new int[]{0, 3, 6});
        combinations.add(new int[]{1, 4, 7});
        combinations.add(new int[]{2, 5, 8});
        combinations.add(new int[]{0, 4, 8});
        combinations.add(new int[]{2, 4, 6});

        final String getPLayer1Name = getIntent().getStringExtra("playerOne");
        final String getPlayer2Name = getIntent().getStringExtra("playerTwo");

        player1Name.setText(getPLayer1Name);
        player2Name.setText(getPlayer2Name);

        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){

                }
            }
        });

        img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){

                }
            }
        });

        img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2));
            }
        });

        img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                }
            }
        });

        img_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){

                }
            }
        });

        img_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){

                }
            }
        });

        img_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){

                }
            }
        });

        img_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){

                }
            }
        });

        img_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){

                }
            }
        });
    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.close);

            if (checkPlayerWin()) {
                WinDialog winDialog = new WinDialog(MainActivity.this, player1Name.getText().toString() + " has won the game", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (totalSelectedBoxes == 9) {
                WinDialog winDialog = new WinDialog(MainActivity.this, "It is a Draw!", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.zero);

            if (checkPlayerWin()) {
                WinDialog winDialog = new WinDialog(MainActivity.this, player2Name.getText().toString() + " has won the game", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if ( ==9 ){
                WinDialog winDialog = new WinDialog(MainActivity.this, "It is a Draw!", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else{
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }

    }

    private boolean checkPlayerWin() {
        boolean response = false;

        for (int i = 0; i < combinations.size(); i++) {
            final int[] combination = combinations.get(i);
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;

        if(boxPositions[boxPosition] == 0){
            response = true;
        }
        return response;
    }

    private boolean changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;

        if (playerTurn == 1) {
            player1Layout.setBackgroundResource(R.drawable.rounded_blue_borders);
            player2Layout.setBackgroundResource(R.drawable.round_back_dark_blue);
        } else {
            player2Layout.setBackgroundResource(R.drawable.rounded_blue_borders);
            player1Layout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
    }



}
