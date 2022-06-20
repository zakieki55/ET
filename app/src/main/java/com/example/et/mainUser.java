package com.example.et;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.example.et.adapter.userAdapter;
import com.example.et.model.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class mainUser extends AppCompatActivity {

    private RecyclerView recyclerView;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private List<user> list = new ArrayList<>();
    private userAdapter UserAdapter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        recyclerView = findViewById(R.id.recycler_view);

        progressDialog = new ProgressDialog(mainUser.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Mengambil Data...");
        UserAdapter = new userAdapter(getApplicationContext(), list);
        UserAdapter.setDialog(new userAdapter.Dialog() {

            @Override
            public void onClick(int pos) {
                final CharSequence[] dialogItem = {"Batalkan Pesanan"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(mainUser.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){

                            case 0:
                                deleteData(list.get(pos).getId());
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(UserAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    private void getData(){
        progressDialog.show();
        db.collection("user")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                user User = new user(document.getString("namaBarang"), document.getString("ukuran"), document.getString("tawaran"), document.getString("status"));
                                User.setId(document.getId());
                                list.add(User);
                            }
                            UserAdapter.notifyDataSetChanged();
                        }else {
                            Toast.makeText(getApplicationContext(), "Data gagal di ambil!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void deleteData(String id) {
        progressDialog.show();
        db.collection("user").document(id)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Data gagal di hapus!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                        getData();
                    }
                });
    }
}