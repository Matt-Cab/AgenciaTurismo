package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controladoraPers = new ControladoraPersistencia();


    public int buscarUsuario(Usuario usuario) {

        List<Usuario> listaUsuarios = controladoraPers.obtenerListaUsuarios();
        String nombreUsuario = usuario.getNombreUsuario();

        // verifico que el nombre de usuario no fuera utilizado con anterioridad
        for (Usuario usuarioActual : listaUsuarios) {
            if (usuarioActual.getNombreUsuario().equals(nombreUsuario)) {
                return usuarioActual.getIdUsuario();
            }
        }

        return -1;
    }

// ----------------------------- MANEJO EMPLEADOS ------------------------------

    public boolean DNIEmpleadoYaUtilizado(String dni) {
        for (Empleado empleadoActual : this.obtenerListaEmpleados()) {
            if (empleadoActual.getDni().equals(dni)) {
                return true;
            }
        }

        return false;
    }

    public boolean crearEmpleado(String nombre, String apellido, String direccion, String dni, Date fechaNac, String nacionalidad, String celular, String email, String cargo, double sueldo, String nombreUsuario, String password) {
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        
        if (!this.DNIEmpleadoYaUtilizado(dni) && this.buscarUsuario(usuario) == -1) {
            Empleado empleado = new Empleado();

            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setDireccion(direccion);
            empleado.setDni(dni);
            empleado.setFechaNac(fechaNac);
            empleado.setNacionalidad(nacionalidad);
            empleado.setCelular(celular);
            empleado.setEmail(email);
            empleado.setCargo(cargo);
            empleado.setSueldo(sueldo);
            empleado.setUsuario(usuario);

            return controladoraPers.crearEmpleado(empleado, usuario);
        }

        return false;
    }

    public List<Empleado> obtenerListaEmpleados() {
        return controladoraPers.obtenerListaEmpleados();
    }

    public Empleado obtenerEmpleado(int idEmpleado) {
        return controladoraPers.obtenerEmpleado(idEmpleado);
    }

    public void modificarEmpleado(Empleado empleado) {
        controladoraPers.modificarEmpleado(empleado);
    }

    public void eliminarEmpleado(int idEmpleado) {
        controladoraPers.eliminarEmpleado(idEmpleado);
    }

    public void borradoLogicoEmpleado(Empleado empleado) {
        empleado.setHabilitado(false);

        controladoraPers.modificarEmpleado(empleado);
    }

// ----------------------------- MANEJO USUARIOS ------------------------------

    public Usuario obtenerUsuario(int idUsuario) {
        return controladoraPers.obtenerUsuario(idUsuario);
    }

    public boolean verificarUsuario(String nombreUsuario, String password) {
        List<Usuario> listaUsuarios = controladoraPers.obtenerListaUsuarios();

        if (listaUsuarios != null) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password)) {
                    return usuario.isHabilitado();
                }
            }
        }

        return false;
    }

    public void modificarUsuario(Usuario usuario) {
        controladoraPers.modificarUsuario(usuario);
    }

    public void borradoLogicoUsuario(Usuario usuario) {
        usuario.setHabilitado(false);
        controladoraPers.modificarUsuario(usuario);
    }

// ----------------------------- MANEJO CLIENTES ------------------------------

    public boolean DNIClienteYaUtilizado(String dni) {
        for (Cliente clienteActual : obtenerListaClientes()) {
            if (clienteActual.getDni().equals(dni)) {
                return true;
            }
        }

        return false;
    }

    public boolean crearCliente(String nombre, String apellido, String direccion, String dni, Date fechaNac, String nacionalidad, String celular, String email) {
        System.out.println(this.DNIClienteYaUtilizado(dni));
        if (!this.DNIClienteYaUtilizado(dni)) {
                Cliente cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDireccion(direccion);
                cliente.setDni(dni);
                cliente.setFechaNac(fechaNac);
                cliente.setNacionalidad(nacionalidad);
                cliente.setCelular(celular);
                cliente.setEmail(email);

                return controladoraPers.crearCliente(cliente);
        }

        return false;
    }

    public List<Cliente> obtenerListaClientes() {
        return controladoraPers.obtenerListaClientes();
    }

    public Cliente obtenerCliente(int idCliente) {
        return controladoraPers.obtenerCliente(idCliente);
    }

    public void modificarCliente(Cliente cliente) {
        controladoraPers.modificarCliente(cliente);
    }

    public void eliminarCliente(int idCLiente) {
        controladoraPers.eliminarCliente(idCLiente);
    }

    public void borradoLogicoCliente(Cliente cliente) {
        cliente.setHabilitado(false);
        controladoraPers.modificarCliente(cliente);
    }

