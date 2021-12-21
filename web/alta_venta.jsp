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
        <title>Generar una venta</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/alta_venta.css">
        <link rel="stylesheet" href="./assets/css/modificar_venta.css">
        <link rel="stylesheet" href="./assets/css/tablas.css">
        <script defer src="./assets/js/alta_venta.js"></script>
    </head>
    <body>
                <% HttpSession sesionActual = request.getSession(); %>
        <% if (sesionActual.getAttribute("nombreUsuario") == null) {
         response.sendRedirect("index.jsp"); 
        } else { %>
        
        <%
            Controladora controladora = new Controladora();
            List<Cliente> listaClientes = controladora.obtenerListaClientes();
            List<Empleado> listaEmpleados = controladora.obtenerListaEmpleados();
            List<Servicio> listaServicios = controladora.obtenerListaServicios();
            List<Paquete> listaPaquetes = controladora.obtenerListaPaquetes();
        %>
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
        <h1>Nueva venta</h1>
        <form  action="SvVentaAlta" method="POST">
            <div class="inputContainer">
                <label for="fechaVenta">Fecha de la venta</label>
                <input required type="date" name="fechaVenta" id="fechaVenta">
            </div>
            <div class="inputContainer">
                <label for="metodoPago">Método de pago</label>
                <select required name="metodoPago" id="metodoPago">
                    <option disabled selected value="">Seleccione un método de pago</option>
                    <option>Tarjeta Crédito</option>
                    <option>Tarjeta Débito</option>
                    <option>Transferencia Bancaria</option>
                    <option>Efectivo</option>
                </select>
            </div>
            <div class="inputContainer">
                <label for="cliente">Cliente</label>
                <select required name="idCliente" id="cliente">
                    <option disabled selected value="">Seleccione un cliente</option>
                    <% for (Cliente cliente : listaClientes) {%>
                    <% if (cliente.isHabilitado()) {%>
                    <option value="<%= cliente.getIdCliente()%>"><%= cliente.getNombre() + " " + cliente.getApellido()%> | DNI: <%= cliente.getDni()%></option>
                    <% }%>
                    <% } %>
                </select>
            </div>
            <div class="inputContainer">
                <label for="empleado">Empleado</label>
                <select required name="empleado" id="empleado">
                    <option disabled selected value="">Seleccione un empleado</option>
                    <% for (Empleado empleado : listaEmpleados) {%>
                    <% if (empleado.isHabilitado()) {%>
                    <option value="<%= empleado.getIdEmpleado()%>"><%= empleado.getNombre() + " " + empleado.getApellido()%> | DNI: <%= empleado.getDni()%></option>
                    <% }%>
                    <% } %>
                </select>
            </div>
            <div class="inputContainer paqueteOServicio">
                <div id="campoSeleccionado">
                    <label class="labelServicio" for="servicio">Servicio
                        <input type="radio" checked name="campoSeleccionado" id="servicio" value="servicio">
                    </label>
                    <label class="labelPaquete" for="paquete">Paquete
                        <input type="radio" name="campoSeleccionado" id="paquete" value="paquete">
                    </label>
                </div>
                <table id="tablaServicios">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Destino</th>
                            <th>Precio</th>
                            <th>Fecha</th>
                            <th>Seleccionar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Servicio servicio : listaServicios) {%>
                        <% if (servicio.isHabilitado()) {%>
                        <tr>
                            <td><%= servicio.getCodigoServicio()%></td>
                            <td><%= servicio.getNombreServicio()%></td>
                            <td><%= servicio.getDescripcionServicio()%></td>
                            <td><%= servicio.getDestinoServicio()%></td>
                            <td><%= servicio.getPrecioServicio()%></td>
                            <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
                            <td><%= simpleDateFormat.format(servicio.getFechaServicio())%></td>
                            <td class="seleccionarServicio">
                                <input class="inputRadioServicio" type="radio" name="codigoServicio" value="<%= servicio.getCodigoServicio()%>">
                            </td>
                        </tr>
                        <% }%>
                        <% }%>
                    </tbody>
                </table>
                <table id="tablaPaquetes" class="tablaOculta">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Servicios Incluidos</th>
                            <th>Precio</th>
                            <th>Seleccionar Paquete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Paquete paquete : listaPaquetes) {%>
                        <% if (paquete.isHabilitado()) {%>
                        <tr>
                            <td><%= paquete.getCodigoPaquete()%></td>
                            <td>
                                <ul class="listaServicios">
                                    <% for (Servicio servicio : paquete.getListaServicios()) { %>
                                    <% if (servicio.isHabilitado()) {%>
                                    <li><%= servicio.getNombreServicio()%>
                                        <ul>
                                            <li><%= servicio.getDescripcionServicio()%></li>
                                        </ul>
                                    </li>
                                    <% }%>
                                    <% }%>
                                </ul>
                            </td>
                            <td>$ <%= paquete.getPrecioPaquete()%></td>
                            <td class="seleccionarPaquete">
                                <input class="inputRadioPaquete" type="radio" name="codigoPaquete" value="<%= paquete.getCodigoPaquete()%>">
                            </td>
                        </tr>
                        <% }%>
                        <% }%>

                    </tbody>
                </table>
            </div>
            <input type="submit" value="Generar Venta">
        </form>
                        
                        <% }%>
    </body>
</html>