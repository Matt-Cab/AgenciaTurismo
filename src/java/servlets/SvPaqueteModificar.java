package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paquete;
import logica.Servicio;

@WebServlet(name = "SvPaqueteModificar", urlPatterns = {"/SvPaqueteModificar"})
public class SvPaqueteModificar extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesionActual = request.getSession();
        int codigoPaquete = Integer.parseInt(request.getParameter("codigoPaquete"));
        Paquete paquete = controladora.obtenerPaquete(codigoPaquete);
        String serviciosSeleccionados[] = request.getParameterValues("servicioSeleccionado");
        List<Servicio> nuevaListaServicios = new ArrayList();
        Servicio servicio;
        int codigoServicio;

        for (String codigoServicioActual : serviciosSeleccionados) {
            codigoServicio = Integer.parseInt(codigoServicioActual);
            servicio = controladora.obtenerServicio(codigoServicio);
            nuevaListaServicios.add(servicio);
        }

        paquete.setListaServicios(nuevaListaServicios);
        paquete.setPrecioPaquete(paquete.calcularPrecioPaquete());

        controladora.modificarPaquete(paquete);

        sesionActual.setAttribute("listaServicios", controladora.obtenerListaServicios());
        sesionActual.setAttribute("listaPaquetes", controladora.obtenerListaPaquetes());
        response.sendRedirect("listar_paquetes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesionActual = request.getSession();
        int codigoPaquete = Integer.parseInt(request.getParameter("codigoPaquete"));
        Paquete paquete = controladora.obtenerPaquete(codigoPaquete);
        List<Integer> codigosServiciosEnPaquete = new ArrayList();

        for (Servicio servicio: paquete.getListaServicios()) {
            codigosServiciosEnPaquete.add(servicio.getCodigoServicio());
        }

        sesionActual.setAttribute("paquete", paquete);
        sesionActual.setAttribute("listaServicios", controladora.obtenerListaServicios());
        sesionActual.setAttribute("codigosServiciosEnPaquete", codigosServiciosEnPaquete);
        response.sendRedirect("modificar_paquete.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
