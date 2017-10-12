package com.tecsup.jeferson.myloginapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {

    private EditText act_nombre,act_usuario,act_contrasena;
    private Button btn_registrar;
    String nombre, usuario, contrasena;
    private SharedPreferences sharedPreferences;
    private static final String TAG = PrincipalActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        act_nombre=(EditText)findViewById(R.id.act_nombre);
        act_usuario=(EditText)findViewById(R.id.act_usuario);
        act_contrasena = (EditText)findViewById(R.id.act_contraseña);
        btn_registrar=(Button)findViewById(R.id.btn_registrar);

        /*nombre = act_nombre.getText().toString();
        usuario = act_usuario.getText().toString();
        contrasena = act_contrasena.getText().toString();*/

        Bundle dato = this.getIntent().getExtras();
        String nombre_e =  dato.getString("usuario");
        String contrasena_e =  dato.getString("contraseña");

        act_nombre.setText(nombre_e);
        act_contrasena.setText(contrasena_e);

        /*String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);

        User user = UserRepository.getUser(username);*/
    }

}
