<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="dao.EventosFacade"%>
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
        List<Eventos> listaEventos = (List) request.getAttribute("eventos");
    %>
    <body>
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <h2>
                        Filtros
                    </h2>
                </li>
                <li>
                    <label for="start">Precio máximo</label>
                    <input id="rangeInput" type="range" min="0" max="2000" oninput="amount.value=rangeInput.value" />
                    <br>
                    <input id="amount" type="number" value="200" min="0" max="0200" oninput="rangeInput.value=amount.value" />
                </li>
                <li>
                    <br>
                    <label for="start">Desde:</label>

                    <input 
                        type="date" id="start" name="trip-start"
                        accept=""value="2018-07-22"
                        accesskey=""min="2018-01-01" max="2018-12-31">

                </li>
                
                <li>
                    <label for="start">Hasta</label>

                    <input 
                        type="date" id="start" name="trip-start"
                        accept=""value="2018-07-22"
                        accesskey=""min="2018-01-01" max="2018-12-31">

                </li>
                
                
                <li>
                    <label for="start">nº asientos disponibles</label>
                    <input type="number" id="quantity" name="quantity" min="1" max="2000">
                </li>
                
                <li>
                    <label for="start">Tags</label>
                </li> 
                
                <li>
                    <button class="boton pull-left" type="button">Concierto</button> <button  class="boton" type="button">Teatro</button>
                </li>
                
                <li>
                    <button class="boton" type="button">Charla</button> <button class="boton" type="button">Taller</button>
                </li>
                <br>
                <li>
                     <button class="boton" type="button">Aplicar</button>
                </li>
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
           <strong><%=e.getDescripcion()%></strong>
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
		    
           <button class="boton alinearDerecha" href="/login.jsp">
           <strong>Reservar</strong>
           </button>
		   
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