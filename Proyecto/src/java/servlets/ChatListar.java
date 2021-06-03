/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ChatsFacade;
import entidades.Chats;
import entidades.Usuarios;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ChatListar", urlPatterns = {"/ChatListar"})
public class ChatListar extends HttpServlet {
    
    @EJB
    private ChatsFacade chatsFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String goTo = "chats.jsp";
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios)session.getAttribute("usuario");
        if(usuario != null){ //El usuario está autenticado
            if(usuario.getRol()==3 ){ //Es un teleoperador
                List<Chats> chats;
                String nombre = request.getParameter("nombre")!=null?request.getParameter("nombre"):null;
                if(nombre != null && nombre.length()>0 ){
                    chats = this.chatsFacade.getChatsUsuarioByNombre(nombre.toLowerCase());
                } else {
                    chats = this.chatsFacade.findAll();
                }
               request.setAttribute("chats", chats);
            } else { //Es un usuario  "normal"
                List<Chats> chats = this.chatsFacade.getChatsUsuario(usuario.getUsuarioId().toString());
                request.setAttribute("chats", chats);
            }
        } else { //No está logeado y no puede ver los chats
            request.setAttribute("error", "Para ver los chats hay que estar logueado");
            goTo = "login.jsp";
        }
        
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
