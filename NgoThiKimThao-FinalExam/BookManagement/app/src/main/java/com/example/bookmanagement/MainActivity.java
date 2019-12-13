package com.example.bookmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    Button button_add;
    List<Book> listbooks;
    RecyclerView books;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        display();
        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddScreen();
            }
        });
        books=findViewById(R.id.recycler_item);
        books.setLayoutManager(new LinearLayoutManager(this));
        books.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new Adapter();
        adapter.listener = new Adapter.OnItemListener(){

            @Override
            public void onDeleteClicked(int position) {
               delete(position);
            }
            @Override
            public void onUpdateClicked(int position) {
                openUpdateScreen(adapter.bookList.get(position));
            }
        };


        books.setAdapter(adapter);

    }
    private void openAddScreen(){
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
    public void display(){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                listbooks=db.BookDao().getAll();
                adapter.bookList=listbooks;
                return null;
            }
        }.execute();
    }
    public void delete(final int position) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.BookDao().delete(adapter.bookList.get(position));
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.bookList.remove(position);
                adapter.notifyDataSetChanged();
                super.onPostExecute(aVoid);
            }
        }.execute();
    }
    private void openUpdateScreen(Book book){
        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
        intent.putExtra("id", String.valueOf(book.getId()));
        intent.putExtra("name", book.getnName());
        intent.putExtra("releaseYear", book.getnReleaseYear());
        startActivity(intent);
    }
}
