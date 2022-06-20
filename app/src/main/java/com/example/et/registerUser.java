package com.example.et;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerUser extends AppCompatActivity {

    Button btnregisteru;
    EditText newemailu, newpasswordu;
    String emailbaruu, pwbaruu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        btnregisteru = findViewById(R.id.btnreg1u);
        newemailu = findViewById(R.id.txtnewemailu);
        newpasswordu = findViewById(R.id.txtnewpwu);

        btnregisteru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailbaruu = newemailu.getText().toString();
                pwbaruu = newpasswordu.getText().toString();

                if(emailbaruu.isEmpty()|| pwbaruu.isEmpty()){
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

                    b.putString("a", emailbaruu.trim());

                    b.putString("b", pwbaruu.trim());

                    Intent i = new Intent(getApplicationContext(), loginUser.class);

                    i.putExtras(b);

                    startActivity(i);


                }
            };
        }); }
}