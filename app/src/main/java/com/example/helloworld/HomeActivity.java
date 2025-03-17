package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnResep1 = findViewById(R.id.btnlihatResep1);
        Button btnResep2 = findViewById(R.id.btnlihatResep2);
        Button btnResep3 = findViewById(R.id.btnlihatResep3);
        Button btnResep4 = findViewById(R.id.btnlihatResep4);
        Button btnResep5 = findViewById(R.id.btnlihatResep5);

       btnResep1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(HomeActivity.this, "Resep Lihat di Google", Toast.LENGTH_SHORT).show();
           }
       });
        btnResep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Resep Lihat di Google", Toast.LENGTH_SHORT).show();
            }
        });
        btnResep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Resep Lihat di Google", Toast.LENGTH_SHORT).show();
            }
        });
        btnResep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Resep Lihat di Google", Toast.LENGTH_SHORT).show();
            }
        });
        btnResep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Resep Lihat di Google", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
