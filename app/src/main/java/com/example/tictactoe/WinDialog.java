package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tictactoe.databinding.WinDialogContainerBinding;

public class WinDialog extends Dialog {

    private WinDialogContainerBinding binding;
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
        binding = WinDialogContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
