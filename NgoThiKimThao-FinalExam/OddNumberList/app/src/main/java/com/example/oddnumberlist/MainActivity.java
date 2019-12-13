package com.example.oddnumberlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNumber = findViewById(R.id.recycle_Number);

        rvNumber.setLayoutManager(new LinearLayoutManager(this));

        final List<String> data1 = new ArrayList<>();
        int i = 3;
        while (data1.size() < 1000) {
            data1.add("" + i);
            i += 2;
        }

        final NumberAdapter adapter = new NumberAdapter();
        adapter.data = data1;
        rvNumber.setAdapter(adapter);

    }
}
