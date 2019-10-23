package com.example.login_registrarion_all_info_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_patients extends AppCompatActivity {
private  EditText txtemail,txtpassword,txtcpassword;
private FirebaseAuth firebaseAuth;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_patients);
        txtcpassword=findViewById(R.id.cpassword);
        Button clear=findViewById(R.id.clear);
        progressBar=findViewById(R.id.progressbar);
        txtemail=findViewById(R.id.email);
        txtpassword=findViewById(R.id.password);
        Button register=findViewById(R.id.register);
        Button login=findViewById(R.id.login);
        firebaseAuth =FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("SignUp");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register_patients.this,Registration_patients.class);
                startActivity(intent);
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtemail.setText("");
                txtpassword.setText("");

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= txtemail.getText().toString().trim();
                String password= txtpassword.getText().toString().trim();
                String confirmPassword= txtcpassword.getText().toString().trim();
if (TextUtils.isEmpty(email)){
    Toast.makeText(Register_patients.this, "Enter Email", Toast.LENGTH_SHORT).show();
    return;
}
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register_patients.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(Register_patients.this, "Enter confirmPassword", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(Register_patients.this, "Password to Short", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(confirmPassword)){

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register_patients.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {

                                        Intent intent=new Intent(Register_patients.this,Patient_Page.class);
                                        startActivity(intent);
                                        Toast.makeText(Register_patients.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Register_patients.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });

                }
            }
        });
    }
}
