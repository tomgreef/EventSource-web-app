<%-- 
    Document   : mensajes
    Created on : 09-may-2021, 15:35:22
    Author     : kkeyl
--%>

<%@page import="dto.MensajesDTO"%>
<%@page import="dto.UsuariosDTO"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
     <%
        List<MensajesDTO> mensajes = (List)request.getAttribute("mensajes");
        UsuariosDTO usuario = (UsuariosDTO)session.getAttribute("usuario");
        String chatId = (String)request.getAttribute("chatId");
    %>
    <body>
        <jsp:include page="navBar.jsp" />                    
        
        <p class="titulo" style="margin-left: 5%;"> Mensajes </p>
        <div class="messages-square">
            <table class="table">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Mensaje</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for (MensajesDTO mensaje: mensajes){
                    %>
                    <tr>
                         <td><%=mensaje.getUsuarios().getNombre() %></td>
                         <td><%=mensaje.getMensaje() %></td>
                         <%
                         }
                    %>
                    </tr>
                </tbody>
            </table>
        </div> 
       
        <div style="margin: 5%">
            <form method="POST" action="EnviarMensaje">
                <input type="hidden" id="usuarioId" name="usuarioId" value="<%=usuario.getUsuarioId() %>" />
                <input type="hidden" id="chatId" name="chatId" value="<%=chatId %>" />
                <input type="text" class="campo" id="mensaje" name="mensaje" placeholder="Escribe aquí tu mensaje" />
                <input type="submit" value="Enviar" />
            </form>
        </div>
        
        <!--<a href="RedactarMensaje?chatId=<%=chatId %>" class="boton" >Redactar mensaje</a>-->
           
        <jsp:include page="footer.jsp" />
    </body>
</html>
