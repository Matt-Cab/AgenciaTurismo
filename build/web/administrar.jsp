<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Administración</title>
    <link rel="stylesheet" href="./assets/css/general.css">
    <link rel="stylesheet" href="./assets/css/administrar.css">
</head>
    <body>
        <% HttpSession sesionActual = request.getSession(); %>
        <% if (sesionActual.getAttribute("nombreUsuario") == null) {
         response.sendRedirect("index.jsp"); 
        } else { %>
        <header>
            <h2 class="bienvenida">Bienvenido <%= session.getAttribute("nombreUsuario") %></h2>
        </header>

        <h1 class="titulo" >Administrar</h1>

        <div class="container">
            <div class="menu empleados">
                <h3>Empleados</h3>
                <ul class="opciones">
                    <li>
                        <a href="alta_empleado.jsp">Alta</a>
                    </li>
                    <li>
                        <a href="SvEmpleadoListar">Listado, baja y modificación</a>
                    </li>
                </ul>
            </div>
            <div class="menu clientes">
                <h3>Clientes</h3>
                <ul class="opciones">
                    <li>
                        <a href="alta_cliente.jsp">Alta</a>
                    </li>
                    <li>
                        <a href="SvClienteListar">Listado, baja y modificación</a>
                    </li>
                </ul>
            </div>
            <div class="menu servicios">
                <h3>Servicios</h3>
                <ul class="opciones">
                    <li>
                        <a href="alta_servicio.jsp">Alta</a>
                    </li>
                    <li>
                        <a href="SvServicioListar">Listado, baja y modificación</a>
                    </li>
                </ul>
            </div>
            <div class="menu paquetes">
                <h3>Paquetes</h3>
                <ul class="opciones">
                    <li>
                        <a href="alta_paquete.jsp">Crear nuevo paquete</a>
                    </li>
                    <li>
                        <a href="SvPaqueteListar">Listado, baja y modificación</a>
                    </li>
                </ul>
            </div>
            <div class="menu ventas">
                <h3>Ventas</h3>
                <ul class="opciones">
                   <li>
                        <a href="alta_venta.jsp">Crear nueva venta</a>
                    </li>
                    <li>
                        <a href="SvVentaListar">Listado, baja y modificación</a>
                    </li>
                </ul>
            </div>
             <div class="menu sesion">
                <h3>Sesión</h3>
                <ul class="opciones">
                   <li>
                        <a href="SvUsuarioLogout">Cerrar Sesión</a>
<!--                        <form action="SvUsuarioLogout" method="POST" accept-charset="utf-8">
                            
                        <button type="submit">Cerrar Sesión</button>
                        </form>-->
                    </li>
                </ul>
            </div>
        </div>
        <% } %>
    </body>
</html>
