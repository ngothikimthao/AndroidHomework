package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                User user1 = new User("Thao");
                db.userDao().insert(user1);

               final List<User> users; users=db.userDao().getAll();
                Log.i("size", String.valueOf(users.size()));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        display(users);
                    }
                });

                return null;
            }
        }.execute();
    }


    public void display(List<User> users){
        User user = users.get(1);
        String a="";
        for(int i=0;i<users.size();i++){
            a += users.get(i).name + "\n";
        }
        textView = findViewById(R.id.user);
        textView.setText(a);
    }
}
