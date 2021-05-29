<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="dao.EventosFacade"%>
<%@page import="entidades.Eventos"%>
<%@page import="entidades.Usuarios"%>
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
        Usuarios usuario = (Usuarios)request.getAttribute("usuario");
        List<Eventos> listaEventos = (List) request.getAttribute("eventos");
    %>
    <body>
        
        <jsp:include page="navBar.jsp" /> 
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <h2>
                        Filtros
                    </h2>
                </li>
                
                <form action="ListarEventos" method="POST">
                    <li>
                    <input class="campo" type="text" placeholder="Nombre del evento" name="nombre_evento">
                    </li>

                    <li>
                        <label for="start">Precio máximo</label>
                        <input id="rangeInput" type="range" min="0" max="500" oninput="amount.value=rangeInput.value"name="precio_evento" />
                        <br>
                        <input id="amount" type="number" value="200" min="0" max="500" oninput="rangeInput.value=amount.value"  />
                    </li>

                    <li>
                         <input type="submit" value="Filtrar" class="boton"/>
                    </li>
                </form>

           </ul>
        </div>
        <div class ="filas">
             
        <%
        for (Eventos e : listaEventos) {
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        %>
        <div class = fila>
            <div style="margin-right:30%" class = "evento-square">
            <div class = "columnas">   
 
         <div class= "filas" ptb-3 >
 
           <div class="fila tituloConcierto"style="width:650px; margin:0 auto;">
            <%=e.getTitulo()%>
           </div>
 
            <div style="color:white" class="filas container">
                <p class="textoDescripcion"><%=e.getDescripcion()%></p>
            </div>
         </div>
 
         <div class= "filas ptb-3">
 
           <div style="color:white" class="fila alinearDerecha">
           <strong>Fecha del evento:</strong>
           <%=simpleDateFormat.format(e.getFecha())%>
           </div>
 
           <div style="color:white" class="fila alinearDerecha">
           <strong>Fecha límite de reserva:</strong>
           <br>
            <%=simpleDateFormat.format(e.getFechaLimite())%>
           </div>
 
           <div style="color:white" class="fila alinearDerecha">
           <strong>Aforo:</strong>
           <br>
           <%=e.getAforo()%>
           </div>
           
           <div style="color:white" class="fila alinearDerecha">
           <strong>Precio</strong>
           <br>
           <%=e.getCoste()%>
           </div>

           <a href="CrearReserva?idEvento=<%= e.getEventoId()%>&idUsuario=<%=usuario.getUsuarioId()%>" class="boton boton-peque">Reservar</a> 
           
         </div>
 
            </div>
            
        </div>
            
        </div>
        <%
        }
            %>
        </div>
            
    </body>
</html>