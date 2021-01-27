package com.example.flyshoes.Aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.flyshoes.Client.UsuarioClient;
import com.example.flyshoes.ControlDB.UsuarioDB;
import com.example.flyshoes.Interface.ClientApi;
import com.example.flyshoes.Modelo.PrivilegioUsuario;
import com.example.flyshoes.Modelo.Usuario;
import com.example.flyshoes.R;
import com.example.flyshoes.Seguridad.Seguridad;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Logger;

import javax.crypto.Cipher;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class LogInActivity extends AppCompatActivity implements Callback<Usuario> {

    private static UsuarioDB usuarioDB = null;
    private LottieAnimationView animacionView;
    private EditText txtUsuario, txtpContrasena;
    private Button btnIniciar;
    private TextView tvRegistrarse;
    private Usuario usuario;
    private Intent intent;
    private static PublicKey publicKey;
    private static Cipher cipher;
    private static final char[] HEXADECIMAL_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final Logger LOGGER = Logger.getLogger(Seguridad.class.getName());
    private static final String CARACTERES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        animacionView = (LottieAnimationView) findViewById(R.id.ivLogin);
        animacionView.setAnimation(R.raw.login_mejorado);
        animacionView.playAnimation();
        animacionView.setRepeatCount(500);
        usuarioDB = new UsuarioDB(getApplicationContext());
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtpContrasena = (EditText) findViewById(R.id.txtpContrasena);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        tvRegistrarse = (TextView) findViewById(R.id.tvRegistrarse);
        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsuario.getText().toString().equals("") || txtpContrasena.getText().toString().equals("")) {
                    Toast.makeText(LogInActivity.this, getString(R.string.toastCamposIncompletos), Toast.LENGTH_SHORT).show();
                } else if (usuario != null) {
                    LOGGER.info("Usuario se encuentra registrado " + usuario.getLogin());
                    if (usuario != null) {
                        LOGGER.info("Usuario autenticado  " + usuario.getPassword());

                        if (usuario.getPrivilege().equals(PrivilegioUsuario.VENDEDOR)) {

                        } else {
                            Toast.makeText(LogInActivity.this, getString(R.string.toastUsuario), Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(LogInActivity.this, getString(R.string.toastContrasenaIncorrecta), Toast.LENGTH_SHORT).show();
                    }


                    //Aqui preguntamos solo por login retrofit
                 /*   if (jugadorDB.comprobarUsuario(jugador.getUsuario())) {
                        //aqui solo por pass retrofit
                        if (jugadorDB.comprobarUsuarioContrasena(jugador.getUsuario(), jugador.getContrasena())) {
                            intent = new Intent(MainActivity.this, InicioActivity.class);
                            intent.putExtra("dato", jugador);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LogInActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LogInActivity.this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                    }*/
                } else {
                    Toast.makeText(LogInActivity.this, getString(R.string.toastUsuarioNoEncontrado), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void contrasenaCorrecta(String login, String pass) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.23:8080/ApplicationServer/webresources/")
                .client(new OkHttpClient()).addConverterFactory(SimpleXmlConverterFactory.create()).build();
        UsuarioClient usuarioClient = retrofit.create(UsuarioClient.class);
        Call<Usuario> call = usuarioClient.usuarioByLogin(login, pass);
        call.enqueue(this);
    }

    private void estaUsuario(String login) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.23:8080/ApplicationServer/webresources/")
                .client(new OkHttpClient()).addConverterFactory(SimpleXmlConverterFactory.create()).build();
        UsuarioClient usuarioClient = retrofit.create(UsuarioClient.class);
        Call<Usuario> call = usuarioClient.UsuarioLogin(login);
        call.enqueue(this);

    }

    // Convierte Array de Bytes en hexadecimal
    private String bytesToHexadecimal(byte[] bytes) {
        char[] caracter = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            caracter[j * 2] = HEXADECIMAL_ARRAY[v >>> 4];
            caracter[j * 2 + 1] = HEXADECIMAL_ARRAY[v & 0x0F];
        }
        return new String(caracter);
    }

    /**
     * Contraseña cifrada con clave pública y convertida a hexadecimal
     *
     * @param contrasenia
     * @return contrasenia cifrada
     */
    public String encriptarContrasenia(String contrasenia) {
        String pass = "";

        try {
            //Clave pública
            byte fileKey[] = getFile();
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(fileKey);
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encriptado = cipher.doFinal(contrasenia.getBytes());
            pass = bytesToHexadecimal(encriptado);
        } catch (Exception ex) {
            LOGGER.severe("Error al encriptar con clave pública");
        }
        return pass;
    }


    /**
     * Obtener clave pública
     *
     * @return array de bytes
     * @
     */

    private byte[] getFile() throws IOException {
        int fileID = getResources().getIdentifier("public_key", "raw", getPackageName());

        InputStream inputStream = this.getResources().openRawResource(fileID);
        int leidos;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        while ((leidos = inputStream.read(data, 0, data.length)) != -1) {
            byteArrayOutputStream.write(data, 0, leidos);
        }
        byteArrayOutputStream.flush();
        byte[] filekey = byteArrayOutputStream.toByteArray();
        return filekey;
    }

    @Override
    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
        usuario = null;
        if (response.isSuccessful()) {
            usuario = response.body();
        }else{
            LOGGER.severe("ERROR"+response.message());
        }
    }

    @Override
    public void onFailure(Call<Usuario> call, Throwable t) {
        Toast.makeText(LogInActivity.this, getString(R.string.toastErrorServidor), Toast.LENGTH_SHORT).show();
    }
}