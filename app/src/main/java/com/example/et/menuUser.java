package com.example.et;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menuUser extends AppCompatActivity {

    Button barang, Mpesanan, keranjang;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logOut){
            Intent men = new Intent(getApplicationContext(), loginUser.class);
            startActivity(men);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
        barang = findViewById(R.id.btnbarang);
        Mpesanan = findViewById(R.id.btnmembuatpesanan);
        keranjang = findViewById(R.id.btnkeranjang);

        barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent la = new Intent(getApplicationContext(), mainAdmin.class);

                startActivity(la);
            }
        });
        Mpesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent xy = new Intent(getApplicationContext(), editorUser.class);

                startActivity(xy);
            }
        });
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cc = new Intent(getApplicationContext(), mainUser.class);

                startActivity(cc);
            }
        });
    }
}