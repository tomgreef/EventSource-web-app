/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ReservasFacade;
import dao.UsuariosFacade;
import dto.EventosDTO;
import dto.UsuariosDTO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.EventosService;
import service.ReservasService;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "CrearReserva", urlPatterns = {"/CrearReserva"})
public class CrearReserva extends HttpServlet {




    @EJB
    private ReservasFacade reservasFacade;
    
    @EJB 
    private EventosService eventosService;
    
    
    @EJB 
    private ReservasService reservasService;

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
        String goTo = "crearReserva.jsp";
        String idEvento = request.getParameter("idEvento");
        if(session.getAttribute("eventoId")!= null)
        {
            idEvento = (String) session.getAttribute("eventoId");
        }
        EventosDTO evento = eventosService.find(Integer.parseInt(idEvento));
        UsuariosDTO usuario = (UsuariosDTO) session.getAttribute("usuario");
        
        String checkBoxes[] = request.getParameterValues("asientoCheckbox");
        
        if(checkBoxes!=null)
        {
            for(String asiento :checkBoxes)
            {
                String[] filasYColumnasDivididas = asiento.split("/");
                Integer fila = Integer.parseInt(filasYColumnasDivididas[0]);
                Integer columna = Integer.parseInt(filasYColumnasDivididas[1]);
                
                this.reservasService.create(fila,columna,evento.getEventoId(),usuario.getUsuarioId());
            }
                
            goTo="ListarEventos";
        }
        else
        {
            request.setAttribute("evento", evento);
            
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
