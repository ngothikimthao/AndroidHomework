package com.example.duoihinhbatchu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btn_play);
        play.setImageResource(R.drawable.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayScreen();
            }
        });

    }

    public void openPlayScreen(){
        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
        startActivity(intent);
    }


}
