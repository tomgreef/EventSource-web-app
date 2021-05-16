/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.UsuariosFacade;
import entidades.Usuarios;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomvg
 */
@WebServlet(name = "UsuarioGuardar", urlPatterns = {"/UsuarioGuardar"})
public class UsuarioGuardar extends HttpServlet {

    @EJB
    private UsuariosFacade usuarioFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strTo = "index.jsp";
        String id, nombre, email, apellidos, domicilio, ciudad, sexo, edad, password, rol;
        Usuarios usuario;

        id = request.getParameter("id");
        nombre = request.getParameter("nombre");
        apellidos = request.getParameter("apellidos");
        email = request.getParameter("email");
        domicilio = request.getParameter("domicilio");
        ciudad = request.getParameter("ciudad");
        edad = request.getParameter("edad");
        sexo = request.getParameter("sexo");
        password = request.getParameter("password");
        rol = request.getParameter("rol");

        if (id == null || id.isEmpty()) { // Crear nuevo cliente
            usuario = new Usuarios();
        } else { // Editar cliente existente
            usuario = this.usuarioFacade.find(new Integer(id));
        }

        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setDomicilio(domicilio);
        usuario.setCiudad(ciudad);
        usuario.setEdad(new Integer(edad));
        usuario.setSexo(new Integer(sexo));
        usuario.setPassword(password);

        if (id == null || id.isEmpty()) { // Crear nuevo cliente 
            usuario.setRol(0);
            HttpSession session = request.getSession();
            this.usuarioFacade.create(usuario);
            Usuarios admin = (Usuarios) session.getAttribute("usuario");
            if (admin != null && admin.getRol() == 4) {
                strTo= "ListarUsuarios";
            }
        } else { // Editar cliente existente
            strTo = "ListarUsuarios";
            usuario.setRol(new Integer(rol));
            this.usuarioFacade.edit(usuario);
        }

        response.sendRedirect(strTo);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
