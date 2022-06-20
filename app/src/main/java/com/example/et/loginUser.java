package com.example.et;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class loginUser extends AppCompatActivity {

    FloatingActionButton Btnclose1;
    Button btnLoginu, btnregistu;
    EditText txtemailu, txtpassu;
    String email, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        btnLoginu = findViewById(R.id.btn1u);
        btnregistu = findViewById(R.id.btnregu);
        txtemailu = findViewById(R.id.txtemail1u);
        txtpassu = findViewById(R.id.txtpassword1u);
        Btnclose1 = findViewById(R.id.btnclose1);

        Btnclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(getApplicationContext(), first.class);

                startActivity(b1);

            }
        });
        btnLoginu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txtemailu.getText().toString();
                pw = txtpassu.getText().toString();

                String em = "user";
                String ps = "456";

                if(email.isEmpty()|| pw.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password anda wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    if(email.equals(em) && pw.equals(ps)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);

                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", email.trim());

                        b.putString("b", pw.trim());

                        Intent i = new Intent(getApplicationContext(), menuUser.class);

                        i.putExtras(b);

                        startActivity(i);
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login gagal", Toast.LENGTH_LONG);

                        t.show();
                    }
                }
            };
        }); btnregistu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle c = new Bundle();

                Intent a = new Intent(getApplicationContext(),registerUser.class);
                startActivity(a);
            }
        });}

}