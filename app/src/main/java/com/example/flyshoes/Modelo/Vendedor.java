package com.example.flyshoes.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Set;


/*
 * Entidad Vendedor relacionado con gestiona Producto y maneja Reserva
 */
@Root(strict = false,name="Vendedor")
public class Vendedor extends Usuario implements Serializable {

    /*
     * Vendedor se relaciona con Cliente por OneToMany
     */
    @ElementList(inline = true,name="cliente")
    private Set<Cliente> cliente;

    /*
    *Vendedor se relaciona con Producto por ManyToMany
     */
    @ElementList(inline = true,name="productos")
    private Set<Producto> productos;

    @Element(name="administrador")
    private Administrador administrador;

    private static final long serialVersionUID = 1L;

    /*
    * Dni del vendedor
     */
    @Element(name="dni")
    private String dni;

    /*
    * Salario del vendedor
     */
    @Element(name="salario")
    private Integer salario;

    /*
    * Tienda del vendedor
     */
    @Element(name="tienda")
    private String tienda;

    /**
     * Devuelve una lista de productos
     *
     * @return productos
     */

    public Set<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece una lista de productos
     *
     * @param productos
     */
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Devuelve el dni del vendedor
     *
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el dni del producto
     *
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el salario del vendedor
     *
     * @return salario
     */
    public Integer getSalario() {
        return salario;
    }

    /**
     * Establece el salario del vendedor
     *
     * @param salario
     */
    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    /**
     * Devuelve la tienda en la que trabaja el vendedor
     *
     * @return tienda
     */
    public String getTienda() {
        return tienda;
    }

    /**
     * Establece la tienda en la que trabaja el vendedor
     *
     * @param tienda
     */
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    /**
     * Devuelve una lista de clientes
     *
     * @return lista de clientes
     */

    public Set<Cliente> getCliente() {
        return cliente;
    }

    /**
     * Establece una lista de clientes
     *
     * @param cliente
     */
    public void setCliente(Set<Cliente> cliente) {
        this.cliente = cliente;
    }

    /**
     * devuelve el administrador
     *
     * @return administrador
     */

    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * establece el administrador
     *
     * @param administrador
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "flyshoes.entity.Vendedor[ id=" + dni + " ]";
    }

}
