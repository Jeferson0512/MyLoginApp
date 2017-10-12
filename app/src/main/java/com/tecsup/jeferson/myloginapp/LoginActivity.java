package com.tecsup.jeferson.myloginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // SharedPreferences
    private SharedPreferences sharedPreferences;

    private EditText usernameInput;
    private EditText passwordInput;
    private ProgressBar progressBar;
    private View loginPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        loginPanel = findViewById(R.id.login_panel);

        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // username remember
        String username = sharedPreferences.getString("username", null);
        if(username != null){
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }

        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goDashboard();
        }

    }

    public void callLogin(View view){
        loginPanel.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String fullname=username;

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Falta completar las casillas", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login logic
        User user = UserRepository.login(username, password);

        if(user == null){
            /*Toast.makeText(this, "Usuario o Contraseña invalidos", Toast.LENGTH_SHORT).show();
            loginPanel.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);*/
            /*Intent intent = new Intent(this, RegistroActivity.class);
            intent.putExtra("usuario",username);
            intent.putExtra("contraseña",password);
            startActivity(intent);*/
            UserRepository.Useradd(fullname,username,password);
            return;
        }

        Toast.makeText(this, "Bienvenido " + user.getFullname(), Toast.LENGTH_SHORT).show();

        // Save to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("username", user.getUsername())
                .putBoolean("islogged", true)
                .commit();

        // Go to Dashboard
        goDashboard();
    }

    private void goDashboard(){
        startActivity(new Intent(this, PrincipalActivity.class));
        finish();
    }
}
