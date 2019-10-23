package com.example.login_registrarion_all_info_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Patient_Page extends AppCompatActivity {
EditText fullName,diseaseD,emails,passwords,contactNo,statuS;
TextView gendeR;
Button register;
FirebaseAuth firebaseAuth;
    String gender="";
RadioButton radiogendermale,rediogenderfemale;
DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__page);
        getSupportActionBar().setTitle("Patients Page");

        databaseReference=FirebaseDatabase.getInstance().getReference("Patients");

        fullName=findViewById(R.id.fullname);
        gendeR=findViewById(R.id.gender);
        diseaseD=findViewById(R.id.diseased);
        contactNo=findViewById(R.id.contactno);
        register=findViewById(R.id.pRegister);
        emails=findViewById(R.id.email);
        passwords=findViewById(R.id.password);
        statuS=findViewById(R.id.statuS);
        radiogendermale=findViewById(R.id.radioGenderMale);
        rediogenderfemale=findViewById(R.id.radiogenderfemale);
firebaseAuth.getInstance();
      /*  register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fullname=fullName.getText().toString().trim();
                final String diseased=diseaseD.getText().toString().trim();
                final String email=emails.getText().toString().trim();
                final String password=passwords.getText().toString().trim();
                final String status=statuS.getText().toString().trim();
                final String contactno=contactNo.getText().toString().trim();
                if (radiogendermale.isChecked()){
                    gender="Male";
                }
                if (rediogenderfemale.isChecked()){
                   gender="Female";
                }

                    if (TextUtils.isEmpty(fullname)) {

                    Toast.makeText(Patient_Page.this, "Please Enter FullName", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(diseased)) {

                    Toast.makeText(Patient_Page.this, "Please Enter Diseased", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(contactno)) {

                    Toast.makeText(Patient_Page.this, "Please Enter contact No", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(status)) {

                    Toast.makeText(Patient_Page.this, "Please Enter status", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(Patient_Page.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(Patient_Page.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Patient_Page.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Records information=new Records(
                                            fullname,
                                            diseased,
                                            email,
                                            password,
                                            contactno,
                                            status,
                                            gender


                                    );
                                    FirebaseDatabase.getInstance().getReference("Patients").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Patient_Page.this, "Record Save Successfully", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),Splash_Screen.class));
                                        }
                                    });
                                } else {
                                }

                                // ...
                            }
                        });*/

        /*    }
        });*/
    }

}
