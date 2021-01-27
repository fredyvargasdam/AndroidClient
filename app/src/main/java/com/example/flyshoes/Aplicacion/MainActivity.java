package com.example.flyshoes.Aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.flyshoes.Client.ProductoClient;
import com.example.flyshoes.Interface.ClientApi;
import com.example.flyshoes.Modelo.Productos;
import com.example.flyshoes.Modelo.Usuario;
import com.example.flyshoes.R;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Usuario> {
    private TextView xmlTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xmlTest = (TextView) findViewById(R.id.xmlTest);
        getUsuario();

    }


    private void getUsuario() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.23:8080/ApplicationServer/webresources/")
                .client(new OkHttpClient()).addConverterFactory(SimpleXmlConverterFactory.create()).build();
        ClientApi clientApi = retrofit.create(ClientApi.class);
        Call<Usuario> call = clientApi.find("5");
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
        if (response.isSuccessful()) {
            Usuario usuario = (Usuario) response.body();
            String si="";
            //si=si+ usuario.getLogin() + "BIEN"+ "\n";
            xmlTest.append(usuario.getLogin()+"\n "+usuario.getPassword()+ "\n  "+usuario.getEmail());
          //  si=si+ usuario.getDireccion()+ "BIEN"+ "\n";
         //   xmlTest.append(si);
//            xmlTest.append(si);
//            xmlTest.append(si);
          //  si=si+usuario.getEmail()+ "BIEN"+ "\n";
          //  xmlTest.append(si);

          //  xmlTest.setText(response.code() + "BIEN");
          //  xmlTest.setText(usuario.getFullname());

        } else {
            xmlTest.setText(response.code() + " MAL");
        }
    }

    @Override
    public void onFailure(Call<Usuario> call, Throwable t) {
        xmlTest.setText(t.getMessage() + "Exception ");
    }
}