package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T20:36:12")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> numVenta;
    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, Servicio> servicio;
    public static volatile SingularAttribute<Venta, Empleado> empleado;
    public static volatile SingularAttribute<Venta, Boolean> habilitado;
    public static volatile SingularAttribute<Venta, String> medioPago;
    public static volatile SingularAttribute<Venta, Paquete> paquete;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}