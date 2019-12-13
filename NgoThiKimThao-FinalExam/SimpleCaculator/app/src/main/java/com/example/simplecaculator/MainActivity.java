package com.example.simplecaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    EditText number3;
    TextView result;
    Button button_sum;
    Button button_average;
    Button button_multiple;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        number3=findViewById(R.id.number3);


        button_sum= findViewById(R.id.button_sum);
        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valueNumber1 = parseInt(number1.getText().toString());
                float valueNumber2 = parseInt(number2.getText().toString());
                float valueNumber3 = parseInt(number3.getText().toString());

                result.setText(String.valueOf(sum(valueNumber1,valueNumber2,valueNumber3)));
            }
        });

        button_average= findViewById(R.id.button_average);
        button_average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valueNumber1 = parseInt(number1.getText().toString());
                float valueNumber2 = parseInt(number2.getText().toString());
                float valueNumber3 = parseInt(number3.getText().toString());
                result.setText(String.valueOf(average(valueNumber1,valueNumber2,valueNumber3)));
            }
        });
        button_multiple= findViewById(R.id.button_multiple);
        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valueNumber1 = parseInt(number1.getText().toString());
                float valueNumber2 = parseInt(number2.getText().toString());
                float valueNumber3 = parseInt(number3.getText().toString());
                result.setText(String.valueOf(multiple(valueNumber1,valueNumber2,valueNumber3)));
            }
        });

    }

    float sum(float num1, float num2, float num3){
        return num1 + num2 + num3;
    }

    float multiple(float num1, float num2, float num3){
        return num1 * num2 * num3;
    }

    float average(float num1, float num2, float num3){
        return (num1 + num2 + num3)/3;
    }

}
