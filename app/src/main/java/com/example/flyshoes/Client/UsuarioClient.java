package com.example.flyshoes.Client;

import com.example.flyshoes.Modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
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

}