// ----------------------------- MANEJO SERVICIOS ------------------------------

    public boolean crearServicio(String nombreServicio, String descripcionServicio, String destinoServicio, double precioServicio, Date fechaServicio) {

        Servicio servicio = new Servicio();
        servicio.setNombreServicio(nombreServicio);
        servicio.setDescripcionServicio(descripcionServicio);
        servicio.setDestinoServicio(destinoServicio);
        servicio.setPrecioServicio(precioServicio);
        servicio.setFechaServicio(fechaServicio);
        servicio.setListaPaquetes(new ArrayList());
        servicio.setListaVentas(new ArrayList());

        return controladoraPers.crearServicio(servicio);

    }

    public Servicio obtenerServicio(int codigoServicio) {
        return controladoraPers.obtenerServicio(codigoServicio);
    }

    public List<Servicio> obtenerListaServicios() {
        return controladoraPers.obtenerListaServicios();
    }

    public void modificarServicio(Servicio servicio) {
        controladoraPers.modificarServicio(servicio);
    }

    public void eliminarServicio(int codigoServicio) {
        controladoraPers.eliminarServicio(codigoServicio);
    }

    public void borradoLogicoServicio(Servicio servicio) {
        servicio.setHabilitado(false);
        controladoraPers.modificarServicio(servicio);
    }

// ----------------------------- MANEJO PAQUETES ------------------------------

    public boolean crearPaquete(String serviciosSeleccionados[]) {
        Paquete paquete = new Paquete();
        Servicio servicio;
        int codigoServicio;
        paquete.setListaServicios(new ArrayList());

        for (String codigoServicioActual : serviciosSeleccionados) {
            codigoServicio = Integer.parseInt(codigoServicioActual);
            servicio = this.obtenerServicio(codigoServicio);
            paquete.agregarServicio(servicio);
        }

        paquete.setPrecioPaquete(paquete.calcularPrecioPaquete());

        return controladoraPers.crearPaquete(paquete);
    }

    public Paquete obtenerPaquete(int codigoPaquete) {
        return controladoraPers.obtenerPaquete(codigoPaquete);
    }

    public List<Paquete> obtenerListaPaquetes() {
        return controladoraPers.obtenerListaPaquetes();
    }

    public void modificarPaquete(Paquete paquete) {
        controladoraPers.modificarPaquete(paquete);
    }

    public void eliminarPaquete(int codigoPaquete) {
        controladoraPers.eliminarPaquete(codigoPaquete);
    }

    public void borradoLogicoPaquete(Paquete paquete) {
        paquete.setHabilitado(false);
        controladoraPers.modificarPaquete(paquete);
    }

// ------------------------------ MANEJO VENTAS ------------------------------
    public boolean crearVenta(Date fechaVenta, String medioPago, Cliente cliente, Empleado empleado, Servicio servicio, Paquete paquete) {

        Venta venta = new Venta();
        venta.setFechaVenta(fechaVenta);
        venta.setMedioPago(medioPago);
        venta.setCliente(cliente);
        venta.setEmpleado(empleado);
        venta.setServicio(servicio);
        venta.setPaquete(paquete);

        return controladoraPers.crearVenta(venta);
    }

    public Venta obtenerVenta(int numVenta) {
        return controladoraPers.obtenerVenta(numVenta);
    }

    public List<Venta> obtenerListaVentas() {
        return controladoraPers.obtenerListaVentas();
    }

    public void modificarVenta(Venta venta) {
        controladoraPers.modificarVenta(venta);
    }

    public void eliminarVenta(int numVenta) {
        controladoraPers.eliminarVenta(numVenta);
    }

    public void borradoLogicoVenta(Venta venta) {
        venta.setHabilitado(false);
        controladoraPers.modificarVenta(venta);
    }
}
