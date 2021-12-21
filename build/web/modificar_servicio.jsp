<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Servicio"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modificar Servicio</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/tablas.css">
    </head>
    <body>
                <% HttpSession sesionActual = request.getSession(); %>
        <% if (sesionActual.getAttribute("nombreUsuario") == null) {
         response.sendRedirect("index.jsp"); 
        } else { %>
        <% Servicio servicio = (Servicio) sesionActual.getAttribute("servicio");%>
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

        <h1>Modificar Servicio</h1>
        <section class="modificar">
            <form action="SvServicioModificar" method="GET" accept-charset="utf-8">
                <div class="mainContainer">
                    <div class="inputContainer">
                        <label for="nombreServicio">Servicio</label>
                        <input required type="text" id="nombreServicio" name="nombreServicio" value="<%= servicio.getNombreServicio()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="descripcionServicio">Descripción</label>
                        <input required type="text" id="descripcionServicio" name="descripcionServicio" value="<%= servicio.getDescripcionServicio()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="destinoServicio">Destino</label>
                        <input required type="text" id="destinoServicio" name="destinoServicio" value="<%= servicio.getDestinoServicio()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="fechaServicio">Fecha</label>
                        <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");%>
                        <input required type="date" id="fechaServicio" name="fechaServicio" value="<%= simpleDateFormat.format(servicio.getFechaServicio())%>">
                    </div>
                    <div class="inputContainer">
                        <label for="precioServicio">Precio</label>
                        <input required type="text" id="precioServicio" name="precioServicio" value="<%= servicio.getPrecioServicio()%>">
                    </div>
                    <input type="hidden" name="codigoServicio" value="<%= servicio.getCodigoServicio()%>">
                </div>
                <input class="submitBtn" type="submit" value="Guardar Cambios">
            </form>
        </section>

        <footer>

        </footer>
                
                <% }%>
    </body>
</html>