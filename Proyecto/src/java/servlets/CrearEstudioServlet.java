/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.EstudiosFacade;
import dao.UsuariosFacade;
import entidades.Estudios;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
@WebServlet(name = "CrearEstudioServlet", urlPatterns = {"/CrearEstudioServlet"})
public class CrearEstudioServlet extends HttpServlet {

    @EJB
    private EstudiosFacade estudiosFacade;

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
        String strTo = "index.jsp";
        
        String estudioID = request.getParameter("estudioID");
        String nombre = request.getParameter("nombre");
        String edadInicial = request.getParameter("edadInicial");
        String edadFinal = request.getParameter("edadFinal");
        String fechaInicial = request.getParameter("fechaInicial");
        String fechaFinal = request.getParameter("fechaFinal");
        String sexo = request.getParameter("sexo");
        
        Estudios estudio;
        
        if (estudioID == null || estudioID.isEmpty()) {
            estudio = new Estudios();
        } else {
            estudio = this.estudiosFacade.findByID(new Integer(estudioID));
        }
        
        estudio.setNombre(nombre);
        estudio.setEdadInferior(new Integer(edadInicial));
        estudio.setEdadSuperior(new Integer(edadFinal));
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
        estudio.setSexo(new Integer(sexo));
        
        if(estudioID == null || estudioID.isEmpty()){
            HttpSession session = request.getSession();
            this.estudiosFacade.create(estudio);
            Usuarios analista = (Usuarios) session.getAttribute("usuario");
            if (analista != null && analista.getRol() == 2){
                strTo = "EstudiosListar";
            }
        } else { //Editar un estudio
            strTo = "EstudiosListar";
            this.estudiosFacade.edit(estudio);
        }
                
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
