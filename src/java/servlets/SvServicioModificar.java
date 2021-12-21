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
import logica.Servicio;

@WebServlet(name = "SvServicioModificar", urlPatterns = {"/SvServicioModificar"})
public class SvServicioModificar extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String nombreServicio = request.getParameter("nombreServicio");
        String descripcionServicio = request.getParameter("descripcionServicio");
        String destinoServicio = request.getParameter("destinoServicio");
        double precioServicio = 0;
        try {
            precioServicio = Double.parseDouble(request.getParameter("precioServicio"));
        }
        catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        
        Date fechaServicio;
        try {
            fechaServicio = format.parse(request.getParameter("fechaServicio"));
        } catch (ParseException ex) {
            System.out.println(ex);
            fechaServicio = new Date();
        }

        int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
        Servicio servicio = controladora.obtenerServicio(codigoServicio);
        servicio.setNombreServicio(nombreServicio);
        servicio.setDescripcionServicio(descripcionServicio);
        servicio.setDestinoServicio(destinoServicio);
        servicio.setPrecioServicio(precioServicio);
        servicio.setFechaServicio(fechaServicio);

        controladora.modificarServicio(servicio);

        request.getSession().setAttribute("listaServicios", controladora.obtenerListaServicios());
        response.sendRedirect("listar_servicios.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
        Servicio servicio = controladora.obtenerServicio(codigoServicio);

        request.getSession().setAttribute("servicio", servicio);
        response.sendRedirect("modificar_servicio.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
