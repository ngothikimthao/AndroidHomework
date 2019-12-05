package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvnumber = findViewById(R.id.recycler_number);
        rvnumber.setLayoutManager(new LinearLayoutManager(this));
        final List<String> data1 = new ArrayList<>();
        for(int i=0; i< 10; i++){
            data1.add("thao");
            data1.add("thuong");
            data1.add("ti");
        }
        final NumberAdapter adpter = new NumberAdapter();
        adpter.data=data1;
        rvnumber.setAdapter(adpter);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data1.add("New student");
                adpter.notifyDataSetChanged();
            }
        });

    }
}
