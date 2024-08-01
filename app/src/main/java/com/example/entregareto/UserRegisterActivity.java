package com.example.entregareto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.entregareto.helper.Validation;

public class UserRegisterActivity extends AppCompatActivity {


    EditText username;
    TextView erroName;
    EditText email;
    TextView errorEmail;
    EditText password;
    TextView errorPassword;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregister);

        username = findViewById(R.id.username);
        erroName = findViewById(R.id.errorName);
        email = findViewById(R.id.email);
        errorEmail = findViewById(R.id.errorEmail);
        password = findViewById(R.id.userpassword);
        errorPassword = findViewById(R.id.errorPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(view -> {
            Validation.validateTextField(username, erroName, "nombre", 3, 50, this);
            Validation.validateEmail(email, errorEmail, "Email", this);
            Validation.validatePassword(password, errorPassword, 6, 12, this);
        });

    }

}