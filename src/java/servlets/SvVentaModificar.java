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
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Venta;

@WebServlet(name = "SvVentaModificar", urlPatterns = {"/SvVentaModificar"})
public class SvVentaModificar extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        int numeroVenta = Integer.parseInt(request.getParameter("numeroVenta"));

        Cliente cliente = controladora.obtenerCliente(idCliente);
        Empleado empleado = controladora.obtenerEmpleado(idEmpleado);
        String metodoPago = request.getParameter("metodoPago");
        Venta venta = controladora.obtenerVenta(numeroVenta);
        Servicio servicio = null;
        Paquete paquete = null;

        Date fechaVenta;

        try {
            fechaVenta = format.parse(request.getParameter("fechaVenta"));
        } catch (ParseException ex) {
            System.out.println(ex);
            fechaVenta = new Date();
        }

        String campoSeleccionado = request.getParameter("campoSeleccionado");

        if (campoSeleccionado.equals("servicio")) {
            int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
            servicio = controladora.obtenerServicio(codigoServicio);
        }
        else if (campoSeleccionado.equals("paquete")) {
            int codigoPaquete = Integer.parseInt(request.getParameter("codigoPaquete"));
            paquete = controladora.obtenerPaquete(codigoPaquete);
        }

        venta.setCliente(cliente);
        venta.setEmpleado(empleado);
        venta.setFechaVenta(fechaVenta);
        venta.setMedioPago(metodoPago);
        venta.setPaquete(paquete);
        venta.setServicio(servicio);

        controladora.modificarVenta(venta);
        request.getSession().setAttribute("listaVentas", controladora.obtenerListaVentas());
        response.sendRedirect("listar_ventas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int numeroVenta = Integer.parseInt(request.getParameter("numeroVenta"));
        Venta venta = controladora.obtenerVenta(numeroVenta);

        request.getSession().setAttribute("venta", venta);
        response.sendRedirect("modificar_venta.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
