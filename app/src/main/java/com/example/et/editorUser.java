package com.example.et;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class editorUser extends AppCompatActivity {

    private EditText edtNamaBarang, edtukuran, edttawaran, edtstatus;
    private Button btnSave;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_user);
        edtNamaBarang = findViewById(R.id.namaBarang);
        edtukuran = findViewById(R.id.ukuran);
        edttawaran = findViewById(R.id.tawaran);
        edtstatus = findViewById(R.id.status);
        btnSave = findViewById(R.id.btn_save);

        progressDialog = new ProgressDialog(editorUser.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Menyimpan...");

        btnSave.setOnClickListener(v->{
            if (edtNamaBarang.getText().length() > 0 && edtukuran.getText().length() > 0 && edttawaran.getText().length() > 0 && edtstatus.getText().length() > 0){

                saveData(edtNamaBarang.getText().toString(), edtukuran.getText().toString(), edttawaran.getText().toString(), edtstatus.getText().toString());
            }else {
                Toast.makeText(this, "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        if (intent!= null){
            id = intent.getStringExtra("id");
            edtNamaBarang.setText(intent.getStringExtra("namaBarang"));
            edtukuran.setText(intent.getStringExtra("ukuran"));
            edttawaran.setText(intent.getStringExtra("tawaran"));
            edtstatus.setText(intent.getStringExtra("status"));
        }
    }

    private void saveData(String namaBarang, String ukuran, String tawaran, String status) {
        Map<String, Object> user = new HashMap<>();
        user.put("namaBarang", namaBarang);
        user.put("ukuran", ukuran);
        user.put("tawaran", tawaran);
        user.put("status", status);

        progressDialog.show();

        if (id != null){

            db.collection("user").document(id)
                    .set(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(editorUser.this, "Berhasil", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(editorUser.this, "Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else {

            db.collection("user")
                    .add(user)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(editorUser.this, "Berhasil di simpan", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(editorUser.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
        }
    }
}