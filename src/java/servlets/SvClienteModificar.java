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

@WebServlet(name = "SvClienteModificar", urlPatterns = {"/SvClienteModificar"})
public class SvClienteModificar extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        
        Date fechaNac;
        try {
            fechaNac = format.parse(request.getParameter("fechaNac"));
        } catch (ParseException ex) {
            System.out.println(ex);
            fechaNac = new Date();
        }

        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = controladora.obtenerCliente(idCliente);

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFechaNac(fechaNac);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);

        controladora.modificarCliente(cliente);

        request.getSession().setAttribute("listaClientes", controladora.obtenerListaClientes());
        response.sendRedirect("listar_clientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCLiente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = controladora.obtenerCliente(idCLiente);

        request.getSession().setAttribute("cliente", cliente);
        response.sendRedirect("modificar_cliente.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
