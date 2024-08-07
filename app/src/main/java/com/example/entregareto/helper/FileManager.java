package com.example.entregareto.helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.entregareto.models.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private Context     context;
    public File         userFile; //Almacenar la información de los usuarios
    public File         advicesFile; //Almacenar los concejos

    public FileManager(Context context) {
        this.context    = context;
        userFile        = loadFileOrCreate("db_user");
        advicesFile     = loadFileOrCreate("db_advices");
    }

    private File loadFileOrCreate(String fileName) {

        File file = new File(context.getFilesDir(), fileName + ".txt");

        if (file.exists()) {
            Log.e("msg", "El archivo " + file.getName() + " ya existe en: " + file.getAbsolutePath());
            return file;

        } else {

            try {
                file.createNewFile();
                Log.e("msg", "El archivo " + file.getName() + " fue creado exitosamente en: " + file.getAbsolutePath());

                return file;

            } catch (IOException e) {
                Log.e("msg", "Error al crear el archivo " + file.getName(), e);
                return null;
            }
        }
    }

    public boolean insertNewUser(User user) {
        Log.e("msg", "Se ha insertado el nuevo usuario en " );


        try {
            Log.e("msg", "Se ha ingresado " );
            //Si el email no existe en el archivo entonces lo insertamos
            if (!validateIfUserExist(user)) {
                //Log.e("msg", "Se ha ingresado a insertar  " );

                BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true));

                writer.write(user.objetcToJSON());
                Log.e("msg", "Se ha ingresado a insertar  " );
                writer.newLine();
                writer.close();

                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_LONG).show();

                Log.e("msg", "Se ha insertado el nuevo usuario en " + userFile.getName() + " exitosamente");

                return true;

            } else {
                Toast.makeText(context, "El usuario " + user.email + " ya está registrado", Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            Toast.makeText(context, "Error al escribir en el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return false;
    }

    public boolean validateIfUserExist(User user) {


        try {

            BufferedReader reader = new BufferedReader(new FileReader(userFile));


            String data;
            Log.e("msg", "validateifuserexist " + reader);
            while ((data = reader.readLine()) != null) {
                Log.e("msg", "ingresa validateifuserexist " );

                //Convertimos el dato leido en un objeto de tipo User
                User dbUser = new Gson().fromJson(data, User.class);

                //Si el email ya existe retornamos true
                if (dbUser.email.equals(user.email)) {
                    return true;
                }
            }
            reader.close();

        } catch (IOException e) {
            Log.e("msg", "validateifuserexist catch " );
            Toast.makeText(context, "Error al leer el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        Log.e("msg", "validateifuserexist final " );
        //String jsonData = new Gson().toJson(this);
        //Log.e("msg", "validateifuserexist final " + jsonData );
        //Si llega hasta acá es porque el email no existe en la base de datos
        return false;
    }

}
