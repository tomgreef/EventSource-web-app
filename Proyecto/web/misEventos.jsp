<%@page import="entidades.Reservas"%>
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
        <jsp:include page="navBar.jsp" /> 
        
        <h1 class="titulo">
            Mis eventos (voy a asistir o he asistido)
        </h1>
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
                
                  <li class="sidebar-brand boton">
                    <button>
                        Mis eventos
                    </button>
                </li>
           </ul>
        </div>
        <div class ="filas">
             
        <%
        for (Eventos e : listaEventos) {
            String pattern = "dd-MM-yyyy";
            int i = 0;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            
            Double coste =e.getCoste();
            String costeString = coste.toString();
            if(coste==0)
            {
                costeString = "gratis";
            }
        %>
        <div class = fila>
            <div style="margin-right:30%" class = "evento-square">
            <div class = "columnas">   
 
         <div class= "filas" ptb-3 >
 
           <div class="fila tituloConcierto"style="width:650px; margin:0 auto;">
            <%=e.getTitulo()%>
           </div>
 
           <div style="color:white" class="fila container">
               <p class="textoDescripcion"><strong><%=e.getDescripcion()%></strong></p>
           </div>
           
           <div style="color:white" class="fila alinearDerecha">
           <strong>Cantidad de entradas:</strong>
           <%=e.getReservasList().get(i).getCantidad()%>
           </div>
           
           <div style="color:white" class="fila alinearDerecha">
           <strong>Fila y columna:</strong>
           <%=e.getReservasList().get(i).getAsientoFila()%>,
           <%=e.getReservasList().get(i).getAsientoColumna()%>
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
           <%=costeString%>
           </div>	    
            <a href="CancelarReserva?id=<%= e.getReservasList().get(i).getReservaId()%>" class="boton boton-peque">Cancelar</a>
           </button>
		   
         </div>
 
            </div>
            
        </div>
            
        </div>
        <%
        i++;}
            %>
        </div>
            
    </body>
</html>