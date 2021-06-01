<%-- 
    Document   : redactarMensaje
    Created on : 01-jun-2021, 20:47:41
    Author     : kkeyl
--%>

<%@page import="entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Redactar Mensaje</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
     <%
        Usuarios usuario = (Usuarios)session.getAttribute("usuario");
        String chatId = (String)request.getAttribute("chatId");
    %>
    <body>
        <jsp:include page="navBar.jsp" />  
        
        <form method="POST" action="EnviarMensaje">
            <input type="hidden" id="usuarioId" name="usuarioId" value="<%=usuario.getUsuarioId() %>" />
            <input type="hidden" id="chatId" name="chatId" value="<%=chatId %>" />
            <input class="campo" type="text" id="mensaje" name="mensaje" placeholder="Escribe aquí tu mensaje" />
            <input type="submit" value="Enviar" />
        </form>
            
        <jsp:include page="footer.jsp" />
    </body>
</html>
