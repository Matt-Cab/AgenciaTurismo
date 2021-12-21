package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import logica.Venta;

@WebServlet(name = "SvServicioEliminar", urlPatterns = {"/SvServicioEliminar"})
public class SvServicioEliminar extends HttpServlet {

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

        int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
        Servicio servicio = controladora.obtenerServicio(codigoServicio);

        controladora.borradoLogicoServicio(servicio);

        // verifico si los paquetes donde se encontraba el servicio poseen dos a mas servicios,
        // en caso contrario también los deshabilito
        List<Paquete> listaPaquetes = servicio.getListaPaquetes();

        for (Paquete paquete : listaPaquetes) {
            int cantServiciosHabilitados = 0;

            for (Servicio servicioEnPaquete : paquete.getListaServicios()) {
                if (servicioEnPaquete.isHabilitado()) cantServiciosHabilitados++;
            }

            if (cantServiciosHabilitados < 2) {
                controladora.borradoLogicoPaquete(paquete);
                List<Venta> listaVentasDelPaquete = paquete.getListaVentas();

                // también deshabilito las ventas que incluian al paquete
                for (Venta venta : listaVentasDelPaquete) {
                    controladora.borradoLogicoVenta(venta);
                }
            }
        }
        
        HttpSession sesionActual = request.getSession();

        sesionActual.setAttribute("listaServicios", controladora.obtenerListaServicios());
        sesionActual.setAttribute("listaPaquetes", controladora.obtenerListaPaquetes());
        sesionActual.setAttribute("listaVentas", controladora.obtenerListaVentas());
        response.sendRedirect("listar_servicios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
