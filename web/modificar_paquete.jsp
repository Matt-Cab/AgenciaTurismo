<%@page import="logica.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="logica.Paquete"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modificar Pquete</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/tablas.css">
        <link rel="stylesheet" href="./assets/css/mensaje_error.css">
        <script defer src="./assets/js/modificar_paquete.js"></script>
        
        <style>
            form {
                display: flex;
                flex-direction: column;
                align-items: center;
            }
        </style>
    </head>
    <body>
                <% HttpSession sesionActual = request.getSession(); %>
        <% if (sesionActual.getAttribute("nombreUsuario") == null) {
         response.sendRedirect("index.jsp"); 
        } else { %>
        <%  List<Servicio> listaServicios = (List) sesionActual.getAttribute("listaServicios");
            Paquete paquete = (Paquete) sesionActual.getAttribute("paquete");
            List<Integer> codigosServiciosEnPaquete = (List) sesionActual.getAttribute("codigosServiciosEnPaquete");%>
        <header>
            <nav class="menu-navegacion">
                <ul>
                    <li class="link-item"><a href="administrar.jsp">Panel Principal</a></li>
                    <li class="link-item"><a href="SvEmpleadoListar">Ver lista de Empleados</a></li>
                    <li class="link-item"><a href="SvClienteListar">Ver lista de Clientes</a></li>
                    <li class="link-item"><a href="SvServicioListar">Ver lista de Servicios</a></li>
                    <li class="link-item"><a href="SvPaqueteListar">Ver lista de Paquetes</a></li>
                    <li class="link-item"><a href="SvVentaListar">Ver lista de Ventas</a></li>
                </ul>
            </nav>
        </header>

        <h1>Modificar Paquete</h1>
        <section class="modificar">
            <form action="SvPaqueteModificar" method="GET" accept-charset="utf-8">
                <table>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Servicios a incluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= paquete.getCodigoPaquete()%></td>
                            <td>
                                <ul class="lista_servicios">
                                    <% for (Servicio servicio : listaServicios) {%>
                                    <% if (servicio.isHabilitado()) { %>
                                    <li>
                                        <%= servicio.getNombreServicio()%>
                                        <% boolean servicioEstaEnPaquete = codigosServiciosEnPaquete.contains(servicio.getCodigoServicio());%>
                                        <input type="checkbox" name="servicioSeleccionado" <%= servicioEstaEnPaquete ? "checked" : ""%> value="<%= servicio.getCodigoServicio()%>">
                                    </li>
                                    <% } %>
                                    <% }%>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" name="codigoPaquete" value="<%= paquete.getCodigoPaquete()%>">
                <input class="submitBtn" type="submit" value="Guardar Cambios">
            </form>
        </section>

                
    <!-- Ventana modal para mostrar mensaje de error -->
    <div class="custom-modal-container">
        <div class="custom-modal">
            <h2 class="custom-modal__message">Debe seleccionar 2 o más servicios.</h2>
            <button class="custom-modal__btn-close">Cerrar</button>
        </div>
    </div>
                
        <footer>

        </footer>
    
    <% } %>
    </body>
</html>