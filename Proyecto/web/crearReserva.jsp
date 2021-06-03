<%-- 
    Document   : crearReserva
    Created on : 27-may-2021, 13:09:05
    Author     : Kevin
--%>

<%@page import="entidades.Usuarios"%>
<%@page import="dao.EventosFacade"%>
<%@page import="entidades.Eventos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Eventos evento = (Eventos)request.getAttribute("evento");
        Usuarios usuario = (Usuarios)request.getAttribute("usuario");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
    </head>

 <body>
        <jsp:include page="navBar.jsp" />
        <div class="crearUyE-square"
             <h2>Crear reserva para evento <%= evento.getTitulo()%></h2>     
        
        <table style="width:60%">
            <%for(int i=0;i<evento.getColumnas();i++)
            {
                
                %>
                <tr>
                <%
                for(int j=0;j<evento.getFilas();j++)
                {
                %>
                <td><input type="checkbox" id="asiento" name="asiento" value="<%=i+1%><%=j+1%>"></td>
                <%
                }
                %>
                </tr>
                
            <%
            }
            %>    
        </table>
        </div>
    </body>
</html>
