package com.example.entregareto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entregareto.helper.Encrypt;
import com.example.entregareto.helper.FileManager;
import com.example.entregareto.models.User;

public class LoginActivity extends AppCompatActivity {


    User user;
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
    /*String emailStored = "nart@gmail.com";
    String passwordStored = Encrypt.encryptPassword("atenea123") ;*/
        user            = new User() ;
        Log.e("msg", "login " );
        user            .setDefaultData();
        //Log.e("msg", "login " );

        if(!email.isEmpty() && !password.isEmpty()) {

            user.email      = email;
            user.password   = Encrypt.encryptPassword(password); //Encriptamos la constraseña ingresada

            FileManager fileManager = new FileManager(this);

            //Validar credenciales en base de datos
            User userLogged = fileManager.findUserByEmailAndPassword(user);

            if (userLogged != null) {

                user.copyData(userLogged); //Actualizamos el usuario GLOBAL de la aplicación con los datos de la base de datos

                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);

                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }





    }
}