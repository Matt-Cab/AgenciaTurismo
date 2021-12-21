<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Servicio"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listar Servicios</title>
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
        <h1>Listar Servicios</h1>
        <section class="listaServicios">
            <table class="listar">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Destino</th>
                        <th>Fecha</th>
                        <th>Precio</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Servicio> listaServicios = (List) sesionActual.getAttribute("listaServicios"); %>
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
                        <form action="SvServicioModificar" method="POST" accept-charset="utf-8">
                            <input class="oculto" type="hidden" name="codigoServicio" value="<%= servicio.getCodigoServicio()%>">
                            <button class="btn-action btn-modify" type="submit">Modificar</button>
                        </form>
                        <form action="SvServicioEliminar" method="POST" accept-charset="utf-8">
                            <input class="oculto" type="hidden" name="codigoServicio" value="<%= servicio.getCodigoServicio()%>">
                            <button class="btn-action btn-delete" type="submit">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <% } %>
                <% } %>
                <% }%>

                </tbody>
            </table>
                <a class="btnAgregar" href="alta_servicio.jsp">Agregar Servicio</a>
        </section>
                <% } %>
    </body>
</html>