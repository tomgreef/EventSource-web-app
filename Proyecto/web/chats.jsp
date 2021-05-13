<%-- 
    Document   : mensaje
    Created on : 09-may-2021, 13:16:34
    Author     : kkeyl
--%>

<%@page import="entidades.Chats"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chats</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <%
        List<Chats> chats = (List)request.getAttribute("chats");
        
    %>
    <body>
        <jsp:include page="navBar.jsp" />                    
        
        <p class="titulo"> Mis conversaciones </p>
        <table>
            <tr>
                <th>Usuario</th>
                <th></th>
            </tr>
           <% 
               for (Chats chat: chats){
           %>
           <tr>
                <td><%=chat.getUsuarioId().getNombre() %></td>
                <td><a href="MensajeListar?id=<%= chat.getChatId()%>">Mostrar conversaci&oacute;n</a></td>
                <%
                }
           %>
           </tr>
        </table>
        
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
