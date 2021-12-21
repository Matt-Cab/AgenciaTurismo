package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Paquete;
import logica.Venta;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T20:36:12")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> nombreServicio;
    public static volatile SingularAttribute<Servicio, String> descripcionServicio;
    public static volatile SingularAttribute<Servicio, Integer> codigoServicio;
    public static volatile SingularAttribute<Servicio, String> destinoServicio;
    public static volatile ListAttribute<Servicio, Paquete> listaPaquetes;
    public static volatile SingularAttribute<Servicio, Boolean> habilitado;
    public static volatile ListAttribute<Servicio, Venta> listaVentas;
    public static volatile SingularAttribute<Servicio, Date> fechaServicio;
    public static volatile SingularAttribute<Servicio, Double> precioServicio;

}