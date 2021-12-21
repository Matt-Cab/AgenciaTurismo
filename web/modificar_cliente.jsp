<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Cliente"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modificar Cliente</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/tablas.css">
    </head>
    <body>
                <% HttpSession sesionActual = request.getSession(); %>
        <% if (sesionActual.getAttribute("nombreUsuario") == null) {
         response.sendRedirect("index.jsp"); 
        } else { %>
        <% Cliente cliente = (Cliente) sesionActual.getAttribute("cliente");%>
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

        <h1>Modificar cliente</h1>
        <section class="darAlta">
            <form action="SvClienteModificar" method="GET" accept-charset="utf-8">
                <div class="mainContainer">
                    <div class="inputContainer">
                        <label for="nombre">Nombre:</label>
                        <input required type="text" id="nombre" name="nombre" value="<%= cliente.getNombre()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="apellido">Apellido:</label>
                        <input required type="text" id="apellido" name="apellido" value="<%= cliente.getApellido()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="direccion">Direccion:</label>
                        <input required type="text" id="direccion" name="direccion" value="<%= cliente.getDireccion()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="dni">DNI:</label>
                        <input required type="text" id="dni" name="dni" value="<%= cliente.getDni()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="fechaNac">Fecha nacimiento:</label>
                        <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");%>
                        <input required type="date" id="fechaNac" name="fechaNac" value="<%= simpleDateFormat.format(cliente.getFechaNac())%>">
                    </div>
                    <div class="inputContainer">
                        <label for="nacionalidad">Nacionalidad:</label>
                        <input required type="text" id="nacionalidad" name="nacionalidad" value="<%= cliente.getNacionalidad()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="celular">Celular:</label>
                        <input required type="text" id="celular" name="celular" value="<%= cliente.getCelular()%>">
                    </div>
                    <div class="inputContainer">
                        <label for="email">Email:</label>
                        <input required type="email" id="email" name="email" value="<%= cliente.getEmail()%>">
                    </div>
                    <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente()%>">
                </div>
                <input class="submitBtn" type="submit" value="Guardar Cambios">
            </form>
        </section>

        <footer>

        </footer>
                <% } %>
    </body>
</html>