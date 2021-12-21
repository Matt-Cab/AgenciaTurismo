<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Empleado"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listar Empleados</title>
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
        <h1>Lista de Empleados</h1>
        <section class="listaEmpleados">
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
                        <th>Cargo</th>
                        <th>Sueldo</th>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Empleado> listaEmpleados = (List) request.getSession().getAttribute("listaEmpleados"); %>

                    <% for (Empleado empleado : listaEmpleados) { %>
                    <% if (empleado.isHabilitado()) {%>
                    <tr>
                        <td><%= empleado.getIdEmpleado()%></td>
                        <td><%= empleado.getNombre()%></td>
                        <td><%= empleado.getApellido()%></td>
                        <td><%= empleado.getDireccion()%></td>
                        <td><%= empleado.getDni()%></td>
                        <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
                        <td><%= simpleDateFormat.format(empleado.getFechaNac())%></td>
                        <td><%= empleado.getNacionalidad()%></td>
                        <td><%= empleado.getCelular()%></td>
                        <td><%= empleado.getEmail()%></td>
                        <td><%= empleado.getCargo()%></td>
                        <td><%= empleado.getSueldo()%></td>
                        <td><%= empleado.getUsuario().getNombreUsuario()%></td>
                        <td class="passwOculto"><%= empleado.getUsuario().getPassword()%></td>
                        <td class="btnsAcciones">
                            <form action="SvEmpleadoModificar" method="POST" accept-charset="utf-8">
                                <input class="oculto" type="hidden" name="idEmpleado" value="<%= empleado.getIdEmpleado()%>">
                                <button class="btn-action btn-modify" type="submit">Modificar</button>
                            </form>
                            <form action="SvEmpleadoEliminar" method="POST" accept-charset="utf-8">
                                <input class="oculto" type="hidden" name="idEmpleado" value="<%= empleado.getIdEmpleado()%>">
                                <button class="btn-action btn-delete" type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                    <% }%>

                </tbody>
            </table>
                    <a class="btnAgregar" href="alta_empleado.jsp">Agregar Empleado</a>
        </section>
                    <% }%>
    </body>
</html>