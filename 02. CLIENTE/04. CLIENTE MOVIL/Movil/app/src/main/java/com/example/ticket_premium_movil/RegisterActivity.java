package com.example.ticket_premium_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText usuarioEdit;
    private EditText passwordEdit;
    private EditText nombreEdit;
    private EditText apellidoEdit;
    private EditText cedulaEdit;
    private EditText direccionEdit;

    private Button registrar;
    private Button atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usuarioEdit = findViewById(R.id.txtUsernameRegistro);
        passwordEdit = findViewById(R.id.txtPasswordRegistro);
        nombreEdit = findViewById(R.id.txtNombreRegistro);
        apellidoEdit = findViewById(R.id.txtApellidoRegistro);
        cedulaEdit = findViewById(R.id.txtCedulaRegistro);
        direccionEdit = findViewById(R.id.txtDireccionRegistro);

        registrar = findViewById(R.id.btnRegistrarUsuario);
        atras = findViewById(R.id.btnAtrasRegistro);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameR = usuarioEdit.getText().toString();
                String passwordR = passwordEdit.getText().toString();
                String nombreR = nombreEdit.getText().toString();
                String apellidoR = apellidoEdit.getText().toString();
                String cedulaR = cedulaEdit.getText().toString();
                String direccionR = direccionEdit.getText().toString();

                new RegisterActivity.LoginTask().execute(usernameR, passwordR, nombreR, apellidoR, cedulaR, direccionR);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            String username = params[0];
            String password = params[1];
            String nombre = params[2];
            String apellido = params[3];
            String cedula = params[4];
            String direccion = params[5];

            // Llama al método comprobarUsuario del web service
            return WebServiceHelper.registroUsuario(username, password, nombre, apellido, cedula, direccion);
        }

        @Override
        protected void onPostExecute(Boolean result) {
                Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                // Continuar con la lógica después del inicio de sesión exitoso
        }
    }
}