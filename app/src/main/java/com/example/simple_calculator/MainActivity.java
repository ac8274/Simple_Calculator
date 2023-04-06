package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Double last_try = 0.0;
    private EditText input;
    private Button button_plus;
    private Button button_minus;
    private Button button_multiply;
    private Button button_divide;
    private Button button_clear;
    private Button button_result;
    private Button button_last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        button_clear = findViewById(R.id.button_clear);
        button_result = findViewById(R.id.button_result);
        button_last = findViewById(R.id.button_last);
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_multiply = findViewById(R.id.button_multiply);
        button_divide = findViewById(R.id.button_divide);
    }

    public void add_plus(View view) {
        if(input.getText().toString().length()!=0 &&!char_last()) {
            String text = (String) input.getText().toString() + "+";
            input.setText(text);
        }
    }
    public boolean char_last()
    {
        String text = (String) input.getText().toString();
        return text.charAt(text.length()-1) == '+'||text.charAt(text.length()-1) == '-'||text.charAt(text.length()-1) == '*'||text.charAt(text.length()-1) == '/';
    }

    public void add_minus(View view) {
        if(input.getText().toString().length()!=0 &&!char_last()) {
            String text = (String) input.getText().toString() + "-";
            input.setText(text);
        }
    }

    public void add_devide(View view) {
        if(input.getText().toString().length()!=0 &&!char_last()) {
            String text = (String) input.getText().toString() + "/";
            input.setText(text);
        }
    }

    public void add_multiply(View view) {
        if(input.getText().toString().length()!=0 &&!char_last()) {
            String text = input.getText().toString() + "*";
            input.setText(text);
        }
    }

    public void clear(View view) {
        input.setText("0");
    }

    public void put_resualt(View view) {

        String calc = (String) input.getText().toString();
        try {
            String replaced = calc.replaceAll("-", "+-'");
            String [] replaced2 = replaced.split("\\+");
            double m = 0.0;
            Double k =0.0;
            for(int i = 0; i<replaced2.length;i++)
            {
                String [] x = replaced2[i].split("\\*");
                int prod = 1;
                for (int g=0; g<x.length;g++)
                {
                    if (x[g].contains("/"))
                    {
                        String [] a = x[g].split("/");
                        k = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                    }
                    else if(x[g].contains("-"))
                    {
                        String [] a = x[g].split("-'");
                        k = Double.parseDouble(a[1]);
                        k *= -1;
                    }
                    else
                    {
                        k = Double.parseDouble(x[g]);
                    }
                    prod *= k;
                }

                m += prod;
            }
            last_try = m;
            input.setText(last_try.toString());
        }
        catch (Exception e)
        {
            input.setText("Error");
        }
    }

    public void next_activity(View view) {
        Intent si = new Intent(this,Credits.class);
        si.putExtra("n",last_try.toString());
        startActivity(si);
    }
}