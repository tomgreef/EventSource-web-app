/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.EventosFacade;
import entidades.Eventos;
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
 * @author tomvg
 */
@WebServlet(name = "ListarEventos", urlPatterns = {"/ListarEventos"})
public class ListarEventos extends HttpServlet {

    @EJB
    private EventosFacade eventosFacade;

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
        String strTo = "eventos.jsp";
        HttpSession session = request.getSession();
        Usuarios admin = (Usuarios) session.getAttribute("usuario");

        if (admin == null || admin.getRol() == 0 || admin.getRol() == 2 || admin.getRol() == 3) {
            // Excluimos usuarios, analistas y teleoperadores
            request.setAttribute("error", "Usuario sin permisos");
            strTo = "login.jsp";
        } else {
            List<Eventos> eventos;
            String titulo = request.getParameter("nombre_evento")!=null?request.getParameter("nombre_evento"):null;
            String costeStr = request.getParameter("precio_evento")!=null?request.getParameter("precio_evento"):null;
            Double coste = costeStr!=null?(Double.parseDouble(costeStr)):0.0;

            if ((titulo != null && titulo.length() > 0) || coste != 0) {// Estoy aplicando filtros
                eventos = this.eventosFacade.filter(titulo, coste);
            } else {  // Quiero mostrar todos
                eventos = this.eventosFacade.findAll();
            }

            request.setAttribute("usuario", admin);
            request.setAttribute("eventos", eventos);
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
