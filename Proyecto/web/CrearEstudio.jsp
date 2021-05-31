<%-- 
    Document   : CrearEstudio
    Created on : 13-may-2021, 19:13:37
    Author     : Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear estudio</title>
    </head>
    <body>
        <h1> Formulario </h1>
        <h2>Crear un estudio</h2>

        <form action="EstudiosGuardar" method="POST">  

            Nombre: <input type="text" name="nombre" value=""/>
            <br/>
            Edad: <input type="text" name="edadInicial" value="" size=3/> a 
                  <input type="text" name="edadFinal" value="" size=3/>
            <br/>
            Fecha <input type="date" name="fechaInicial" value=""/> a
                  <input type="date" name="fechaFinal" value=""/>
            <br/>
            Sexo: <br/>
                <input type="radio" name="sexo"value="0"/> Hombre
                <br/>
                <br/>
            
                <input type="radio" name="sexo"value="1"/> Mujer
                <br/>
                <br/>
        
            <input type="submit" value="Enviar" name="enviar" />
            <input type="button" value="Cancelar" name="cancelar" />
        </form>
    </body>
</html>
