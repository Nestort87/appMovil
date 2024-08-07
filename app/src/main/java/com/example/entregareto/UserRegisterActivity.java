package com.example.entregareto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.entregareto.helper.Encrypt;
import com.example.entregareto.helper.FileManager;
import com.example.entregareto.helper.Validation;
import com.example.entregareto.models.User;

public class UserRegisterActivity extends AppCompatActivity {

    User        userin;
    EditText username;
    TextView errorName;
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
        errorName = findViewById(R.id.errorName);
        email = findViewById(R.id.email);
        errorEmail = findViewById(R.id.errorEmail);
        password = findViewById(R.id.userpassword);
        errorPassword = findViewById(R.id.errorPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(view -> {
            Validation.validateTextField(username, errorName, "nombre", 3, 50, this);
            Validation.validateEmail(email, errorEmail, "Email", this);
            Validation.validatePassword(password, errorPassword, 6, 12, this);

            boolean errorResult = Validation.showErrorMessages();
            Log.e("msg", "Prueba registro " + errorResult);

            if(errorResult == true){
                //Registrar usuario en base de datos
                userin            = new User();
                userin.name       = username.getText().toString();
                userin.email      = email.getText().toString();
                userin.password   = Encrypt.encryptPassword(password.getText().toString()); //Encriptamos la contraseña

                storageUserInDatabase();

            }

        });

    }

    private void storageUserInDatabase(){

        FileManager fileManager = new FileManager(this);
        Log.e("msg", "ingresa storage " + fileManager );

        //if(fileManager.insertNewUser(user)){
        fileManager.insertNewUser(userin);
            Log.e("msg", "if ingresa storage " );
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        //}
    }

}