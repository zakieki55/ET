package com.example.et;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class adminLogin extends AppCompatActivity {

    FloatingActionButton Btnclose;
    Button btnLogin, btnregist;
    EditText txtemail, txtpass;
    String email, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        btnLogin = findViewById(R.id.btn1a);
        btnregist = findViewById(R.id.btnrega);
        txtemail = findViewById(R.id.txtemail1a);
        txtpass = findViewById(R.id.txtpassword1a);
        Btnclose = findViewById(R.id.btnclose);


        Btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1 = new Intent(getApplicationContext(), first.class);

                startActivity(a1);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txtemail.getText().toString();
                pw = txtpass.getText().toString();

                String em = "admin";
                String ps = "123";

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

                        Intent i = new Intent(getApplicationContext(), menuAdmin.class);

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
        });

        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle c = new Bundle();

                Intent a = new Intent(getApplicationContext(),adminRegister.class);
                startActivity(a);
            }
        });}
}