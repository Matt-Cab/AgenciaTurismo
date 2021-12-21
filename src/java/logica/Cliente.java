package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Persona implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int idCliente;
    
    @Basic
    private boolean habilitado;
    @OneToMany
    private List<Venta> listaVentas;

    public Cliente() {
        this.habilitado = true;
    }

    public Cliente(int idCliente, List<Venta> listaVentas, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, Date fechaNac) {
        super(nombre, apellido, direccion, dni, nacionalidad, celular, email, fechaNac);
        this.idCliente = idCliente;
        this.listaVentas = listaVentas;
        this.habilitado = true;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

}
