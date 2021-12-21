<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alta Cliente</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/mensaje_error.css">
        <script defer src="./assets/js/alta_cliente_empleado.js"></script>
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

        <h1>Alta Cliente</h1>
        <section class="darAlta">
            <form action="SvClienteAlta" method="POST">
                <div class="mainContainer">
                    <% if (sesionActual.getAttribute("altaClienteFallida") != null && (boolean) sesionActual.getAttribute("altaClienteFallida") == true) { %>
                    <input type="hidden" id="altaFallida">
                    <% sesionActual.setAttribute("altaClienteFallida", false);}%>
                    <div class="inputContainer">
                        <label for="nombre">Nombre:</label>
                        <input required type="text" id="nombre" name="nombre" placeholder="Ingresar nombre">
                    </div>
                    <div class="inputContainer">
                        <label for="apellido">Apellido:</label>
                        <input required type="text" id="apellido" name="apellido" placeholder="Ingresar apellido">
                    </div>
                    <div class="inputContainer">
                        <label for="direccion">Direccion:</label>
                        <input required type="text" id="direccion" name="direccion" placeholder="Ingresar direccion">
                    </div>
                    <div class="inputContainer">
                        <label for="dni">DNI:</label>
                        <input required type="text" id="dni" name="dni" placeholder="Ingresar dni">
                    </div>
                    <div class="inputContainer">
                        <label for="fechaNac">Fecha nacimiento:</label>
                        <input required type="date" id="fechaNac" name="fechaNac">
                    </div>
                    <div class="inputContainer">
                        <label for="nacionalidad">Nacionalidad:</label>
                        <input required type="text" id="nacionalidad" name="nacionalidad" placeholder="Ingresar nacionalidad">
                    </div>
                    <div class="inputContainer">
                        <label for="celular">Celular:</label>
                        <input required type="text" id="celular" name="celular" placeholder="Ingresar celular">
                    </div>
                    <div class="inputContainer">
                        <label for="email">Email:</label>
                        <input required type="email" id="email" name="email" placeholder="Ingresar email">
                    </div>

                </div>
                <input class="submitBtn" type="submit" value="Enviar">
            </form>
        </section>

        <!-- Ventana modal para mostrar mensaje de error -->
        <div class="custom-modal-container">
            <div class="custom-modal">
                <h2 class="custom-modal__message">El DNI ya fue utilizado.</h2>
                <button class="custom-modal__btn-close">Cerrar</button>
            </div>
        </div>

        <footer>

        </footer>
        <% } %>
    </body>
</html>