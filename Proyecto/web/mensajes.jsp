<%-- 
    Document   : mensajes
    Created on : 09-may-2021, 15:35:22
    Author     : kkeyl
--%>

<%@page import="entidades.Mensajes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mensajes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
    </head>
     <%
        List<Mensajes> mensajes = (List)request.getAttribute("mensajes");
        
    %>
    <body>
        <jsp:include page="navBar.jsp" />                    
        
        <p class="titulo"> Mensajes </p>
        <table>
            <tr>
                <th>Usuario</th>
                <th>Mensaje</th>
            </tr>
           <% 
               for (Mensajes mensaje: mensajes){
           %>
           <tr>
                <td><%=mensaje.getUsuarios().getNombre() %></td>
                <td><%=mensaje.getMensaje() %></td>
                <%
                }
           %>
           </tr>
        </table>
        
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
