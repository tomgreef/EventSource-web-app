<%-- 
    Document   : estudios
    Created on : 31-may-2021, 11:03:40
    Author     : Alberto
--%>

<%@page import="entidades.Estudios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
        List<Estudios> listaEstudios = (List) request.getAttribute("estudios");
    %>
    
    <body>
        <h1>Lista de estudios</h1>
            <a href="CrearEstudio.jsp" > </a>
        <table border="1">
            <thead>
                <tr>
                    <th>ESTUDIO_ID</th>
                    <th>ANALISTA_ID</th>
                    <th>NOMBRE</th>
                    <th>FECHA_INICIAL</th>
                    <th>FECHA_FINAL</th>
                    <th>EDAD_INFERIOR</th>
                    <th>EDAD_SUPERIOR</th>
                    <th>SEXO</th>
                    <th>CANTIDAD</th>
                    <th>EDITAR</th>
                    <th>BORRAR</th>
                </tr>
            </thead>
            <tbody>
            <%
                if (listaEstudios != null && !listaEstudios.isEmpty()){
            %>
            
            <%
                for (Estudios estudio : listaEstudios) {
            %>
                <tr>
                    <td><%= estudio.getEstudioId() %></td>
                    <td><%= estudio.getUsuarioId().getUsuarioId() %></td>
                    <td><%= estudio.getNombre() %></td>
                    <td><%= estudio.getFechaInicial() %></td>
                    <td><%= estudio.getFechaFinal() %></td>
                    <td><%= estudio.getEdadInferior() %></td>
                    <td><%= estudio.getEdadSuperior() %></td>
                    <td><%= estudio.getSexo() %></td>
                    <td><%= estudio.getCantidad() %></td>
                    <td><a href="CrearEstudioServlet?estudioId=<%= estudio.getEstudioId() %>">Editar</a></td>
                    <td><a href="EstudiosBorrar?estudioId=<%= estudio.getEstudioId() %>">Borrar</a></td>
                </tr>
            <%
                }
            %>
            <%
                } 
            %>
            </tbody>
        </table>
    </body>
</html>
