package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Empleado;
import logica.Usuario;
import logica.Venta;

@WebServlet(name = "SvEmpleadoEliminar", urlPatterns = {"/SvEmpleadoEliminar"})
public class SvEmpleadoEliminar extends HttpServlet {

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

// --- pasos para borrado fisico ---
//        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
//
//        controladora.eliminarEmpleado(idEmpleado);
//
//        request.getSession().setAttribute("listaEmpleados", controladora.obtenerListaEmpleados());
//
//        response.sendRedirect("listar_empleados.jsp");

// --- pasos para borrado lógico ---
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleado empleado = controladora.obtenerEmpleado(idEmpleado);
        int idUsuario = empleado.getUsuario().getIdUsuario();
        Usuario usuario = controladora.obtenerUsuario(idUsuario);

        controladora.borradoLogicoUsuario(usuario);
        controladora.borradoLogicoEmpleado(empleado);

        // al deshabilitar empleado, también deshabilito las ventas que lo involucran.
        List<Venta> listaVentas = empleado.getListaVentas();

        for (Venta venta: listaVentas) {
            controladora.borradoLogicoVenta(venta);
        }

        request.getSession().setAttribute("listaEmpleados", controladora.obtenerListaEmpleados());
        response.sendRedirect("listar_empleados.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
