package com.example.flyshoes.Aplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flyshoes.Modelo.Usuario;
import com.example.flyshoes.R;

public class SignInActivity extends AppCompatActivity {

    private Button btnRegistrarse ;
    private EditText txtusuario,txtCorreo,txtpContrasena,txtpRepetirContrasena;
    public static final int PRIMARY_ACTIVITY_1 = 1;
    private Usuario usuario;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btnRegistrarse =(Button) findViewById(R.id.btnRegistrarse);
        txtusuario = (EditText) findViewById(R.id.txtusuario);
        txtCorreo = (EditText) findViewById(R.id.txtEmail);
        txtpContrasena = (EditText) findViewById(R.id.txtpContrasena);
        txtpRepetirContrasena = (EditText) findViewById(R.id.txtpRepetirContrasena);
        /*
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!myEditText.getText().equals("") && !myEditText2.getText().equals("") && !myEditPass.getText().equals("") && !myEditPass2.getText().equals("")) {
                    usuario= new Usuario();
                    usuario.setLogin(myEditText.getText().toString());
                    usuario.setEmail(myEditText2.getText().toString());
                    usuario.setPassword(myEditPass.getText().toString());
                    if(myEditPass.getText().toString().equals(myEditPass2.getText().toString())) {
                        if (isvalidEmail(myEditText2.getText().toString())) {
                                     /*   if (!jugadorDB.comprobarUsuario(jugador.getUsuario())) {
                                            if (!jugadorDB.comprobarEmail(jugador.getEmail())) {
                                                jugadorDB.agregarJugador(jugador);
                                                intent = new Intent(getApplicationContext(), MainActivity.class);
                                                Toast.makeText(getApplicationContext(), getString(R.string.toastUsuario), Toast.LENGTH_SHORT).show();
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(getApplicationContext(), getString(R.string.toastEmail), Toast.LENGTH_SHORT).show();
                                            }
                                        }*/

        /*
                        } else {
                            Toast.makeText(SignInActivity.this, getString(R.string.toastFormatoIncorerctoEmail), Toast.LENGTH_SHORT).show();
                        }
                    }else{

                    }
                }else {
                    Toast.makeText(getApplicationContext(), getString(R.string.toastCamposIncompletos), Toast.LENGTH_SHORT).show();
                }
            }

            private boolean isvalidEmail(String email) {
                boolean b=false;
                String pattern = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
                if(email.matches(pattern)){
                    b=true;
                }
                return b;
            }

        });*/
    }

}