package com.example.login_registrarion_all_info_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration_patients extends AppCompatActivity {
private EditText txtemail,txtpassword;
Button login,registration;
private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_patients);
        txtemail=findViewById(R.id.email);
        txtpassword=findViewById(R.id.password);
        login=findViewById(R.id.loginP);
        firebaseAuth.getInstance();
        registration=findViewById(R.id.registration);

        getSupportActionBar().setTitle("LogIn");

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register_patients.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtemail.getText().toString().trim();
                String password=txtpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Registration_patients.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Registration_patients.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length()<6){
                    Toast.makeText(Registration_patients.this, "Password To Short", Toast.LENGTH_SHORT).show();
                }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registration_patients.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),Patient_Page.class));

                                } else {
                                    Toast.makeText(Registration_patients.this, "Unauthorized Person", Toast.LENGTH_SHORT).show();

                                }


                            }
                        });


            }
        });

    }
}
