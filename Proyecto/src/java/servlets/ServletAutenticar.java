/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.UsuariosFacade;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomvg
 */
@WebServlet(name = "ServletAutenticar", urlPatterns = {"/ServletAutenticar"})
public class ServletAutenticar extends HttpServlet {

    @EJB
    private UsuariosFacade usuariosFacade;

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
        String email, password, status = null, goTo = "index.jsp";
        Usuarios usuario;
        RequestDispatcher rd;

        email = request.getParameter("email");
        password = request.getParameter("password");

        usuario = this.usuariosFacade.findByEmailAndPassword(email, password);

        if (usuario == null) {
            status = "El usuario no se encuentra en la base de datos";
            request.setAttribute("status", status);
            goTo = "login.jsp";
        } else if (!password.equals(usuario.getPassword())) {
            status = "La clave es incorrecta";
            request.setAttribute("status", status);
            goTo = "incorrecto.html";
        } else {
            goTo = "index.jsp";
        }

        rd = request.getRequestDispatcher(goTo);
        rd.forward(request, response);
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
