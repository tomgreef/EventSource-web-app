<%-- 
    Document   : mensaje
    Created on : 09-may-2021, 13:16:34
    Author     : kkeyl
--%>

<%@page import="entidades.Usuarios"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <%
        List<Chats> chats = (List)request.getAttribute("chats");
        Usuarios usuario = (Usuarios)session.getAttribute("usuario");
    %>
    <body>
        <jsp:include page="navBar.jsp" />                    
        
        
        
        <p class="titulo" style="margin-left: 5%;"> Mis conversaciones </p>
        <div class="messages-square">
            <form action="ChatListar" method="POST">
                Filtrar por nombre 
                <input  type="text" placeholder="Nombre del usuario" name="nombre">
                <input type="submit" value="Filtrar" />
            </form>
            <table class="table">
                <tr>
                     <th>Teleoperador</th>
                    <% 
                   if(usuario.getRol()== 3){
                   %>
                    <th>Cliente</th>
                    <%
                    } else {
                    %>
                    <th>Fecha de creación del chat</th>
                    <%
                    }
                    %>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
               <% 
                   for (Chats chat: chats){
               %>
               <tr>
                   <%
                   if(chat.getTeleoperadorId()!=null ){
                   %>
                    <td><%=chat.getTeleoperadorId().getNombre() %></td>
                   <%
                    } else {
                    %>
                    <td>Teleoperador no asignado</td>
                    <%
                    }
                    %>
                   <% 
                   if(usuario.getRol()== 3){
                   %>
                    <td><%=chat.getUsuarioId().getNombre() %></td>
                   <%
                    } else {
                    %>
                    <td><%=chat.getFecha().toString() %></td>
                    <%
                    }
                    %>
                    <!--<td><a href="MensajeListar?id=<%= chat.getChatId()%>"> <p class="ver-chat"> Mostrar chat</p></a></td>-->
                    <td><a href="MensajeListar?id=<%= chat.getChatId()%>" class="boton"> Mostrar chat</a></td>
                    <!--td><a href="MensajeListar?id=<%= chat.getChatId()%>">Mostrar conversaci&oacute;n</a></td>-->
                        <%
                       if(usuario.getRol()== 3){
                           if(chat.getTeleoperadorId()!=null){
                       %>
                                <!--<td><a href="ChatDesignar?id=<%= chat.getChatId()%>"> <p class="ver-chat"> Desasignar teleoperador</p></a></td>-->
                                <td><a href="ChatDesignar?id=<%= chat.getChatId()%>" class="boton" style="background: orangered;"> Desasignar<br/>teleoperador</a></td>
                        <%
                           } else {
                            %>
                                <!--<td><a href="ChatAsignar?id=<%= chat.getChatId()%>"> <p class="ver-chat"> Asignarme este chat</p></a></td>-->
                                <td><a href="ChatAsignar?id=<%= chat.getChatId()%>" class="boton" style="background: green;"> Asignarme<br/>este chat</a></td>
                            <%
                            }
                            %>
                            <!--<td><a href="ChatBorrar?id=<%= chat.getChatId()%>"> <p class="ver-chat"> Borrar chat</p></a></td>-->
                            <td><a href="ChatBorrar?id=<%= chat.getChatId()%>" class="boton" style="background: red;"> Borrar chat</a></td>
                       <%
                        }
                        %>
                    <%
                    }
                    %>
                    
               </tr>
            </table>
        </div>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
