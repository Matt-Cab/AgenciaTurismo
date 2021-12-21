package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Venta;

@WebServlet(name = "SvVentaAlta", urlPatterns = {"/SvVentaAlta"})
public class SvVentaAlta extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        List<Cliente> listaClientes = controladora.obtenerListaClientes();
//        List<Empleado> listaEmpleados = controladora.obtenerListaEmpleados();
//        List<Servicio> listaServicios = controladora.obtenerListaServicios();
//        List<Paquete> listaPaquetes = controladora.obtenerListaPaquetes();
//
//        HttpSession sesionActual = request.getSession();
//
//        sesionActual.setAttribute("listaClientes", listaClientes);
//        sesionActual.setAttribute("listaEmpleados", listaEmpleados);
//        sesionActual.setAttribute("listaServicios", listaServicios);
//        sesionActual.setAttribute("listaPaquetes", listaPaquetes);
//
//        response.sendRedirect("alta_venta.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idEmpleado = Integer.parseInt(request.getParameter("empleado"));

        Empleado empleado = controladora.obtenerEmpleado(idEmpleado);
        Cliente cliente = controladora.obtenerCliente(idCliente);
        String metodoPago = request.getParameter("metodoPago");
        String campoSeleccionado = request.getParameter("campoSeleccionado");
        Servicio servicio = null;
        Paquete paquete = null;
        Date fechaVenta;

        try {
            fechaVenta = format.parse(request.getParameter("fechaVenta"));
        } catch (ParseException ex) {
            System.out.println(ex);
            fechaVenta = new Date();
        }

        if (campoSeleccionado.equals("servicio")) {
            int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
            servicio = controladora.obtenerServicio(codigoServicio);
        }
        else if (campoSeleccionado.equals("paquete")) {
            int codigoPaquete = Integer.parseInt(request.getParameter("codigoPaquete"));
            paquete = controladora.obtenerPaquete(codigoPaquete);
        }

        controladora.crearVenta(fechaVenta, metodoPago, cliente, empleado, servicio, paquete);

        request.getSession().setAttribute("listaVentas", controladora.obtenerListaVentas());
        response.sendRedirect("listar_ventas.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
