package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgage = findViewById(R.id.img);

        imgage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchPage();
            }
        });

    }

    public void SwitchPage(){
        Intent intentGame = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intentGame);
    }
}
