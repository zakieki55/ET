package com.example.et;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminRegister extends AppCompatActivity {

    Button btnregister;
    EditText newemail, newpassword;
    String emailbaru, pwbaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        btnregister = findViewById(R.id.btnreg1a);
        newemail = findViewById(R.id.txtnewemaila);
        newpassword = findViewById(R.id.txtnewpwa);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailbaru = newemail.getText().toString();
                pwbaru = newpassword.getText().toString();

                if(emailbaru.isEmpty()|| pwbaru.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password anda wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else{

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Register Sukses",
                            Toast.LENGTH_LONG);

                    t.show();

                    Bundle b = new Bundle();

                    b.putString("a", emailbaru.trim());

                    b.putString("b", pwbaru.trim());

                    Intent i = new Intent(getApplicationContext(), adminLogin.class);

                    i.putExtras(b);

                    startActivity(i);


                }
            };
        }); }
}