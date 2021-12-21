package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Controladora;
import logica.Venta;

@WebServlet(name = "SvClienteEliminar", urlPatterns = {"/SvClienteEliminar"})
public class SvClienteEliminar extends HttpServlet {

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
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = controladora.obtenerCliente(idCliente);

        controladora.borradoLogicoCliente(cliente);

        // al deshabilitar cliente, también deshabilito las ventas que lo involucran.
        List<Venta> listaVentas = cliente.getListaVentas();

        for (Venta venta: listaVentas) {
            controladora.borradoLogicoVenta(venta);
        }

        request.getSession().setAttribute("listaClientes", controladora.obtenerListaClientes());
        response.sendRedirect("listar_clientes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
