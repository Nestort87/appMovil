package com.example.entregareto.helper;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Validation {


    public static void validateTextField(TextView textView, TextView errorMsg, String fieldName, int min, int max, Context context){

        String text = textView.getText().toString();
        String msg = "";

        if(text.isEmpty()){
            msg = "El campo " + fieldName + " no puede estar vacio";
            Toast.makeText(context,msg , Toast.LENGTH_LONG).show();
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }

        if (text.length() < min || text.length() > max ){
            msg = "El campo " + fieldName + " debe tener entre " + min + " y " + max + " caracteres";
            Toast.makeText(context,msg ,Toast.LENGTH_LONG).show();
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }

        if(!text.matches("^[a-zA-ZÀ-ÿ\\s'-]{" + min + "," + max + "}$")){
            msg = "El campo " + fieldName + " solo debe contener letras";
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }
        else errorMsg.setVisibility(TextView.GONE);

        //return;


    }

    public static void validateEmail (EditText editText, TextView errorMsg, String fieldName, Context context){

        String text = editText.getText().toString();
        String msg ="";

        if(text.isEmpty()) {
            msg = "El " + fieldName + " no puede estar vacio";
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }

        if (!text.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            msg = "Ingrese una dirección de correo válida";
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }
        else errorMsg.setVisibility(TextView.GONE);

    }

    public static void validatePassword(EditText password, TextView errorMsg, int min, int max, Context context){
        String text = password.getText().toString();
        String msg = "";

        if(text.isEmpty()){
            msg = "La contraseña no puede estar vacía";
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }

        if (text.length() < min || text.length() > max ){
            msg = "la contraseña debe contener min" + min + "y max " + max + "caracteres";
            errorMsg.setText(msg);
            errorMsg.setVisibility(TextView.VISIBLE);
            return;
        }
        else errorMsg.setVisibility(TextView.GONE);



    }

}
