<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listar Clientes</title>
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
        <h1>Lista de Clientes</h1>
        <section class="listaClientes">
            <table class="listar">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Dirección</th>
                        <th>DNI</th>
                        <th>Fecha Nac.</th>
                        <th>Nacionalidad</th>
                        <th>Celular</th>
                        <th>Email</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Cliente> listaClientes = (List) request.getSession().getAttribute("listaClientes"); %>

                    <% for (Cliente cliente : listaClientes) { %>
                    <% if (cliente.isHabilitado()) {%>
                    <tr>
                        <td><%= cliente.getIdCliente()%></td>
                        <td><%= cliente.getNombre()%></td>
                        <td><%= cliente.getApellido()%></td>
                        <td><%= cliente.getDireccion()%></td>
                        <td><%= cliente.getDni()%></td>
                        <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
                        <td><%= simpleDateFormat.format(cliente.getFechaNac())%></td>
                        <td><%= cliente.getNacionalidad()%></td>
                        <td><%= cliente.getCelular()%></td>
                        <td><%= cliente.getEmail()%></td>
                        <td class="btnsAcciones">
                            <form action="SvClienteModificar" method="POST" accept-charset="utf-8">
                                <input class="oculto" type="hidden" name="idCliente" value="<%= cliente.getIdCliente()%>">
                                <button class="btn-action btn-modify" type="submit">Modificar</button>
                            </form>
                            <form action="SvClienteEliminar" method="POST" accept-charset="utf-8">
                                <input class="oculto" type="hidden" name="idCliente" value="<%= cliente.getIdCliente()%>">
                                <button class="btn-action btn-delete" type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                    <% }%>

                </tbody>
            </table>
                    <a class="btnAgregar" href="alta_cliente.jsp">Agregar Cliente</a>
        </section>
                    <% }%>
    </body>
</html>