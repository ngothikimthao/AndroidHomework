package com.example.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.UserAdapter> {

    List<User> userList;
    OnItemListener listener;
    @NonNull
    @Override
    public UserAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new UserAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter holder, int position) {
        holder.name.setText(userList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserAdapter extends RecyclerView.ViewHolder{
        ImageButton btn_delete;
        ImageButton btn_update;
        TextView name;
        public UserAdapter(@NonNull View itemView) {
            super(itemView);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_update = itemView.findViewById(R.id.btn_update);
            name = itemView.findViewById(R.id.name);
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDeleteClicked(getAdapterPosition());
                }
            });
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onUpdateClicked();
                }
            });
        }
    }
    interface OnItemListener {
        void onDeleteClicked(int position);
        void onUpdateClicked();
    }
}
