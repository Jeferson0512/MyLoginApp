package com.tecsup.jeferson.myloginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Configuracion extends AppCompatActivity {

    private static final String TAG = PrincipalActivity.class.getSimpleName();
    private EditText edt_fullname;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        edt_fullname = (EditText)findViewById(R.id.edt_fullname);

        String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);

        User user = UserRepository.getUser(username);

        edt_fullname.setText(user.getFullname());

        Guardar_Datos(null);
    }
    public void Guardar_Datos(View view){



        String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);

        User user = UserRepository.getUser(username);

        user.setFullname(edt_fullname.getText().toString());
        sharedPreferences.edit().putString("username",user+"").commit();

        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
