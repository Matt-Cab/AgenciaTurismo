package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int codigoServicio;
    
    @Basic
    private String nombreServicio;
    private String descripcionServicio;
    private String destinoServicio;
    private double precioServicio;
    private boolean habilitado;
    @ManyToMany
    private List<Paquete> listaPaquetes;
    @OneToMany
    private List<Venta> listaVentas;
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;

    public Servicio() {
        this.habilitado = true;
    }

    public Servicio(int codigoServicio, String nombreServicio, String descripcionServicio, String destinoServicio, double precioServicio, List<Paquete> listaPaquetes, List<Venta> listaVentas, Date fechaServicio) {
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.destinoServicio = destinoServicio;
        this.precioServicio = precioServicio;
        this.listaPaquetes = listaPaquetes;
        this.listaVentas = listaVentas;
        this.fechaServicio = fechaServicio;
        this.habilitado = true;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

}
