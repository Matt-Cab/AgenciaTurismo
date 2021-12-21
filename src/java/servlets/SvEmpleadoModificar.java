package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Empleado;
import logica.Usuario;

@WebServlet(name = "SvEmpleadoModificar", urlPatterns = {"/SvEmpleadoModificar"})
public class SvEmpleadoModificar extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        
        Date fechaNac;
        try {
            fechaNac = format.parse(request.getParameter("fechaNac"));
        } catch (ParseException ex) {
            System.out.println(ex);
            fechaNac = new Date();
        }

        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        double sueldo;
        
        try {
            sueldo = Double.parseDouble(request.getParameter("sueldo"));
        }
        catch (NumberFormatException e) {
            System.out.println(e);
            sueldo = 0;
        }
        
        String nombreUsuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleado empleado = controladora.obtenerEmpleado(idEmpleado);
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

        Usuario usuario = controladora.obtenerUsuario(empleado.getUsuario().getIdUsuario());
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);

        controladora.modificarUsuario(usuario);
        controladora.modificarEmpleado(empleado);

        request.getSession().setAttribute("listaEmpleados", controladora.obtenerListaEmpleados());
        response.sendRedirect("listar_empleados.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleado empleado = controladora.obtenerEmpleado(idEmpleado);

        request.getSession().setAttribute("empleado", empleado);
        response.sendRedirect("modificar_empleado.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
