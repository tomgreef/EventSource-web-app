/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.MensajesFacade;
import dao.UsuariosFacade;
import entidades.Mensajes;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kkeyl
 */
@WebServlet(name = "EnviarMensaje", urlPatterns = {"/EnviarMensaje"})
public class EnviarMensaje extends HttpServlet {

    @EJB
    MensajesFacade mensajesFacade;
    
    @EJB
    UsuariosFacade usuariosFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession();
        //Usuarios usuario = (Usuarios)session.getAttribute("usuario");
        
        String usuarioId = request.getParameter("usuarioId");
        String mensaje = request.getParameter("mensaje");
        String chatId = request.getParameter("chatId");
        Date date = new Date();
        
        if (mensaje != null && mensaje.length()>0) {
           Mensajes m = new Mensajes(new Integer(chatId), date, new Integer(usuarioId));
           m.setMensaje(mensaje);
           Usuarios u = this.usuariosFacade.find(new Integer(usuarioId));
           m.setUsuarios(u);
           mensajesFacade.create(m);
           this.usuariosFacade.edit(u);
        } 
        
        String goTo = "MensajeListar?id="+chatId;
        //RequestDispatcher rd = request.getRequestDispatcher("MensajeListar?id="+chatId);
        RequestDispatcher rd = request.getRequestDispatcher(goTo);
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
