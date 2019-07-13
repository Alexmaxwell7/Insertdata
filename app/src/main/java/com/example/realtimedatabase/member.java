package com.example.realtimedatabase;

import android.text.TextUtils;
import android.widget.Toast;

public class member {
    private  String email;
    private  String password;

    public member() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
