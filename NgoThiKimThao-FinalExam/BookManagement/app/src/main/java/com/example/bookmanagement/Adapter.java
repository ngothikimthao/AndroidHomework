package com.example.bookmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.BookAdapter> {

    List<Book> bookList;
    OnItemListener listener;
    @NonNull
    @Override
    public BookAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new BookAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter holder, int position) {
        holder.name.setText(bookList.get(position).name);
        holder.releaseYear.setText(bookList.get(position).releaseYear);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BookAdapter extends RecyclerView.ViewHolder{
        ImageButton btn_delete;
        ImageButton btn_update;
        TextView name;
        TextView releaseYear;
        public BookAdapter(@NonNull View itemView) {
            super(itemView);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_update = itemView.findViewById(R.id.btn_update);
            name = itemView.findViewById(R.id.name);
            releaseYear = itemView.findViewById(R.id.realeaseYear);
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDeleteClicked(getAdapterPosition());
                }
            });
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onUpdateClicked(getAdapterPosition());
                }
            });
        }
    }
    interface OnItemListener {
        void onDeleteClicked(int position);
        void onUpdateClicked(int position);
    }
}
