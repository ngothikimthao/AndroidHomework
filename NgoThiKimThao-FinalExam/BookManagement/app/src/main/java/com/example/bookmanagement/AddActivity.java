package com.example.bookmanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Button btn_save;
    EditText edit_name, edit_releaseYear;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        edit_name = findViewById(R.id.edit_name);
        edit_releaseYear=findViewById(R.id.edit_releaseYear);
        btn_save=findViewById(R.id.button_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToDatabase();
                openMainScreen();
            }
        });

    }
    public void openMainScreen(){
        Intent intent = new Intent(AddActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void addItemToDatabase() {
        final String name = edit_name.getText().toString();
        final String releaseYear = edit_releaseYear.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Title must not null", Toast.LENGTH_SHORT).show();
            return;
        }

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                Book book = new Book(name, releaseYear);
                db.BookDao().insert(book);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(AddActivity.this, "New item added", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

}
