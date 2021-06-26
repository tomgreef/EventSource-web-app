/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EstudiosFacade;
import dao.UsuariosFacade;
import dto.EstudiosDTO;
import dto.UsuariosDTO;
import entidades.Estudios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Alberto
 */
@Stateless
public class EstudiosService {

    @EJB
    private UsuariosFacade usuariosFacade;

    @EJB
    private EstudiosFacade estudiosFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<EstudiosDTO> listarEstudios(){
        List<Estudios> listaEstudios = this.estudiosFacade.findAll();    
        return this.convertirADTO(listaEstudios);
    }
    
    protected List<EstudiosDTO> convertirADTO(List<Estudios> listaEstudios){
        
        if (listaEstudios != null){
            List<EstudiosDTO> listaEstudiosDTO = new ArrayList<>();
            for(Estudios estudio : listaEstudios){
                listaEstudiosDTO.add(estudio.getDTO());
            }
            return listaEstudiosDTO;
        } else {
            return null;
        }
    }
    
    public EstudiosDTO buscarEstudio(Integer id){
        Estudios estudio = this.estudiosFacade.find(new Integer(id));
        return estudio.getDTO();
    }
    
    public void crearEstudio(String nombre, UsuariosDTO analista, String edadInicial, String edadFinal, String fi, String ff, String sexo) throws ParseException{
        
        Estudios estudio = crearEstudioAuxiliar(nombre, analista, edadInicial, edadFinal, fi, ff, sexo);
        this.estudiosFacade.create(estudio);
    }
    
    public void editarEstudio(String nombre, UsuariosDTO analista, String edadInicial, String edadFinal, String fi, String ff, String sexo) throws ParseException{
        
        Estudios estudio = crearEstudioAuxiliar(nombre, analista, edadInicial, edadFinal, fi, ff, sexo);
        this.estudiosFacade.edit(estudio);
    }
    
    private Estudios crearEstudioAuxiliar(String nombre, UsuariosDTO analista, String edadInicial, String edadFinal, String fi, String ff, String sexo) throws ParseException {
    
            Estudios estudio = new Estudios();
            
            Integer ei = new Integer(edadInicial);
            Integer ef = new Integer(edadFinal);
            Integer s = new Integer(sexo);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicial = format.parse(fi);
            Date fechaFinal = format.parse(ff);
            
            
            estudio.setUsuarioId(this.usuariosFacade.find(analista.getUsuarioId()));
            estudio.setNombre(nombre);
            estudio.setEdadInferior(ei);
            estudio.setEdadSuperior(ef);
            estudio.setFechaInicial(fechaInicial);
            estudio.setFechaFinal(fechaFinal);
            
            estudio.setSexo(s);
            // Consulta
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
            // Fin de la consulta
        return estudio;
    }
    
    public void borrarEstudio(Integer id){
        Estudios estudio = this.estudiosFacade.find(new Integer(id));
        this.estudiosFacade.remove(estudio);
    }
}
