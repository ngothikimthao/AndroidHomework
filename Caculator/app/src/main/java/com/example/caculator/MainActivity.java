package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {

    TextView result;
    Button btn_equal;
    private List<Button> buttons;
    private int buttonId[] = {
            R.id.btn_1,
            R.id.btn_2,
            R.id.btn_3,
            R.id.btn_4,
            R.id.btn_5,
            R.id.btn_6,
            R.id.btn_7,
            R.id.btn_8,
            R.id.btn_8,
            R.id.btn_9,
            R.id.btn_minus,
            R.id.btn_plus,
            R.id.btn_div,
            R.id.btn_multi
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons = new ArrayList<Button>();

        for(int i=0; i<buttonId.length; i++){
            Button button = findViewById(buttonId[i]);
            buttons.add(button);
        }
        for(int j =0; j<buttons.size();j++){
            setNumString(buttons.get(j));
        }
        result = findViewById(R.id.result);
        btn_equal = findViewById(R.id.equals);
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= String.valueOf(caculator(result.getText().toString()));
                result.setText(value);
            }
        });
    }
    void setNumString(final Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+ button.getText().toString() + " ");
            }
        });
    }
    int caculator(String numberString){

        String arr[] = numberString.split(" ");

        int result1 = parseInt(String.valueOf(arr[0]));

        for(int i=1;i<arr.length;i+=2){
            if(arr[i].equals("+")){
                result1 += parseInt(arr[i+1]);
            }
            if(arr[i].equals("-")){
                result1 -= parseInt(arr[i+1]);
            }
            if(arr[i].equals("*")){
                result1 *= parseInt(arr[i+1]);
            }
            if(arr[i].equals("/")){
                result1 /= parseInt(arr[i+1]);
            }
        }

        return result1;
    }

}
