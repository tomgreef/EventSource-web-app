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
                    <input type="range" min="1" max="100" value="50">
                </li>
                <li>
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
                    <label for="start">Número de asientos disponibles</label>
                    <input type="number" id="quantity" name="quantity" min="1" max="2000">
                </li>
                
                
                <li>
                    <a href="#">Tags</a>
                </li> 
                
                
                <li>
                    <div class="boton"> Aplicar</div>
                </li>
           </ul>
        </div>
        
        <div style="margin-right:30%" class = "evento-square">
        <div class = "columnas">   
 
         <div class= "filas" ptb-3 >
 
           <div class="fila tituloConcierto"style="width:650px; margin:0 auto;">
           Titulo
           </div>
 
           <div style="color:white" class="filas container">
           <strong>Descripción loren ipsum loren ipsum loren ipsum loren ipsum loren ipsum
		   loren ipsum loren ipsum loren ipsum loren ipsum loren ipsum loren ipsum 
		   loren ipsum loren ipsum loren ipsum</strong>
           </div>
         </div>
 
         <div class= "filas ptb-3">
 
           <div style="color:white" class="fila alinearDerecha">
           <strong>Fecha del evento:</strong>
           </div>
 
           <div style="color:white" class="fila alinearDerecha">
           <strong>Fecha límite de reserva:</strong>
           </div>
 
           <div style="color:white" class="fila alinearDerecha">
           <strong>Aforo:</strong>
           </div>
		   
		    
           <div class="boton alinearDerecha">
           <strong>Reservar</strong>
           </div>
		   
         </div>
 
        </div>
            
            
            
    </body>
</html>