<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <div class="login-backround">
            <div class="login-square">
                <h2 class="titulo logo" align="center">Eventsource</h2>
                <form class="formulario" method="POST" action="ServletAutenticar">
                    <input class="campo" type="text" align="center" placeholder="Email" name="email">
                    <input class="campo" type="password" align="center" placeholder="Contrase&ntilde;a" name="password">
                    <input class="submit" type="submit" align="center">
                </form>
                <div align="center">
                    <a href="signUp.jsp" class="forgot">¡Registrate aquí!</a>
                </div>
            </div>
        </div>
    </body>
</html>
