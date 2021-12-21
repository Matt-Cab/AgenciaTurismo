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

@WebServlet(name = "SvEmpleadoAlta", urlPatterns = {"/SvEmpleadoAlta"})
public class SvEmpleadoAlta extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

        boolean creacionExitosa = controladora.crearEmpleado(nombre, apellido, direccion, dni, fechaNac, nacionalidad, celular, email, cargo, sueldo, nombreUsuario, password);

        if (creacionExitosa) {
            request.getSession().setAttribute("altaEmpleadoFallida", false);
            request.getSession().setAttribute("listaEmpleados", controladora.obtenerListaEmpleados());
            response.sendRedirect("listar_empleados.jsp");
        }
        else {
            request.getSession().setAttribute("altaEmpleadoFallida", true);
            response.sendRedirect("alta_empleado.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
