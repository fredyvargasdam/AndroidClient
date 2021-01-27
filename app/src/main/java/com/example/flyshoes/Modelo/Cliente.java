package com.example.flyshoes.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Set;


/**
 * Entidad Cliente, hereda de Usuario, del cual tiene sus atributos. Esta
 * relacionada con Reserva (OneToMany) y Vendedor (ManyToOne).
 *
 * @autorh Nadir
 */

@Root(strict = false,name="Cliente")
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    /*
    * Cliente se relación con reservas via OneToMany
     */
    @ElementList(inline = true)
    private Set<Reserva> reservas;

    /*
    * Cliente se relación con reservas via ManyToOne
     */
    @Element
    private Vendedor vendedor;

    /**
     *
     * @return reservas, retorna las reservas de un Cliente.
     */

    public Set<Reserva> getReservas() {
        return reservas;
    }

    /**
     *
     * @param reservas, Creamos las reservas de un Cliente.
     */
    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     *
     * @return vendedor, retorna el vendedor de los Clientes.
     */

    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     *
     * @param vendedor, Creamos el vendedor de los Clientes.
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
