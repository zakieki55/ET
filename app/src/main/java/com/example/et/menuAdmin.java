package com.example.et;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuAdmin extends AppCompatActivity {

    Button Dbarang, Dpesanan, Mbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        Dbarang = findViewById(R.id.btndaftarbarang);
        Dpesanan = findViewById(R.id.btndaftarpesan);
        Mbarang = findViewById(R.id.btntambahbarang);

        Dbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ww = new Intent(getApplicationContext(), mainAdmin.class);

                startActivity(ww);
            }
        });
        Dpesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gg = new Intent(getApplicationContext(), mainUser.class);

                startActivity(gg);
            }
        });
        Mbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nn = new Intent(getApplicationContext(), editorAdmin.class);

                startActivity(nn);
            }
        });
    }
}