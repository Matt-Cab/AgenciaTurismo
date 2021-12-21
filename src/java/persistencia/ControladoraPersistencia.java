package persistencia;

import java.util.List;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    ClienteJpaController clienteJPAControlador = new ClienteJpaController();
    EmpleadoJpaController empleadoJPAControlador = new EmpleadoJpaController();
    PaqueteJpaController paqueteJPAControlador = new PaqueteJpaController();
    ServicioJpaController servicioJPAControlador = new ServicioJpaController();
    UsuarioJpaController usuarioJPAControlador = new UsuarioJpaController();
    VentaJpaController ventaJPAControlador = new VentaJpaController();

// ----------------------------- MANEJO EMPLEADOS ------------------------------

    public boolean crearEmpleado(Empleado empleado, Usuario usuario) {
        try {
            usuarioJPAControlador.create(usuario);
            empleadoJPAControlador.create(empleado);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        
        return false;
    }

    public Empleado obtenerEmpleado(int idEmpleado) {
        return empleadoJPAControlador.findEmpleado(idEmpleado);
    }

    public List<Empleado> obtenerListaEmpleados() {
        return empleadoJPAControlador.findEmpleadoEntities();
    }

    public void modificarEmpleado(Empleado empleado) {
        try {
            empleadoJPAControlador.edit(empleado);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void eliminarEmpleado(int idEmpleado) {
        try {
            empleadoJPAControlador.destroy(idEmpleado);
        }
        catch (NonexistentEntityException ex) {
            System.out.println(ex);        
        }
    }

    public Usuario obtenerUsuario(int idUsuario) {
        return usuarioJPAControlador.findUsuario(idUsuario);
    }

    public List<Usuario> obtenerListaUsuarios() {
        return usuarioJPAControlador.findUsuarioEntities();
    }

    public void modificarUsuario(Usuario usuario) {
        try {
            usuarioJPAControlador.edit(usuario);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

// ----------------------------- MANEJO CLIENTES ---------------

    public boolean crearCliente(Cliente cliente) {
        try {
            clienteJPAControlador.create(cliente);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }

    public List<Cliente> obtenerListaClientes() {
        return clienteJPAControlador.findClienteEntities();
    }

    public Cliente obtenerCliente(int idCliente) {
        return clienteJPAControlador.findCliente(idCliente);
    }

    public void modificarCliente(Cliente cliente) {
        try {
                clienteJPAControlador.edit(cliente);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void eliminarCliente(int idCLiente) {
        try {
                clienteJPAControlador.destroy(idCLiente);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

// ----------------------------- MANEJO SERVICIOS ---------------

    public boolean crearServicio(Servicio servicio) {
        try {
            servicioJPAControlador.create(servicio);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }

    public Servicio obtenerServicio(int codigoServicio) {
        return servicioJPAControlador.findServicio(codigoServicio);
    }

    public List<Servicio> obtenerListaServicios() {
        return servicioJPAControlador.findServicioEntities();
    }

    public void modificarServicio(Servicio servicio) {
        try {
                servicioJPAControlador.edit(servicio);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void eliminarServicio(int codigoServicio) {
        try {
                servicioJPAControlador.destroy(codigoServicio);
        }
        catch (NonexistentEntityException ex) {
            System.out.println(ex);
        }
    }

// ----------------------------- MANEJO PAQUETES ------------------------------

    public boolean crearPaquete(Paquete paquete) {
        try {
            paqueteJPAControlador.create(paquete);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }

    public Paquete obtenerPaquete(int codigoPaquete) {
        return paqueteJPAControlador.findPaquete(codigoPaquete);
    }

    public List<Paquete> obtenerListaPaquetes() {
        return paqueteJPAControlador.findPaqueteEntities();
    }

    public void modificarPaquete(Paquete paquete) {
        try {
            paqueteJPAControlador.edit(paquete);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void eliminarPaquete(int codigoPaquete) {
        try {
            paqueteJPAControlador.destroy(codigoPaquete);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

// ------------------------------ MANEJO VENTAS ------------------------------
    public boolean crearVenta(Venta venta) {
        try {
            ventaJPAControlador.create(venta);
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public Venta obtenerVenta(int numVenta) {
        return ventaJPAControlador.findVenta(numVenta);
    }

    public List<Venta> obtenerListaVentas() {
        return ventaJPAControlador.findVentaEntities();
    }

    public void modificarVenta(Venta venta) {
        try {
            ventaJPAControlador.edit(venta);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void eliminarVenta(int numVenta) {
        try {
            ventaJPAControlador.destroy(numVenta);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
