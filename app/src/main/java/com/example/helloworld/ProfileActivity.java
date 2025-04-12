package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView Nama, Email, Password;
    Button btnlogOut;

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Nama = findViewById(R.id.tvnama);
        Email = findViewById(R.id.tvEmail);
        Password = findViewById(R.id.Password);
        btnlogOut = findViewById(R.id.btnlogOut);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String nim = intent.getStringExtra("nim");

        Nama.setText("Nama: " + nama);
        Email.setText("Email: " + email);
        Password.setText("Password: " + password);

        btnlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(ProfileActivity.this, MainActivity2.class);
                logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logoutIntent);
                finish(); //
            }
        });
    }
}
