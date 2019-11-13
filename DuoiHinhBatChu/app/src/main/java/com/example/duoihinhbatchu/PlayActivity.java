package com.example.duoihinhbatchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Random;


public class PlayActivity extends AppCompatActivity {
    ImageView image;

    int [] imgPuzzle = {
            R.drawable.bahoa,
            R.drawable.baocao,
            R.drawable.cadao,
            R.drawable.cungcau
    };
    String[] answerPuzzle = {
            "bahoa","baocao","cadao", "cungcau"
    };
    int count=0;
    String result="";
    String result1="baocao";
    private List<Button> buttons;
    private List<Button> buttonsR;
    private int buttonId[] = {
            R.id.btn_1,
            R.id.btn_2,
            R.id.btn_3,
            R.id.btn_4,
            R.id.btn_5,
            R.id.btn_6,
            R.id.btn_7,
            R.id.btn_8,
            R.id.btn_9,
            R.id.btn_r1,
            R.id.btn_r2,
            R.id.btn_r3,
            R.id.btn_r4,
            R.id.btn_r5,
            R.id.btn_r6
    };
    private int buttonIdR[] = {
            R.id.btn_r1,
            R.id.btn_r2,
            R.id.btn_r3,
            R.id.btn_r4,
            R.id.btn_r5,
            R.id.btn_r6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        image = findViewById(R.id.image);
        image.setImageResource(R.drawable.img);

        buttons = new ArrayList<Button>();
        buttonsR = new ArrayList<Button>();

        for(int i=0; i<buttonId.length; i++){
            Button button = findViewById(buttonId[i]);
            buttons.add(button);
        }
        for(int i=0; i<buttonIdR.length; i++){
            Button button = findViewById(buttonIdR[i]);
            buttonsR.add(button);
        }

        for(int j=0;j<buttons.size();j++){
            final Button btn_answer = buttons.get(j);
            btn_answer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Button btn_result =buttonsR.get(count);
                    btn_result.setText(btn_answer.getText());
                    count++;
                    result+=btn_answer.getText();
                    if(result.equals(result1)){
                        Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                    }
                    if(result.length()==result1.length()&& !result.equals(result1)){
                        Toast.makeText(getApplicationContext(), "You lose", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        image.setImageResource(R.drawable.baocao);
        display(result1);
        checkWin();
    }

    void display(String puzzle){
        int numberCharacterWrong = 9 - puzzle.length();
        String character = puzzle+RandomString(numberCharacterWrong);
        String characterShffle = shuffle(character);

        for(int i = 0; i<characterShffle.length();i++){
            buttons.get(i).setText(String.valueOf(characterShffle.charAt(i)));
        }

        for(int j=0;j<6;j++){

        }
    }

    public String RandomString(int numberCharacter) {
        String sb="";
        String[] character = {"a","b","c","d","e","f","g","h","i","k","l","m","n"};
        Random rd = new Random();

        for (int i = 0; i < numberCharacter; i++) {
            int index = rd.nextInt(13);
            sb+= character[index];
        }

        return sb;
    }


    public String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    void checkWin(){
        Log.i("aaaa",String.valueOf(result));
        Log.i("bbbbbb",String.valueOf(result1));
        if(result.length()==result1.length()){
            if(result1.equals(result)){
                Log.i("thao",result);
            }
            else {
                Log.i("thao2",result1);
            }
        }

    }
//
//    public void mess(){
//        Toast toast = Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT);
//        toast.show();
//    }


}
