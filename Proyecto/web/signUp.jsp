<%-- 
    Document   : signUp
    Created on : 26-abr-2021, 1:19:10
    Author     : kkeyl
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        String[] listaRols;
        Usuarios usuario = (Usuarios) request.getAttribute("usuario");
        String nombre = "", apellidos = "", email = "", domicilio = "", ciudad = "",
                edad = "", password = "", id = "";
        Integer sexo = 0;
        Integer rol = 0;
        int crearOEditar = 1; //Variable que permite al admin editar rol 0, pero no crearla
        String botonSubmit = "Registrarse";

        if (usuario != null) { // Editar
            nombre = usuario.getNombre();
            apellidos = usuario.getApellidos();
            email = usuario.getEmail();
            domicilio = usuario.getDomicilio();
            ciudad = usuario.getCiudad();
            edad = usuario.getEdad() + "";
            sexo = usuario.getSexo();
            password = usuario.getPassword();
            id = usuario.getUsuarioId().toString();
            botonSubmit = "Editar";
            rol = usuario.getRol();
            crearOEditar = 0;
        }
    %>
    <body>
        <div class="login-backround">
            <div class="signUp-square">
                <h2 class="titulo logo" align="center">Eventsource</h2>
                <form class="formulario" action="UsuarioGuardar">
                    <input class="campo" type="text" placeholder="Nombre*" name="nombre" value="<%= nombre%>">
                    <input class="campo" type="text" placeholder="Apellidos*" name="apellidos" value="<%= apellidos%>">
                    <input class="campo" type="text" placeholder="Email*" name="email" value="<%= email%>">
                    <input class="campo" type="text" placeholder="Domicilio*" name="domicilio" value="<%= domicilio%>">
                    <input class="campo" type="text" placeholder="Ciudad*" name="ciudad" value="<%= ciudad%>">
                    <input class="campo" type="text" placeholder="Edad*" name="edad" value="<%= edad%>">
                    <% if (sexo == 1) {
                    %>
                    <div class="campo">
                        <input  type = "radio" name = "sexo" value = "0" /> Hombre
                        <input checked type = "radio" name = "sexo" value = "1" /> Mujer
                    </div>
                    <% } else {
                    %>
                    <div class="campo">
                        <input checked type = "radio" name = "sexo" value = "0" /> Hombre
                        <input  type = "radio" name = "sexo" value = "1" /> Mujer
                    </div>
                    <%
                        }
                    %>

                    <input class="campo" type="password" placeholder="Contraseña*" name="password" value="<%= password%>">
                    <%
                        Usuarios admin = (Usuarios) session.getAttribute("usuario");
                        if (admin != null && admin.getRol() == 4) { // Es admin
                    %>
                    <select class="campo" name="rol">
                        <%
                            listaRols = new String[]{"Usuario", "Creador", "Analista", "Teleoperador", "Administrador"};
                            for (int i = crearOEditar; i < 5; i++) {
                                String strSeleccionado = "";
                                if (i == rol) {
                                    strSeleccionado = "selected";
                                }
                        %>
                        <option <%= strSeleccionado%> value="<%= i%>"><%= listaRols[i]%></option>
                        <%    }
                        %>
                    </select>
                    <input hidden value="<%= id%>" name="id">
                    <%
                        }
                    %>
                    <input class="submit" type="submit" align="center" value=<%= botonSubmit%>>
                </form>
            </div>

        </div>
    </body>
</html>
