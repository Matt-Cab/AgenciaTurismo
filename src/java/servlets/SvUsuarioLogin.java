package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

@WebServlet(name = "SvUsuarioLogin", urlPatterns = {"/SvUsuarioLogin"})
public class SvUsuarioLogin extends HttpServlet {

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
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        boolean usuarioExistente = controladora.verificarUsuario(nombreUsuario, password);

        if (usuarioExistente) {
            request.getSession().setAttribute("nombreUsuario", nombreUsuario);
            request.getSession().setAttribute("passwordUsuario", password);
            request.getSession().setAttribute("loginFallido", false);
            response.sendRedirect("administrar.jsp");
        }
        else {
            request.getSession().setAttribute("loginFallido", true);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
