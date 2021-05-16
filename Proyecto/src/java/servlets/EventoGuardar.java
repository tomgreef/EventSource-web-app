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
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

/**
 *
 * @author yisus
 */
@WebServlet(name = "EventoGuardar", urlPatterns = {"/EventoGuardar"})
public class EventoGuardar extends HttpServlet {

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
     * @throws java.text.ParseException
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String strTo = "ListarEventos";
        String titulo, descripcion, eventoID, filas, columnas, fecha, fechaLimite, aforo, entradasMaximas, coste;
        Eventos evento;
        
        titulo = request.getParameter("titulo");
        descripcion = request.getParameter("descripcion");
        eventoID = request.getParameter("eventoID");
        filas = request.getParameter("filas");
        columnas = request.getParameter("columnas");
        fecha = request.getParameter("fecha");
        fechaLimite =  request.getParameter("fechaLimite");
        aforo = request.getParameter("aforo");
        entradasMaximas = request.getParameter("entradasMaximas");
        coste = request.getParameter("coste");
   

        if (eventoID == null || eventoID.isEmpty()) { // Crear nuevo cliente
            evento = new Eventos();
        } else { // Editar cliente existente
            evento = this.eventosFacade.find(new Integer(eventoID));
        }

        evento.setTitulo(titulo);
        evento.setDescripcion(descripcion);
        evento.setFilas(new Integer(filas));
        evento.setColumnas(new Integer(columnas));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = format.parse(fecha);
        evento.setFecha(fecha1);
        Date fechaL = format.parse(fechaLimite);
        evento.setFechaLimite(fechaL);
       /* Date fecha1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        evento.setFecha(fecha1);
        Date fecha2 = new SimpleDateFormat("dd/MM/yyyy").parse(fechaLimite);
        evento.setFechaLimite(fecha2);*/
        evento.setAforo(Integer.parseInt(aforo));
        evento.setEntradasMaxima(Integer.parseInt(entradasMaximas));
        evento.setCoste(Double.parseDouble(coste));

        if (eventoID == null || eventoID.isEmpty()) { // Crear nuevo cliente 
            this.eventosFacade.create(evento);
        } else { // Editar cliente existente
            this.eventosFacade.edit(evento);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EventoGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EventoGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
