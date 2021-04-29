<%-- 
    Document   : newEvent
    Created on : 29-abr-2021, 18:33:36
    Author     : yisus
--%>

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
        <jsp:include page="navBar.jsp" />
        <h2 class="tituloCrearUyE" align="center"> CREAR NUEVO EVENTO </h2> 
        <div class="crearUyE-square">
            <form class="formulario">
                <a class="textoFormulario" align="left"> Titulo de Evento:
                    <input class="campoMorado" type="text" align="left"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Fecha del Evento:
                    <input class="campoMorado" type="date" align="left"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Fecha limite para reservas:
                    <input class="campoMorado" type="date" align="left"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Aforo:
                    <input class="campoMorado" type="number" align="left"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Limite Entradas por Usuario:
                    <input class="campoMorado" type="number" align="left"></a> 
                    <br><br/>
                <a class="textoFormulario" align="left"> Numero de Filas:
                    <input class="campoMorado" type="number" align="left"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Numero de Columnas:
                    <input class="campoMorado" type="number" align="left"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Descripcion del Evento:
                    <br><br/>
                    <textarea class="campo" type="text" align="left"
                              rows="5" cols="45"></textarea>
            </form>
        </div>    
    </body>
</html>
