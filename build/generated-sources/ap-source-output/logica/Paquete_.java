package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Servicio;
import logica.Venta;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T20:36:12")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, Double> precioPaquete;
    public static volatile SingularAttribute<Paquete, Integer> codigoPaquete;
    public static volatile ListAttribute<Paquete, Servicio> listaServicios;
    public static volatile SingularAttribute<Paquete, Boolean> habilitado;
    public static volatile ListAttribute<Paquete, Venta> listaVentas;

}