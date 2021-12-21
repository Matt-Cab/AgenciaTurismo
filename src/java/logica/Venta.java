package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int numVenta;
    
    @Basic
    private boolean habilitado;
    private String medioPago;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private Servicio servicio;
    @ManyToOne
    private Paquete paquete;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    public Venta() {
        this.habilitado = true;
    }

    public Venta(int numVenta, String medioPago, Cliente cliente, Empleado empleado, Servicio servicio, Paquete paquete, Date fechaVenta) {
        this.numVenta = numVenta;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.paquete = paquete;
        this.fechaVenta = fechaVenta;
        this.habilitado = true;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

}
