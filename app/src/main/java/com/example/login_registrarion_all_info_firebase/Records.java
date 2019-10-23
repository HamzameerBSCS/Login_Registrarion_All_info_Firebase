package com.example.login_registrarion_all_info_firebase;

import android.widget.Button;
import android.widget.EditText;

public class Records {


   public String fullName,diseaseD,emails,passwords,contactNo,statuS,Gender;


    public Records(){

    }

    public Records(String fullName, String diseaseD, String emails, String passwords, String contactNo, String statuS, String gender) {
        this.fullName = fullName;
        this.diseaseD = diseaseD;
        this.emails = emails;
        this.passwords = passwords;
        this.contactNo = contactNo;
        this.statuS = statuS;
        Gender = gender;
    }
}


