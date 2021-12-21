<%@page import="logica.Venta"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Paquete"%>
<%@page import="logica.Servicio"%>
<%@page import="logica.Empleado"%>
<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de ventas</title>
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
        <% List<Venta> listaVentas = (List) sesionActual.getAttribute("listaVentas");%>
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
        <h1>Listar ventas</h1>
        <section>
                    <table class="listar listaVentas">
            <thead>
                <tr>
                    <th>Número de venta</th>
                    <th>Método de pago</th>
                    <th>Cliente</th>
                    <th>Empleado</th>
                    <th>Servicio o Paquete</th>
                    <th>Fecha de Venta</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% for (Venta venta : listaVentas) { %>
                <% if (venta.isHabilitado()) { %>
                <% Cliente cliente = venta.getCliente();%>
                <% Empleado empleado = venta.getEmpleado();%>
                <% Servicio servicio = venta.getServicio();%>
                <% Paquete paquete = venta.getPaquete();%>
                <% double precio = 0;%>
                <tr>
                    <td><%= venta.getNumVenta()%></td>
                    <td><%= venta.getMedioPago()%></td>
                    <td>
                        <ul>
                            <li><%= cliente.getNombre() + " " + cliente.getApellido()%></li>
                            <li><%= "DNI: " + cliente.getDni()%></li>
                        </ul>
                    </td>
                    <td>
                        <ul>
                            <li><%= empleado.getNombre() + " " + empleado.getApellido()%></li>
                            <li><%= "DNI: " + empleado.getDni()%></li>
                        </ul>
                    </td>
                    <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); %>
                    <% if (servicio != null) { %>
                    <% precio = servicio.getPrecioServicio();%>
                    <td>
                        <ul>
                            <li><%= servicio.getNombreServicio()%>
                                <ul>
                                    <li>
                                        <%= servicio.getDescripcionServicio()%>
                                    </li>
                                    <li>
                                        Destino: <%= servicio.getDestinoServicio()%>
                                    </li>
                                    <li>
                                        Fecha: <%= simpleDateFormat.format(servicio.getFechaServicio())%>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </td>
                    <% } else if (paquete != null) { %>
                    <% precio = paquete.getPrecioPaquete(); %>
                    <td>
                        <% for (Servicio servicioEnPaquete : paquete.getListaServicios()) {%>
                        <ul>
                            <li><%= servicioEnPaquete.getNombreServicio()%>
                                <ul>
                                    <li>
                                        <%= servicioEnPaquete.getDescripcionServicio()%>
                                    </li>
                                    <li>
                                        Destino: <%= servicioEnPaquete.getDestinoServicio()%>
                                    </li>
                                    <li>
                                        Fecha: <%= simpleDateFormat.format(servicioEnPaquete.getFechaServicio())%>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <% } %>
                    </td>
                    <% }%>
                    <td><%= simpleDateFormat.format(venta.getFechaVenta())%></td>
                    <td>$ <%= precio%></td>
                    <td class="btnsAcciones">
                        <form action="SvVentaModificar" method="POST" accept-charset="utf-8">
                            <input class="oculto" type="hidden" name="numeroVenta" value="<%= venta.getNumVenta()%>">
                            <button class="btn-action btn-modify" type="submit">Modificar</button>
                        </form>
                        <form action="SvVentaEliminar" method="POST" accept-charset="utf-8">
                            <input class="oculto" type="hidden" name="numeroVenta" value="<%= venta.getNumVenta()%>">
                            <button class="btn-action btn-delete" type="submit">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <% }%>
                <% }%>
            </tbody>
        </table>
            <a class="btnAgregar" href="alta_venta.jsp">Agregar Venta</a>
        </section>
            <% } %>
            
    </body>
</html>