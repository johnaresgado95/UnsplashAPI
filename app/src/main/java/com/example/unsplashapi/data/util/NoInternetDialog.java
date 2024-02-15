package com.example.unsplashapi.data.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.unsplashapi.R;

public class NoInternetDialog extends Dialog {

    public String message;
    public Activity activity;
    public Button okay;
    public TextView mMessage;

    public NoInternetDialog(Activity activity, String message) {
        super(activity);
        this.message = message;
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_error);
        okay = findViewById(R.id.okButton);
        mMessage = findViewById(R.id.errorMessage);
        mMessage.setText(message);
        okay.setOnClickListener(view -> {
            activity.finish();
        });
    }
}