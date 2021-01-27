package com.example.flyshoes.Modelo;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class Productos {
    @ElementList(name = "productos", required = true, inline = true)
    public List<Producto> productos;

}
