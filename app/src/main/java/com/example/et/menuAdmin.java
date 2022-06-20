package com.example.et;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menuAdmin extends AppCompatActivity {

    Button Dbarang, Dpesanan, Mbarang;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logOut){
            Intent men = new Intent(getApplicationContext(), adminLogin.class);
            startActivity(men);
        }
        return super.onOptionsItemSelected(item);
    }

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