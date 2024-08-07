package com.example.entregareto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entregareto.helper.Encrypt;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button botoniniciarsesion;
    Button botonregistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        botoniniciarsesion = findViewById(R.id.botoniniciarsesion);
        botonregistrarse = findViewById(R.id.botonregistrarse);

        botoniniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        botonregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserRegisterActivity.class);
                startActivity(intent);
            }
        });



    }
    public void login (){
    String email= this.editTextEmail.getText().toString();
    String password = this.editTextPassword.getText().toString();

    //simular bade de datos
    String emailStored = "nart@gmail.com";
    String passwordStored = Encrypt.encryptPassword("atenea123") ;

    if(email.equals(emailStored)){
        if(Encrypt.validateEncryptedPassword(password, passwordStored)){
            Intent intent = new Intent(this, PrincipalActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this , "credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }
    else{
        Toast.makeText(this , "credenciales incorrectas", Toast.LENGTH_LONG).show();
    }


    }
}