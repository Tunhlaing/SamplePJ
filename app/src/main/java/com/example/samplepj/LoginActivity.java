package com.example.samplepj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    SamplePJDatabase db;
    TextInputLayout tiUserName, tiPassword, tiCPassword;
    TextInputEditText etUserName, etPassword, etCPasswrod;
    Button btRegister, btLogin;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new SamplePJDatabase(this);
        pref = getSharedPreferences("My_Pref", MODE_PRIVATE);


        initializeViews();

        handleClicks();

    }

    void initializeViews() {
        tiUserName = findViewById(R.id.tiUserName);
        tiPassword = findViewById(R.id.tiPassword);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        btRegister = findViewById(R.id.btRegister);
        btLogin = findViewById(R.id.btLogin);

    }

    private void handleClicks() {
        btRegister.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
            finish();
        });
        btLogin.setOnClickListener(view -> {
            if (checkValidations()) {
                if (db.loginUser(etUserName.getText().toString(), etPassword.getText().toString())) {
                    Utils.showToast(this, "Login Successfully");
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();
                    startActivity(new Intent(this, HomeActivity.class));
                    finish();
                } else {
                    Utils.showToast(this, "User name or password incorrect !!!");
                }
            }
        });
    }

    private boolean checkValidations() {
        if (TextUtils.isEmpty(etUserName.getText().toString())) {
            tiUserName.setError("Enter UserName");
            return false;
        } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
            tiUserName.setError(null);
            tiPassword.setError("Enter password");
            return false;
        } else {
            return true;
        }
    }


}