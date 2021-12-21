package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Usuario;
import logica.Venta;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T20:36:12")
@StaticMetamodel(Empleado.class)
public class Empleado_ extends Persona_ {

    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, Double> sueldo;
    public static volatile SingularAttribute<Empleado, Usuario> usuario;
    public static volatile SingularAttribute<Empleado, Boolean> habilitado;
    public static volatile ListAttribute<Empleado, Venta> listaVentas;
    public static volatile SingularAttribute<Empleado, String> cargo;

}