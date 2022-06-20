package com.example.et.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.et.R;
import com.example.et.model.admin;

import java.util.List;

public class adminAdapter extends RecyclerView.Adapter<adminAdapter.MyViewHolder> {
    private Context context;
    private List<admin> list;
    private adminAdapter.Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }

    public void setDialog(adminAdapter.Dialog dialog) {
        this.dialog = dialog;
    }

    public adminAdapter(Context context, List<admin> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public adminAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_admin, parent, false);
        return new adminAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull adminAdapter.MyViewHolder holder, int position) {
        holder.namaBarang.setText(list.get(position).getNamaBarang());
        holder.ukuran.setText(list.get(position).getUkuran());
        holder.setHarga.setText(list.get(position).getSetHarga());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namaBarang ,ukuran, setHarga;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaBarang = itemView.findViewById(R.id.namaBarang);
            ukuran = itemView.findViewById(R.id.ukuran);
            setHarga = itemView.findViewById(R.id.setHarga);
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
