package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Venta;

@WebServlet(name = "SvVentaEliminar", urlPatterns = {"/SvVentaEliminar"})
public class SvVentaEliminar extends HttpServlet {

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

        int numeroVenta = Integer.parseInt(request.getParameter("numeroVenta"));
        Venta venta = controladora.obtenerVenta(numeroVenta);

        controladora.borradoLogicoVenta(venta);

        request.getSession().setAttribute("listaVentas", controladora.obtenerListaVentas());
        response.sendRedirect("listar_ventas.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
