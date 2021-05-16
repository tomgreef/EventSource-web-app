<%-- 
    Document   : newEvent
    Created on : 29-abr-2021, 18:33:36
    Author     : yisus
--%>

<%@page import="entidades.Etiquetas"%>
<%@page import="entidades.Reservas"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.Eventos"%>

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
    <%
        String[] listaRols;
        Eventos evento = (Eventos) request.getAttribute("evento");
        String titulo = "" , descripcion = "";
        Integer eventoID = 0;
        Integer filas = 0;
        Integer columnas = 0;
        Date fecha = new Date();
        Date fechaLimite = new Date();
        int aforo = 0;
        int entradasMaximas = 0;
        List<Reservas> reservasList = null;
        List<Etiquetas> etiquetasList = null;
        int crearOEditar = 1;
        String botonSubmit = "Crear";
        
        if (evento != null){
            titulo = evento.getTitulo();
            descripcion = evento.getDescripcion();
            eventoID = evento.getEventoId();
            filas = evento.getFilas();
            columnas = evento.getColumnas();
            fecha = evento.getFecha();
            fechaLimite = evento.getFechaLimite();
            aforo = evento.getAforo();
            entradasMaximas = evento.getEntradasMaxima();
            reservasList = evento.getReservasList();
            etiquetasList = evento.getEtiquetasList();
            crearOEditar = 0;
            botonSubmit = "Editar";
        }
    
    %>
    <body>
        <jsp:include page="navBar.jsp" />
        <% if(crearOEditar == 1){%>
            <h2 class="tituloCrearUyE" align="center"> CREAR NUEVO EVENTO </h2> 
            <%}else if (crearOEditar == 0){%>
            <h2 class="tituloCrearUyE" align="center"> EDITAR EVENTO </h2>
            <% } %>
        <div class="crearUyE-square">
            <form class="formulario" action="EditarAgregarEvento">
                <a class="textoFormulario" align="left"> Titulo de Evento:
                    <input class="campoMorado" type="text" align="left" placeholder="Titulo" name="titulo" value="<%= titulo%>"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Fecha del Evento:
                    <input class="campoMorado" type="date" align="left" placeholder="Fecha" name="fecha" value="<%= fecha%>"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Fecha limite para reservas:
                    <input class="campoMorado" type="date" align="left" placeholder="FechaLimite" name="fechaLimite" value="<%= fechaLimite%>"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Aforo:
                    <input class="campoMorado" type="number" align="left" placeholder="Aforo" name="aforo" value="<%= aforo%>"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Limite Entradas por Usuario:
                    <input class="campoMorado" type="number" align="left" placeholder="EntradasMaximas" name="entradasMaximas" value="<%= entradasMaximas%>"></a> 
                    <br><br/>
                <a class="textoFormulario" align="left"> Numero de Filas:
                    <input class="campoMorado" type="number" align="left" placeholder="Filas" name="filas" value="<%= filas%>"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Numero de Columnas:
                    <input class="campoMorado" type="number" align="left" placeholder="Columnas" name="columnas" value="<%= columnas%>"></a>
                    <br><br/>
                <a class="textoFormulario" align="left"> Descripcion del Evento:
                    <br><br/>
                    <textarea class="campo" type="text" align="left" 
                              rows="5" cols="45" placeholder="Descripcion" name="descripcion" value="<%= descripcion%>"></textarea>
<%-- 
                <% if(crearOEditar == 1){%>
                <a href="CrearEvento" class="boton" align="right">
                    Crear
                <%}else if (crearOEditar == 0){%>
                <a href="EditarEvento" class="boton" align="right">
                    Editar
                <% } %>
--%>
                <input class="submit" type="submit" align="center" value=<%= botonSubmit%>>

            </form>
        </div>    
    </body>
</html>
