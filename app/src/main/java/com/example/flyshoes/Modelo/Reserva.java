package com.example.flyshoes.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;


/**
 * Esta clase se encargará sobre la gestión de reservas
 *
 * @author Fredy Vargas Flores
 */
@Root(strict = false,name="Reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la reserva
     */
    @Element(name="id")
    private Long id;

    //producto contiene la reserva
    @Element(name="producto")
    public Producto producto;
    //descripcion de la reserva
    @Element(name="descripcion")
    private String descripcion;
    //estado de la reserva
    @Element(name="estado")
    private EstadoReserva estado;

    //cliente  de la reserva
    @Element(name="cliente")
    private Cliente cliente;
    //cantidad del producto
    @Element(name="cantidad")
    private Integer cantidad;
    //Fecha de reserva
    @Element(name="fechaReserva")
    private String fechaReserva;
    //Fecha de entrega prevista
    @Element(name="fechaEntrega")
    private String fechaEntrega;
    
    
    
    /**
     * Devuelve la id de la reserva
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la id de la reserva
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la descripcion de la reserva
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Inserta la descripcion de la reserva
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el estado de la reserva
     *
     * @return estado
     */
    public EstadoReserva getEstado() {
        return estado;
    }

    /**
     * Inserta el estado de la reserva
     *
     * @param estado
     */
    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el cliente que ha realizado dicha reserva
     *
     * @return cliente
     */
    // @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Añade al cliente de la reserva
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve del producto
     *
     * @return producto
     */
    // @XmlTransient
    public Producto getProducto() {
        return producto;
    }

    /**
     * Inserta el producto a la reserva
     *
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Devuelve la cantidad del producto
     *
     * @return cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Inserta la cantidad del producto
     *
     * @param cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve la fecha de la reserva
     *
     * @return
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Inserta la fecha de reserva
     *
     * @param fechaReserva
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    /**
     * Devuelve la fecha de la entrega prevista
     *
     * @return fechaEntrega
     */
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Inserta la fecha de la entrega prevista
     *
     * @param fechaEntrega
     */
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
