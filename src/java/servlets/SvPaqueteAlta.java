package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete;
import logica.Servicio;

@WebServlet(name = "SvPaqueteAlta", urlPatterns = {"/SvPaqueteAlta"})
public class SvPaqueteAlta extends HttpServlet {

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

        String serviciosSeleccionados[] = request.getParameterValues("servicioSeleccionado");

        boolean creacionExitosa = controladora.crearPaquete(serviciosSeleccionados);

        if (creacionExitosa) {
            request.getSession().setAttribute("listaPaquetes", controladora.obtenerListaPaquetes());
            response.sendRedirect("listar_paquetes.jsp");
        }
        else {
//            request.getSession().setAttribute("altaPaqueteFallida", true);
            response.sendRedirect("alta_paquete.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
