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
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int idEmpleado;
    
    @Basic
    private String cargo;
    private double sueldo;
    private boolean habilitado;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Venta> listaVentas;

    public Empleado() {
        this.habilitado = true;
    }

    public Empleado(int idEmpleado, String cargo, double sueldo, Usuario usuario, List<Venta> listaVentas, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, Date fechaNac) {
        super(nombre, apellido, direccion, dni, nacionalidad, celular, email, fechaNac);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
        this.habilitado = true;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
