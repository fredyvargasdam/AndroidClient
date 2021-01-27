package com.example.flyshoes.Client;

import com.example.flyshoes.Modelo.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoClient {
    @GET("producto/findAllProductosAsc")
    Call<List<Productos>> findAllProductos();
}
