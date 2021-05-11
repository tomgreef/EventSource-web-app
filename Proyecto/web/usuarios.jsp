<%@page import="java.util.List"%>
<%@page import="entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>

        <link rel="stylesheet" href="styles/normalize.css">
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <%
        List<Usuarios> lista = (List) request.getAttribute("usuarios");
    %>
    <body>
        <jsp:include page="navBar.jsp" />   
        <div class="container">
            <table class="tablaUsuarios">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Domicilio</th>
                        <th scope="col">Ciudad</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Sexo</th>
                        <th scope="col">Rol</th>
                        <th scope="col" colspan="2"><a href="EditarAgregarUsuario" class="boton">Registrar</a></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Usuarios u : lista) {
                    %>
                    <tr>
                        <td><%= u.getUsuarioId()%></td>
                        <td><%= u.getNombre()%></td>
                        <td><%= u.getApellidos()%></td>
                        <td><%= u.getDomicilio()%></td>
                        <td><%= u.getCiudad()%></td>
                        <td><%= u.getEdad()%></td>
                        <%
                            if (u.getSexo() == 0) {
                        %>
                                <td>H</td>  
                        <%
                        } else {
                        %>
                                <td>M</td>  
                        <%                      
                        }
                        %>
                        <td><%= u.getRol()%></td>   
                        <td><a href="EditarAgregarUsuario?id=<%= u.getUsuarioId()%>" class="boton boton-peque">Editar</a></td>
                        <td class="sinFondo"><a href="BorrarUsuario?id=<%= u.getUsuarioId()%>" class="boton-rojo boton-peque">Borrar</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
