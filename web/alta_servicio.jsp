<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alta Servicio</title>
        <link rel="stylesheet" href="./assets/css/general.css">
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
        <h1>Alta Servicio</h1>
        <form action="SvServicioAlta" method="POST">
            <div class="mainContainer">
                <div class="inputContainer">
                    <label for="nombreServicio">Nombre del Servicio:</label>
                    <input required type="text" id="nombreServicio" name="nombreServicio" placeholder="Ingresar nombre">
                </div>
                <div class="inputContainer">
                    <label for="descripcionServicio">Descripción</label>
                    <input required type="text" id="descripcionServicio" name="descripcionServicio" placeholder="Ingresar descripcion">
                </div>
                <div class="inputContainer">
                    <label for="destinoServicio">Destino:</label>
                    <input required type="text" id="destinoServicio" name="destinoServicio" placeholder="Ingresar destino">
                </div>
                <div class="inputContainer">
                    <label for="fechaServicio">Fecha:</label>
                    <input required type="date" id="fechaServicio" name="fechaServicio">
                </div>
                <div class="inputContainer">
                    <label for="precioServicio">Precio:</label>
                    <input required type="text" id="precioServicio" name="precioServicio" placeholder="Ingresar precio">
                </div>
            </div>
            <input class="submitBtn" type="submit" value="Enviar">
        </form>
        
        <% } %>
    </body>
</html>
