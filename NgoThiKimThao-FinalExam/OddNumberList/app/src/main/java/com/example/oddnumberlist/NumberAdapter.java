package com.example.oddnumberlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oddnumberlist.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    List<String> data = new ArrayList<>();
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);

        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.tvTitle.setText( data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder{


        TextView tvTitle;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.number);
        }
    }
}
