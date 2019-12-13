package com.example.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_register;
    Button button_login;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_register = findViewById(R.id.button_register);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToat();
            }
        });
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        button_login = findViewById(R.id.login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(checkLogin(user, pass)==true){
                    openHomeScreen(user,pass);
                }

            }
        });

    }

    void showToat() {
        Toast.makeText(getApplicationContext(), "Register", Toast.LENGTH_SHORT).show();
    }

    boolean checkLogin(String user, String pass) {
        if (user.equals("admin") && pass.equals("admin")) {
            Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    private void openHomeScreen(String email, String pass) {
        Intent intent = new Intent(getBaseContext(), AcivityScreen.class);
        intent.putExtra("email", email);
        intent.putExtra("pass", pass);
        startActivity(intent);

    }
}
