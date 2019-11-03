package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    int count = 0;
    TextView textViewResult;
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
            R.id.btn_9
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttons = new ArrayList<Button>();

        for(int i=0; i<buttonId.length; i++){
            Button button = findViewById(buttonId[i]);
            buttons.add(button);
        }
        for(int j =0; j<buttons.size();j++){
            setPlayButton(buttons.get(j));
        }
    }

    void setPlayButton(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(button);
            }
        });
    }

    void setXO(Button button) {
        if (count % 2 == 0)
            button.setText("X");
        else
            button.setText("O");
    }

    void play(Button button) {
        count++;
        setXO(button);

        checkWinXO(buttons.get(0), buttons.get(1), buttons.get(2), "X");
        checkWinXO(buttons.get(3), buttons.get(4), buttons.get(5), "X");
        checkWinXO(buttons.get(6), buttons.get(7), buttons.get(8), "X");
        checkWinXO(buttons.get(0), buttons.get(3), buttons.get(6), "X");
        checkWinXO(buttons.get(1), buttons.get(4), buttons.get(7), "X");
        checkWinXO(buttons.get(2), buttons.get(5), buttons.get(8), "X");
        checkWinXO(buttons.get(0), buttons.get(4), buttons.get(8), "X");
        checkWinXO(buttons.get(2), buttons.get(4), buttons.get(6), "X");


        checkWinXO(buttons.get(0), buttons.get(1), buttons.get(2), "O");
        checkWinXO(buttons.get(3), buttons.get(4), buttons.get(5), "O");
        checkWinXO(buttons.get(6), buttons.get(7), buttons.get(8), "O");
        checkWinXO(buttons.get(0), buttons.get(3), buttons.get(6), "O");
        checkWinXO(buttons.get(1), buttons.get(4), buttons.get(7), "O");
        checkWinXO(buttons.get(2), buttons.get(5), buttons.get(8), "O");
        checkWinXO(buttons.get(0), buttons.get(4), buttons.get(8), "O");
        checkWinXO(buttons.get(2), buttons.get(4), buttons.get(6), "O");

    }

    void checkWinXO(Button button1, Button button2, Button button3, String XorO) {
        if (button1.getText() == XorO && button2.getText() == XorO && button3.getText() == XorO) {
            textViewResult = findViewById(R.id.result);
            textViewResult.setText(XorO + " is winner");
        }
    }

}