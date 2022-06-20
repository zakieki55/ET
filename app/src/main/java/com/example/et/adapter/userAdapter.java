package com.example.et.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.et.R;
import com.example.et.model.user;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.MyViewHolder>{
    private Context context;
    private List<user> list;
    private userAdapter.Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }

    public void setDialog(userAdapter.Dialog dialog) {
        this.dialog = dialog;
    }

    public userAdapter(Context context, List<user> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public userAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new userAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull userAdapter.MyViewHolder holder, int position) {
        holder.namaBarang.setText(list.get(position).getNamaBarang());
        holder.ukuran.setText(list.get(position).getUkuran());
        holder.tawaran.setText(list.get(position).getTawaran());
        holder.status.setText(list.get(position).getStatus());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namaBarang ,ukuran, tawaran, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaBarang = itemView.findViewById(R.id.namaBarang);
            ukuran = itemView.findViewById(R.id.ukuran);
            tawaran = itemView.findViewById(R.id.tawaran);
            status = itemView.findViewById(R.id.status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
