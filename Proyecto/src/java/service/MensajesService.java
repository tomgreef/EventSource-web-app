/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MensajesFacade;
import dao.UsuariosFacade;
import dto.MensajesDTO;
import entidades.Mensajes;
import entidades.Usuarios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kkeyl
 */

@Stateless
public class MensajesService {
    
    @EJB
    MensajesFacade mensajesFacade;
    
    @EJB
    UsuariosFacade usuariosFacade;
    
    protected List<MensajesDTO> convertirAListaDTO(List<Mensajes> lista) {

        if (lista != null) {
            List<MensajesDTO> listaDTO = new ArrayList<>();
            lista.forEach((mensaje) -> {
                listaDTO.add(mensaje.getDTO());
            });
            return listaDTO;
        } else {
            return null;
        }
    }
    
    public List<MensajesDTO> listarMensajes(String chatId){
        List<Mensajes> mensajes = this.mensajesFacade.getMensajesById(chatId);
      
        return this.convertirAListaDTO(mensajes);
    }
    
    public void create(String contenido, String chatId, String usuarioId) {
        
        Date date = new Date();
        Mensajes m = new Mensajes(new Integer(chatId), date, new Integer(usuarioId));
        m.setMensaje(contenido);
        Usuarios u = this.usuariosFacade.find(new Integer(usuarioId));
        m.setUsuarios(u);
        mensajesFacade.create(m);
        this.usuariosFacade.edit(u);

        this.mensajesFacade.create(m);
    }
    
    
    
}
