package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Venta;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T20:36:12")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Persona_ {

    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Boolean> habilitado;
    public static volatile ListAttribute<Cliente, Venta> listaVentas;

}