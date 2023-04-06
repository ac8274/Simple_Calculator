package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Credits extends AppCompatActivity {

    private Intent gi;
    private Button button_back;
    private TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        edit = findViewById(R.id.textView);
        button_back = findViewById(R.id.button_back);
        gi = getIntent();
        String ans = gi.getStringExtra("n");
        edit.setText("Last result was: "+ans);
    }

    public void End(View view) {
        finish();
    }
}