
package com.example.sudoku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {


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
            R.id.btn_9,
            R.id.btn_10,
            R.id.btn_11,
            R.id.btn_12,
            R.id.btn_13,
            R.id.btn_14,
            R.id.btn_15,
            R.id.btn_16,
            R.id.btn_17,
            R.id.btn_18,
            R.id.btn_19,
            R.id.btn_20,
            R.id.btn_21,
            R.id.btn_22,
            R.id.btn_23,
            R.id.btn_24,
            R.id.btn_25,
            R.id.btn_26,
            R.id.btn_27,
            R.id.btn_28,
            R.id.btn_29,
            R.id.btn_30,
            R.id.btn_31,
            R.id.btn_32,
            R.id.btn_33,
            R.id.btn_34,
            R.id.btn_35,
            R.id.btn_36,
            R.id.btn_37,
            R.id.btn_38,
            R.id.btn_39,
            R.id.btn_40,
            R.id.btn_41,
            R.id.btn_42,
            R.id.btn_43,
            R.id.btn_44,
            R.id.btn_45,
            R.id.btn_46,
            R.id.btn_47,
            R.id.btn_48,
            R.id.btn_49,
            R.id.btn_50,
            R.id.btn_51,
            R.id.btn_52,
            R.id.btn_53,
            R.id.btn_54,
            R.id.btn_55,
            R.id.btn_56,
            R.id.btn_57,
            R.id.btn_58,
            R.id.btn_59,
            R.id.btn_60,
            R.id.btn_61,
            R.id.btn_62,
            R.id.btn_63,
            R.id.btn_64,
            R.id.btn_65,
            R.id.btn_66,
            R.id.btn_67,
            R.id.btn_68,
            R.id.btn_69,
            R.id.btn_70,
            R.id.btn_71,
            R.id.btn_72,
            R.id.btn_73,
            R.id.btn_74,
            R.id.btn_75,
            R.id.btn_76,
            R.id.btn_77,
            R.id.btn_78,
            R.id.btn_79,
            R.id.btn_80,
            R.id.btn_81
    };
    int[][] level1 = {
            {0, 2, 6, 0, 9, 0, 8, 1, 5},
            {3, 0, 0, 0, 2, 8, 9, 4, 6},
            {4, 0, 9, 6, 0, 1, 2, 3, 0},
            {8, 0, 2, 1, 0, 7, 6, 0, 3},
            {6, 7, 0, 9, 8, 0, 1, 0, 4},
            {9, 0, 1, 3, 0, 2, 7, 0, 8},
            {1, 0, 4, 8, 3, 0, 5, 7, 0},
            {5, 0, 0, 2, 1, 4, 3, 0, 9},
            {2, 3, 0, 5, 7, 0, 4, 6, 0}
    };
    int[][] level11 = {
            {7, 2, 6, 4, 9, 3, 8, 1, 5},
            {3, 1, 5, 7, 2, 8, 9, 4, 6},
            {4, 8, 9, 6, 5, 1, 2, 3, 7},
            {8, 5, 2, 1, 4, 7, 6, 9, 3},
            {6, 7, 3, 9, 8, 5, 1, 2, 4},
            {9, 4, 1, 3, 6, 2, 7, 5, 8},
            {1, 9, 4, 8, 3, 6, 5, 7, 2},
            {5, 6, 7, 2, 1, 4, 3, 8, 9},
            {2, 3, 8, 5, 7, 9, 4, 6, 1}
    };
    private List<Button> buttonEnterNumber;
    int[] buttonIdEnterNumber = {
            R.id.a1,
            R.id.a2,
            R.id.a3,
            R.id.a4,
            R.id.a5,
            R.id.a6,
            R.id.a7,
            R.id.a8,
            R.id.a9
    };
    int totalRow = 45;
    String numberChoose = "";

    Button summit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        summit = findViewById(R.id.submit);
        //add button array
        buttons = new ArrayList<Button>();
        for (int i = 0; i < buttonId.length; i++) {
            Button button = findViewById(buttonId[i]);
            buttons.add(button);
        }

        buttonEnterNumber = new ArrayList<Button>();
        for (int i = 0; i < buttonIdEnterNumber.length; i++) {
            Button button = findViewById(buttonIdEnterNumber[i]);
            buttonEnterNumber.add(button);
        }

        //display fixed array
        int count = 0;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                buttons.get(count).setText(String.valueOf(level1[j][i]));
                setBackgroundColorFixArray(buttons.get(count));
                count++;
            }
        }

        //set value
        for (int i = 0; i < buttons.size(); i++) {
            setValue(buttons.get(i));
        }

//        int countNumber=0;

        for (int i = 0; i < buttonEnterNumber.size(); i++) {
            final int finalI = i;
            buttonEnterNumber.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberChoose = buttonEnterNumber.get(finalI).getText().toString();
                }
            });
        }

        summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
                Log.i("thaothao", String.valueOf(checkWin(getArrayAnsware())));
            }
        });
    }

    int[][] getArrayAnsware() {
        int[][] arrResult = new int[9][9];
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                int value = parseInt(buttons.get(j * 9 + i).getText().toString());
                arrResult[i][j] = value;
            }
        }
        return arrResult;
    }

    void setValue(final Button button) {
        if (checkValueButtonFixed(button) == false) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button.setText(numberChoose);
                }
            });
        }
    }

    boolean checkValueButtonFixed(Button button) {
        if (!button.getText().equals("0")) {
            return true;
        }
        return false;
    }

    //set background
    void setBackgroundColorFixArray(Button button) {
        if (checkValueButtonFixed(button) == true) {
            button.setBackgroundResource(R.drawable.button);
        }
    }

    boolean checkWin(int array[][]) {
        if (checkHorizontal(array) == true) {
            if (checkVirtical(array) == true) {
                if (checkSquare(array) == true) {
                    return true;
                }
            }
        }
        return false;

    }

    boolean checkHorizontal(int array[][]) {
        for (int i = 0; i < 9; i++) {
            int virtical = 0;
            for (int j = 0; j < 9; j++) {

                virtical += array[j][i];
            }
            if (virtical != totalRow) {
                return false;
            }
        }
        return true;
    }

    boolean checkVirtical(int array[][]) {
        for (int i = 0; i < 9; i++) {
            int horizontal = 0;
            for (int j = 0; j < 9; j++) {

                horizontal += array[i][j];
            }
            if (horizontal != totalRow) {
                return false;
            }
        }
        return true;
    }

    boolean checkSquare(int array[][]) {
        int beginj = 0;
        int endj = 3;
        while (endj <= 9) {
            int square = 0;
            int begini = 0;
            int endi = 3;
            while (endi <= 9) {
                int totalSquare = 0;
                for (int i = begini; i < endi; i++) {
                    for (int j = beginj; j < endj; j++) {
                        totalSquare += array[i][j];
                    }
                }
                if (totalSquare != totalRow) {
                    return false;
                }
                begini = endi;
                endi += 3;
            }
            beginj = endj;
            endj += 3;
        }
        return true;
    }

    private void showAlert(){
        if(checkWin(getArrayAnsware())==true){
            new AlertDialog.Builder(MainActivity.this).setTitle("Win").setMessage("You are winner!").show();
        }
        else {
            new AlertDialog.Builder(MainActivity.this).setTitle("Loser").setMessage("Unlucky! Please, try again.").show();
        }
    }
}