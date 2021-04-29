<%-- 
    Document   : CrearUsuario
    Created on : 29-abr-2021, 17:18:54
    Author     : Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
        <title>Eventsource</title>
    </head>
    <body>
        <h1>Crear usuario</h1>
        <form class="formulario">
            Nombre: <input type="text" name="nombre" value=""/>
            <br/>
            <br/>
            
            Apellidos: <input type="text" name="apellidos" value=""/> 
            <br/>
            <br/>
            
            Correo electr&oacute;nico: <input type="text" name="correo" value=""/> 
            <br/>
            <br/>
            
            G&eacute;nero:
            <br/>
            <br/>
            
            <input type="radio" name="genero"value="masculino"/> Masculino
            <br/>
            <br/>
            
            <input type="radio" name="genero"value="Femenino"/> Femenino
            <br/>
            <br/>
            
            <input type="radio" name="genero"value="otro"/> Otro
            <br/>
            <br/>
            
            <input type="radio" name="genero"value="desconocido"/> Prefiero no decirlo
            <br/>
            <br/>
            
            Direcci&oacute;n: <input type="text" name="direccion" value=""/> 
            <br/>
            <br/>
            
            Ciudad: <input type="text" name="direccion" value=""/> 
            <br/>
            <br/>
            
            Rol:
                <select name="rol">
                    <option value="creadorDeEventos" > Creador de eventos </option>
                    <option value="administradorDelSistema" > Administrador del sistema </option>
                    <option value="teleoperador" > Teleoperador </option>
                    <option value="analistaDeEventos" > Analista de eventos </option>
                </select>
            <br/>
            <br/>
            
            <input type="button" value="Cancelar" name="cancelar" />
            <input type="submit" value="Enviar" name="enviar" />
        </form>
    </body>
</html>
