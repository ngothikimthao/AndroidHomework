package com.example.bookmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import static java.lang.Integer.parseInt;

public class UpdateActivity extends AppCompatActivity {
    AppDatabase db;
    Button button_update;
    EditText update_name, update_releaseYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        String name = getIntent().getStringExtra("name");
        String releaseYear = getIntent().getStringExtra("releaseYear");
        update_name=findViewById(R.id.update_name);
        update_releaseYear=findViewById(R.id.update_releaseYear);

        update_name.setText(name);
        update_releaseYear.setText(releaseYear);

        button_update=findViewById(R.id.button_update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                openMainScreen();
            }
        });
    }
    private void update() {
        final String name = update_name.getText().toString();
        final String releaseYear = update_releaseYear.getText().toString();
        final String id = getIntent().getStringExtra("id");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Book book = new Book(name, releaseYear);
                book.setId(parseInt(id));
                db.BookDao().update(book);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }
    public void openMainScreen(){
        Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
