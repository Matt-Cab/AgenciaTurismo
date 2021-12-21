package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

@WebServlet(name = "SvClienteAlta", urlPatterns = {"/SvClienteAlta"})
public class SvClienteAlta extends HttpServlet {

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

        boolean creacionExitosa = controladora.crearCliente(nombre, apellido, direccion, dni, fechaNac, nacionalidad, celular, email);

        if (creacionExitosa) {
            request.getSession().setAttribute("altaClienteFallida", false);
            request.getSession().setAttribute("listaClientes", controladora.obtenerListaClientes());
            response.sendRedirect("listar_clientes.jsp");
        }
        else {
            request.getSession().setAttribute("altaClienteFallida", true);
            response.sendRedirect("alta_cliente.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
