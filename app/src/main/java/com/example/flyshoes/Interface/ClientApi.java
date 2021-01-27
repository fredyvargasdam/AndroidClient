package com.example.flyshoes.Interface;

import com.example.flyshoes.Modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//usuario
public interface ClientApi {
    @GET("usuario/{id}")
    Call<Usuario> find(@Path("id") String id);
}
