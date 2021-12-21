<%@page import="logica.Controladora"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Servicio"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alta Paquete</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/tablas.css">
        <link rel="stylesheet" href="./assets/css/mensaje_error.css">
        <script defer src="./assets/js/alta_paquete.js"></script>
    </head>
    <body>
        <% HttpSession sesionActual = request.getSession(); %>
        <% if (sesionActual.getAttribute("nombreUsuario") == null) {
                response.sendRedirect("index.jsp");
            } else { %>
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
        <h1>Alta Paquete</h1>
        <form action="SvPaqueteAlta" method="POST">
            <div class="mainContainer">
                <h2>Seleccione los servicios a incluir</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Destino</th>
                            <th>Fecha</th>
                            <th>Precio</th>
                            <th>Incluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% Controladora controladora = new Controladora(); %>
                        <% List<Servicio> listaServicios = controladora.obtenerListaServicios(); %>
                        <% if (listaServicios == null) { %>
                    <h2>No hay servicios para mostrar</h2>
                    <% } else {
                        for (Servicio servicio : listaServicios) {
                            if (servicio.isHabilitado()) {%>
                    <tr>
                        <td><%= servicio.getCodigoServicio()%></td>
                        <td><%= servicio.getNombreServicio()%></td>
                        <td><%= servicio.getDescripcionServicio()%></td>
                        <td><%= servicio.getDestinoServicio()%></td>
                        <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
                        <td><%= simpleDateFormat.format(servicio.getFechaServicio())%></td>
                        <td><%= servicio.getPrecioServicio()%></td>
                        <td class="btnsAcciones">
                            <input type="checkbox" name="servicioSeleccionado" value="<%= servicio.getCodigoServicio()%>">
                        </td>
                    </tr>
                    <% } %>
                    <% } %>
                    <% }%>

                    </tbody>
                </table>
            </div>
            <input class="submitBtn" type="submit" value="Crear Paquete">
        </form>

        <!-- Ventana modal para mostrar mensaje de error -->
        <div class="custom-modal-container">
            <div class="custom-modal">
                <h2 class="custom-modal__message">Debe seleccionar 2 o más servicios.</h2>
                <button class="custom-modal__btn-close">Cerrar</button>
            </div>
        </div>
        <% }%>
    </body>
</html>
