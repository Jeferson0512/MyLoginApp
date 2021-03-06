package com.tecsup.jeferson.myloginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {

    private EditText act_nombre,act_usuario,act_contrasena;
    private Button btn_registrar;
    String nombre, usuario, contrasena;
    private SharedPreferences sharedPreferences;
    private static final String TAG = RegistroActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        act_nombre=(EditText)findViewById(R.id.act_nombre);
        act_usuario=(EditText)findViewById(R.id.act_usuario);
        act_contrasena = (EditText)findViewById(R.id.act_contraseña);
        btn_registrar=(Button)findViewById(R.id.btn_registrar);

        Bundle dato = this.getIntent().getExtras();
        String nombre_e =  dato.getString("usuario");
        String contrasena_e =  dato.getString("contraseña");

        act_usuario.setText(nombre_e);
        act_contrasena.setText(contrasena_e);

        /*String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);

        User user = UserRepository.getUser(username);*/
    }

    public void Registrarse(View view){

        nombre = act_nombre.getText().toString();
        usuario = act_usuario.getText().toString();
        contrasena = act_contrasena.getText().toString();

        UserRepository.Useradd(usuario,contrasena,nombre);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putString("username", usuario).commit();

        Log.d(TAG, UserRepository.users+"");

        Toast.makeText(this, "Usuario: "+nombre+" registrado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }

}
