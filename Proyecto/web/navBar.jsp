<%@page import="entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuarios usuario = (Usuarios) session.getAttribute("usuario");
    if(usuario != null){
    switch (usuario.getRol()) {
        case 1: // Creador de eventos
%>
<nav>
    <div class="container columnas ptb-3 navbar">
        <div class="columna">
            <a href="index.jsp" class="objeto-col enlace-negro">
                <span class="logo">Eventsource</span>
            </a>    
            <a href="index.jsp" class="objeto-col enlace-negro">Home</a>
        </div>
        <div class="columna">
            <a href="Desautenticar" class="objeto-col boton">
                Logout
            </a>
        </div>
    </div>
</nav>
<%
        break;
    case 2: // Analista
%>
<nav>
    <div class="container columnas ptb-3 navbar">
        <div class="columna">
            <a href="index.jsp" class="objeto-col enlace-negro">
                <span class="logo">Eventsource</span>
            </a>    
            <a href="index.jsp" class="objeto-col enlace-negro">Home</a>
        </div>
        <div class="columna">
            <a href="Desautenticar" class="objeto-col boton">
                Logout
            </a>
        </div>
    </div>
</nav>
<%
        break;
    case 3: // Teleoperador
%>
<nav>
    <div class="container columnas ptb-3 navbar">
        <div class="columna">
            <a href="index.jsp" class="objeto-col enlace-negro">
                <span class="logo">Eventsource</span>
            </a>    
            <a href="index.jsp" class="objeto-col enlace-negro">Home</a>
            <a href="ChatListar" class="objeto-col enlace-negro">Chats</a>
        </div>
        <div class="columna">
            <a href="Desautenticar" class="objeto-col boton">
                Logout
            </a>
        </div>
    </div>
</nav>
<%
        break;
    case 4: // Admin

%>
<nav>
    <div class="container columnas ptb-3 navbar">
        <div class="columna">
            <a href="index.jsp" class="objeto-col enlace-negro">
                <span class="logo">Eventsource</span>
            </a>    
            <a href="index.jsp" class="objeto-col enlace-negro">Home</a>
            <a href="ListarUsuarios" class="objeto-col enlace-negro">Usuarios</a>
            <a href="eventosAdmin.jsp" class="objeto-col enlace-negro">Eventos</a>
        </div>
        <div class="columna">
            <a href="Desautenticar" class="objeto-col boton">
                Log Out
            </a>
        </div>
    </div>
</nav>
<%        break;
    default: // Usuario
%>
<nav>
    <div class="container columnas ptb-3 navbar">
        <div class="columna">
            <a href="index.jsp" class="objeto-col enlace-negro">
                <span class="logo">Eventsource</span>
            </a>    
            <a href="index.jsp" class="objeto-col enlace-negro">Home</a>
            <a href="ListarEventos" class="objeto-col enlace-negro">Ver eventos</a>
            <a href="ListarMisEventos" class="objeto-col enlace-negro">Mis eventos</a>
            <a href="ChatListar" class="objeto-col enlace-negro">Chats</a>
            <a href="ChatCrear" class="objeto-col enlace-negro">Crear Chat</a>
        </div>
        <div class="columna">
            <a href="Desautenticar" class="objeto-col boton">
                Logout
            </a>
        </div>
    </div>
</nav>
<%
    } 
}else {
%>
<nav>
    <div class="container columnas ptb-3 navbar">
        <div class="columna">
            <a href="index.jsp" class="objeto-col enlace-negro">
                <span class="logo">Eventsource</span>
            </a>    
            <a href="index.jsp" class="objeto-col enlace-negro">Home</a>
        </div>
        <div class="columna">
            <a href="login.jsp" class="objeto-col boton">
                Login
            </a>
        </div>
    </div>
</nav>
<%
}
%>