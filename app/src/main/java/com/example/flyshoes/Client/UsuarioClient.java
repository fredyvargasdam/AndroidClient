package com.example.flyshoes.Client;

import com.example.flyshoes.Modelo.Usuario;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//usuario
public interface UsuarioClient {
    /**
     * Consulta al servidor si el usuario se encuentra registrado por id
     * @param id
     * @return
     */
    @GET("usuario/{id}")
    Call<Usuario> find(@Path("id") String id);

    /**
     * Consulta al servidor si el usuario se encuentra registrado por login
     * @param login
     * @return
     */
    @GET("usuario/UsuarioLogin/{login}")
    Call<Usuario> UsuarioLogin(@Path("login") String login);

    /**
     * Consulta al servidor si la contraseña del usuario es correcta
     * @param login
     * @param pass
     * @return
     */
    @GET("usuario/usuarioByLogin/{login}/{pass}")
    Call<Usuario> usuarioByLogin(@Path("login") String login,@Path("pass") String pass);

    /**
     * Comprobar si el email ya se encuentra registrado
     * @param email
     * @return
     */
    @GET("usuario/findEmail/{login}/{email}")
    Call<Usuario> findEmail(@Path("email") String email);

    /**
     * Alta usuario
     * @param body
     * @return
     */
    @POST("usuario/")
    Call<Usuario> create(@Body RequestBody body);
}
