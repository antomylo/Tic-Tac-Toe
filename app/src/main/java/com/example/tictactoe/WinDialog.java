package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private String message;
    private MainActivity mainActivity;

    public WinDialog(@NonNull Context context, String s, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = this.mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog_container);

        final TextView messageTxt = findViewById(R.id.messageText);
        final Button startAgainBtn = findViewById(R.id.startAgainBtn);

        messageTxt.setText(message);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
