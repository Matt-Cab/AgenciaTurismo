package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete;
import logica.Venta;

@WebServlet(name = "SvPaqueteEliminar", urlPatterns = {"/SvPaqueteEliminar"})
public class SvPaqueteEliminar extends HttpServlet {

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

        int codigoPaquete = Integer.parseInt(request.getParameter("codigoPaquete"));
        Paquete paquete = controladora.obtenerPaquete(codigoPaquete);
        List<Venta> listaVentas = paquete.getListaVentas();

        for (Venta venta : listaVentas) {
            controladora.borradoLogicoVenta(venta);
        }

        controladora.borradoLogicoPaquete(paquete);

        request.getSession().setAttribute("listaVentas", controladora.obtenerListaVentas());
        request.getSession().setAttribute("listaPaquetes", controladora.obtenerListaPaquetes());
        response.sendRedirect("listar_paquetes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
