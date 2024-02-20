package com.example.ticket_premium_movil;

import android.content.Intent;
import android.os.AsyncTask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button irRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.txtUsername);
        editTextPassword = findViewById(R.id.txtPassword);
        buttonLogin = findViewById(R.id.btnLogin);
        irRegistro = findViewById(R.id.btnIrRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                new LoginTask().execute(username, password);

            }
        });

        irRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            String username = params[0];
            String password = params[1];

            // Llama al método comprobarUsuario del web service
            return WebServiceHelper.comprobarUsuario(username, password);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                // Continuar con la lógica después del inicio de sesión exitoso
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                // Manejar el caso de inicio de sesión fallido
            }
        }
    }
}