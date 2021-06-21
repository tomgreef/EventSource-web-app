/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.EstudiosFacade;
import dao.UsuariosFacade;
import dto.UsuariosDTO;
import entidades.Estudios;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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
 * @author Alberto
 */
@WebServlet(name = "EstudiosGuardar", urlPatterns = {"/EstudiosGuardar"})
public class EstudiosGuardar extends HttpServlet {

    @EJB
    private UsuariosFacade usuariosFacade;

    @EJB
    private EstudiosFacade estudiosFacade;
    
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
       
        String strTo = "EstudiosListar";
        
        HttpSession session = request.getSession();
        UsuariosDTO analista = (UsuariosDTO) session.getAttribute("usuario");
        
        if(analista == null || analista.getRol() != 2){
            strTo = "login.jsp";
        } else {
            String nombre = request.getParameter("nombre");
            String edadInicial = request.getParameter("edadInicial");
            String edadFinal = request.getParameter("edadFinal");
            String fechaInicial = request.getParameter("fechaInicial");
            String fechaFinal = request.getParameter("fechaFinal");
            String sexo = request.getParameter("sexo");
        
            Estudios estudio = new Estudios();
            
            Integer ei = new Integer(edadInicial);
            Integer ef = new Integer(edadFinal);
            Integer s = new Integer(sexo);
            
            estudio.setUsuarioId(this.usuariosFacade.find(analista.getUsuarioId()));
            estudio.setNombre(nombre);
            estudio.setEdadInferior(ei);
            estudio.setEdadSuperior(ef);
            try {
                estudio.setFechaInicial(new SimpleDateFormat("dd-mm-yyyy").parse(fechaInicial));
            } catch (ParseException ex) {
                Logger.getLogger(CrearEstudioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                estudio.setFechaFinal(new SimpleDateFormat("dd-mm-yyyy").parse(fechaFinal));
            } catch (ParseException ex) {
                Logger.getLogger(CrearEstudioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            estudio.setSexo(s);
            /*
            try {
                Date fi = new SimpleDateFormat("dd-mm-yyyy").parse(fechaInicial);
                Date ff = new SimpleDateFormat("dd-mm-yyyy").parse(fechaFinal);
                
                java.sql.Date newFI = new java.sql.Date(fi.getTime());
                java.sql.Date newFF = new java.sql.Date(ff.getTime());
                
                Integer cantidad = usuariosFacade.numberOfPeople(newFI, newFF, ei, ef, s);
                estudio.setCantidad(cantidad);
                
            } catch (ParseException ex) {
                Logger.getLogger(EstudiosGuardar.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
                this.estudiosFacade.create(estudio);
        }
        
         response.sendRedirect("EstudiosListar");
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
