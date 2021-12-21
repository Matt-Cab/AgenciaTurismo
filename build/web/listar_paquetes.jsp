<%@page import="logica.Servicio"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Paquete"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listar Paquetes</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/tablas.css">
        <link rel="stylesheet" href="./assets/css/listado.css">
        <script defer src="./assets/js/confirmar_eliminacion.js"></script>
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
        <h1>Listar Paquetes</h1>
        <section class="listaServicios">
            <table class="listar">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Servicios Incluidos</th>
                        <th>Precio</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Paquete> listaPaquetes = (List) request.getSession().getAttribute("listaPaquetes"); %>
                    <% if (listaPaquetes == null) { %>
                <h2>No hay paquetes para mostrar</h2>
                <% } else {
                    for (Paquete paquete : listaPaquetes) {
                        if (paquete.isHabilitado()) {%>
                <tr>
                    <td><%= paquete.getCodigoPaquete()%></td>
                    <td>
                        <ul class="lista_servicios">
                            <% for (Servicio servicio : paquete.getListaServicios()) { %>
                            <% if (servicio.isHabilitado()) {%>
                            <li><%= servicio.getNombreServicio()%></li>
                                <% } %>
                                <% }%>
                        </ul>
                    </td>
                    <td><%= paquete.getPrecioPaquete()%></td>
                    <td class="btnsAcciones">
                        <form action="SvPaqueteModificar" method="POST">
                            <input class="oculto" type="hidden" name="codigoPaquete" value="<%= paquete.getCodigoPaquete()%>">
                            <button class="btn-action btn-modify" type="submit">Modificar</button>
                        </form>
                        <form action="SvPaqueteEliminar" method="POST">
                            <input class="oculto" type="hidden" name="codigoPaquete" value="<%= paquete.getCodigoPaquete()%>">
                            <button class="btn-action btn-delete" type="submit">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <% } %>
                <% } %>
                <% }%>

                </tbody>
            </table>
                <a class="btnAgregar" href="alta_paquete.jsp">Agregar Paquete</a>
        </section>
                <% } %>
    </body>
</html>