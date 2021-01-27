package com.example.flyshoes.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Set;


/**
 *
 * @author Lorena Cáceres Manuel
 *
 * Entidad producto está relacionada con la entidad Reserva, vendedor y
 * proveedor. Esta entidad tiene una identificador de producto, una descripción,
 * un precio y una imagen del producto.
 */

@Root(strict = false,name="Producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del producto
     */
    @Element(name="id")
    private Long id;
    /**
     * Descripcion del producto
     */
    @Element(name="descripcion")
    private String descripcion;
    /**
     * Precio del producto
     */
    @Element(name="precio")
    private Float precio;
    /**
     * Imagen del producto
     */
    @Element(name="imagen")
    private byte[] imagen;

    @Element(name="talla")
    private String talla;

    @Element(name="tipo")
    private TipoProducto tipo;

    @Element(name="stock")
    private Integer stock;

    @Element(name="modelo")
    private String modelo;
    @Element(name="disponibilidad")
    private String disponibilidad;
    
    /**
     * Devuelve la fecha de disponibilidad
     * @return 
     */

    public String getDisponibilidad() {
        return disponibilidad;
    }
    /**
     * Inserta la fecha de disponibilidad
     * @param disponibilidad 
     */

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    

    /**
     * Relación con la entidad Reserva
     */
    
    private Set<Reserva> reservas;
    /**
     * Relación con la entidad Proveedor
     */
    
    private Proveedor proveedor;
    /**
     * Relación con la entidad Vendedor
     */
 
    private Set<Vendedor> vendedores;

    /**
     * Devuelve la imagen del producto
     *
     * @return imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Inserta la imagen del producto
     *
     * @param imagen que establecemos
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * Devuelve una lista de reservas
     *
     * @return reseva
     */
   // @XmlTransient
    public Set<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece una lista de reservas
     *
     * @param reserva que establecemos
     */
    public void setReservas(Set<Reserva> reserva) {
        this.reservas = reserva;
    }

    /**
     * Devuelve un proveedor
     *
     * @return proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Establece un proveedor
     *
     * @param proveedor que establecemos
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Devuelve una lista de vendedores
     *
     * @return vendedores, contiene los vendedores que han gestionado un
     * producto
     */
  //  @XmlTransient
    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    /**
     * Establece una lista de vendedores
     *
     * @param vendedores que establecemos
     */
    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    /**
     * Devuelve una descripcion del producto
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece una descripcion del producto
     *
     * @param descripcion que estableceremos
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el precio del producto
     *
     * @return precio
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     *
     * @param precio que estableceremos
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la id del producto
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la id del producto
     *
     * @param id que estableceremos
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Devuelve la talla del producto
     *
     * @return talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Establece la talla del producto
     *
     * @param talla
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Devuelve el tipo del producto
     *
     * @return tipo. Zapatillas. Ropa
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del producto
     *
     * @param tipo
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la cantidad en stock del producto
     *
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece la cantidad en stock del producto
     *
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Devuelve el modelo del producto
     *
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del producto
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Representacion en forma de entero para un producto
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara dos productos. Este método considera que un producto es igual que
     * otro si los identificadores tienen el mismo valor
     *
     * @param object El otro producto que compararemos
     * @return true si son iguales
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Obtenemos una representacion en forma de String del producto
     *
     * @return
     */
    @Override
    public String toString() {
        return "flyshoes.entity.Producto[ id=" + id + " ]";
    }

}
