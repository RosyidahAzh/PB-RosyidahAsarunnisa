package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.model.userDetails;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity2 extends AppCompatActivity {

    Button SignUpbtn;
    TextInputEditText UsernameSignUp, emailSignup, Password, NIM;
    FirebaseAuth mAuth;
    private static final String TAG = "MainActivity2";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SignUpbtn = findViewById(R.id.SignUpbtn);
        UsernameSignUp = findViewById(R.id.UsernameSignUp);
        Password = findViewById(R.id.Password);
        NIM = findViewById(R.id.NIM);


        SignUpbtn.setOnClickListener(view ->{
            String username, email, password, nim;

            username = String.valueOf(UsernameSignUp.getText());
            email = String.valueOf(emailSignup.getText());
            password = String.valueOf(Password.getText());
            nim = String.valueOf(NIM.getText());

            if (TextUtils.isEmpty(username)){
                Toast.makeText(MainActivity2.this, "Enter Username", Toast.LENGTH_LONG).show();
                UsernameSignUp.requestFocus();
            } else if (TextUtils.isEmpty(email)){
                Toast.makeText(MainActivity2.this, "Enter Email", Toast.LENGTH_LONG).show();
                emailSignup.requestFocus();
            }else if (TextUtils.isEmpty(password)){
                Toast.makeText(MainActivity2.this, "Enter Password", Toast.LENGTH_LONG).show();
                Password.requestFocus();
            }else if (TextUtils.isEmpty(nim)) {
                Toast.makeText(MainActivity2.this, "Enter NIM", Toast.LENGTH_LONG).show();
                NIM.requestFocus();
            }

            
        });
    }

    private void  registerUser(String usernameSignUp, String Password, String NIM, String emailSignup) {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(emailSignup, Password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser fuser = auth.getCurrentUser();
                if (fuser != null) {
                    String uid = fuser.getUid();

                    userDetails userDetails = new userDetails(uid, usernameSignUp, Password, emailSignup, NIM);

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");
                    reference.child(uid).setValue(userDetails).addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            fuser.sendEmailVerification().addOnCompleteListener(task2 -> {
                                if (task2.isSuccessful()) {
                                    Toast.makeText(MainActivity2.this, "Verifikasi Email Telah Dikirim", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity2.this, "Verifikasi Email Gagal Dikirim", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Register Error");
                                }
                            });
                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthUserCollisionException e) {
                                Toast.makeText(MainActivity2.this, "Email Sudah Terdaftar", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    ;}
}