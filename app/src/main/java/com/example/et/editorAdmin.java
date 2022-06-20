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

public class editorAdmin extends AppCompatActivity {

    private EditText edtNamaBarang, edtukuran, edtsetHarga;
    private Button btnSave;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_admin);
        edtNamaBarang = findViewById(R.id.namaBarang);
        edtukuran = findViewById(R.id.ukuran);
        edtsetHarga = findViewById(R.id.setHarga);
        btnSave = findViewById(R.id.btn_save);

        progressDialog = new ProgressDialog(editorAdmin.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Menyimpan...");

        btnSave.setOnClickListener(v->{
            if (edtNamaBarang.getText().length() > 0 && edtukuran.getText().length() > 0 && edtsetHarga.getText().length() > 0){

                saveData(edtNamaBarang.getText().toString(), edtukuran.getText().toString(), edtsetHarga.getText().toString());
            }else {
                Toast.makeText(this, "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        if (intent!= null){
            id = intent.getStringExtra("id");
            edtNamaBarang.setText(intent.getStringExtra("namaBarang"));
            edtukuran.setText(intent.getStringExtra("ukuran"));
            edtsetHarga.setText(intent.getStringExtra("setHarga"));
        }
    }

    private void saveData(String namaBarang, String ukuran, String setHarga) {
        Map<String, Object> user = new HashMap<>();
        user.put("namaBarang", namaBarang);
        user.put("ukuran", ukuran);
        user.put("setHarga", setHarga);

        progressDialog.show();

        if (id != null){

            db.collection("admin").document(id)
                    .set(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(editorAdmin.this, "Berhasil", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(editorAdmin.this, "Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else {

            db.collection("admin")
                    .add(user)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(editorAdmin.this, "Berhasil di simpan", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(editorAdmin.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
        }
    }
}