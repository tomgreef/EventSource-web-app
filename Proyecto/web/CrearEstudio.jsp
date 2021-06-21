<%-- 
    Document   : CrearEstudio
    Created on : 13-may-2021, 19:13:37
    Author     : Alberto
--%>

<%@page import="java.util.Date"%>
<%@page import="entidades.Estudios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear estudio</title>
    </head>
    
    <%
    Estudios estudio = (Estudios) request.getAttribute("estudio");
    Integer estudioId = 0;
    Integer edadInicial = 0;
    Integer edadFinal = 100;
    Date fechaInicial = new Date();
    Date fechaFinal = new Date();
    Integer sexo = 0;
    
    if (estudio != null){
        estudioId = estudio.getEstudioId();
        edadInicial = estudio.getEdadInferior();
        edadFinal = estudio.getEdadSuperior();
        fechaInicial = estudio.getFechaInicial();
        fechaFinal = estudio.getFechaFinal();
        sexo = estudio.getSexo();
    }
    
    %>
    
    <body>
        <h1> Formulario </h1>
        <h2>Datos de un estudio</h2>

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
            <%
            if (sexo == 0){
            %>
            
                <input type="radio" name="sexo"value="0" checked/> Hombre
                <br/>
                <br/>
            
                <input type="radio" name="sexo"value="1"/> Mujer
                <br/>
                <br/>
            
            <%
            } else {
            %>
            
                <input type="radio" name="sexo"value="0"/> Hombre
                <br/>
                <br/>
            
                <input type="radio" name="sexo"value="1" checked/> Mujer
                <br/>
                <br/>
            
            <%
            }
            %>
        
            <input type="submit" value="Enviar" name="enviar" />
            <a href="EstudiosListar">Cancelar</a>
        </form>
    </body>
</html>
