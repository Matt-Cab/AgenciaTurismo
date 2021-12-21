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

@WebServlet(name = "SvServicioAlta", urlPatterns = {"/SvServicioAlta"})
public class SvServicioAlta extends HttpServlet {

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

        String nombreServicio = request.getParameter("nombreServicio");
        String descripcionServicio = request.getParameter("descripcionServicio");
        String destinoServicio = request.getParameter("destinoServicio");

        double precioServicio = 0;
        try {
            precioServicio = Double.parseDouble(request.getParameter("precioServicio"));
        }
        catch (NumberFormatException ex){
            System.out.println(ex);
        }
    
        Date fechaNac;
        try {
            fechaNac = format.parse(request.getParameter("fechaServicio"));
        } catch (ParseException ex) {
            System.out.println(ex);
            fechaNac = new Date();
        }

        boolean creacionExitosa = controladora.crearServicio(nombreServicio, descripcionServicio, destinoServicio, precioServicio, fechaNac);

        if (creacionExitosa) {
            request.getSession().setAttribute("listaServicios", controladora.obtenerListaServicios());
            response.sendRedirect("listar_servicios.jsp");
        }
        else {
            response.sendRedirect("alta_servicio.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
