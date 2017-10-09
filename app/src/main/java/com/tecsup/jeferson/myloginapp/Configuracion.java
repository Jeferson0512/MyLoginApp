package com.tecsup.jeferson.myloginapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class Configuracion extends AppCompatActivity {

    private static final String TAG = PrincipalActivity.class.getSimpleName();
    private EditText edt_fullname;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        edt_fullname = (EditText)findViewById(R.id.edt_fullname);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);

        User user = UserRepository.getUser(username);

        edt_fullname.setText(user.getUsername());

    }
}
