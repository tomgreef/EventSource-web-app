/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.EstudiosFacade;
import dao.UsuariosFacade;
import dto.EstudiosDTO;
import dto.UsuariosDTO;
import entidades.Estudios;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.EstudiosService;

/**
 *
 * @author Alberto
 */
@WebServlet(name = "CrearEstudioServlet", urlPatterns = {"/CrearEstudioServlet"})
public class CrearEstudioServlet extends HttpServlet {

    @EJB
    private EstudiosService estudiosService;
    
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
        String strTo = "CrearEstudio.jsp";
        
        HttpSession session = request.getSession();
        UsuariosDTO analista = (UsuariosDTO) session.getAttribute("usuario");

        if (analista == null || analista.getRol() != 2) {
            request.setAttribute("error", "Usuario sin permisos");
            strTo = "login.jsp";
        } else {
            String id = request.getParameter("estudioId");

            if (id != null) { // Hay un estudio, luego es para editarlo  
                EstudiosDTO estudio = this.estudiosService.buscarEstudio(new Integer(id));
                request.setAttribute("estudio", estudio);
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(strTo);
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
