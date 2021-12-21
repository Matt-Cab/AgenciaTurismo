package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Paquete implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoPaquete;
    
    @Basic
    private double precioPaquete;
    private boolean habilitado;
    @ManyToMany
    private List<Servicio> listaServicios;
    @OneToMany
    private List<Venta> listaVentas;

    public Paquete() {
        this.habilitado = true;
    }

    public Paquete(int codigoPaquete, double precioPaquete, List<Servicio> listaServicios, List<Venta> listaVentas) {
        this.codigoPaquete = codigoPaquete;
        this.precioPaquete = precioPaquete;
        this.listaServicios = listaServicios;
        this.listaVentas = listaVentas;
        this.habilitado = true;
    }

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public double getPrecioPaquete() {
        return precioPaquete;
    }

    public void setPrecioPaquete(double precioPaquete) {
        this.precioPaquete = precioPaquete;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
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

// --------------------- Métodos personalizados --------------------------------

    public void agregarServicio(Servicio servicio) {
        this.listaServicios.add(servicio);
    }

    public double calcularPrecioPaquete() {
        double precioTotal = 0;

        for (Servicio servicioActual : this.listaServicios) {
            if (servicioActual.isHabilitado()) {
                precioTotal += servicioActual.getPrecioServicio();
            }
        }

        return precioTotal * 0.9;
    }

}
