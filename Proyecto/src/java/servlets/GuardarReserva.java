/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dto.EventosDTO;
import dto.UsuariosDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.EventosService;

/**
 *
 * @author tomvg
 */
@WebServlet(name = "GuardarReserva", urlPatterns = {"/GuardarReserva"})
public class GuardarReserva extends HttpServlet {

     @EJB 
    private EventosService eventosService;
    
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
        HttpSession session = request.getSession();
        UsuariosDTO usuario = (UsuariosDTO) session.getAttribute("usuario");
        String goTo = "EventoListar";
        
        if (usuario == null) {
            request.setAttribute("error", "Usuario no autenticado");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            String id = request.getParameter("id");
            String checkBoxes[] = request.getParameterValues("asientoCheckbox");
            if(checkBoxes != null && checkBoxes.length > 0){
                for (String checkBoxe : checkBoxes) {
                    this.eventosService.guardarReserva(usuario.getUsuarioId(), new Integer(id), checkBoxe);
                }
            } else {
                this.eventosService.guardarReserva(usuario.getUsuarioId(), new Integer(id), "00");
            }
        }
        
        response.sendRedirect("EventoListar");
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
