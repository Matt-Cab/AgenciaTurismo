<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" href="./assets/css/general.css">
        <link rel="stylesheet" href="./assets/css/login.css">
        <link rel="stylesheet" href="./assets/css/mensaje_error.css">
        <script defer src="./assets/js/login.js"></script>
    </head>
    <body>
        <% HttpSession sesionActual = request.getSession(); %>
        <header>

        </header>
        <% if (sesionActual.getAttribute("loginFallido") != null && (boolean) sesionActual.getAttribute("loginFallido") == true) { %>
        <input type="hidden">
        <% sesionActual.setAttribute("loginFallido", false); %>
        <% }%>
        <h1>Iniciar Sesión</h1>
        <form action="SvUsuarioLogin" method="POST">
            <label for="usuario">Usuario:</label>
            <input required type="text" id="usuario" name="nombreUsuario" placeholder="Ingrese su usuario">
            <label for="password">Contraseña:</label>
            <input required type="password" id="password" name="password" placeholder="Ingrese su contraseña">

            <input class="submitBtn" type="submit" value="Iniciar Sesión">
        </form>

        <!-- Ventana modal para mostrar mensaje de error -->
        <div class="custom-modal-container">
            <div class="custom-modal">
                <h2 class="custom-modal__message">Usuario o contraseña incorrecto.</h2>
                <button class="custom-modal__btn-close">Cerrar</button>
            </div>
        </div>

        <footer>

        </footer>
    </body>
</html>