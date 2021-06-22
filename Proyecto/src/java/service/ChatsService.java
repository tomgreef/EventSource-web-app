/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ChatsFacade;
import dao.UsuariosFacade;
import dto.ChatsDTO;
import entidades.Chats;
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
public class ChatsService {
    
    @EJB
    ChatsFacade chatsFacade;
    
    @EJB
    UsuariosFacade usuariosFacade;
    
    
    protected List<ChatsDTO> convertirAListaDTO(List<Chats> lista) {

        if (lista != null) {
            List<ChatsDTO> listaDTO = new ArrayList<>();
            lista.forEach((chat) -> {
                listaDTO.add(chat.getDTO());
            });
            return listaDTO;
        } else {
            return null;
        }
    }
    
    public List<ChatsDTO> listarChatsTeleoperador(String nombre){
        List<Chats> chats;
        if(nombre != null && nombre.length() > 0){
           chats = this.chatsFacade.getChatsUsuarioByNombre(nombre);
        } else{
            chats = this.chatsFacade.findAll();
        }
        return this.convertirAListaDTO(chats);
    }
    
    public List<ChatsDTO> listarChatsUsuario(Integer usuarioId){
        List<Chats> chats;
        chats = this.chatsFacade.getChatsUsuario(usuarioId.toString());
        
        return this.convertirAListaDTO(chats);
    }
    
    public void asignarChat(String chatId, Integer usuarioId){
        Chats chat = chatsFacade.find(new Integer(chatId));
        chat.setTeleoperadorId(this.usuariosFacade.find(usuarioId));
        chatsFacade.edit(chat);
    }
    
    public void designarChat(String chatId){
        Chats chat = chatsFacade.find(new Integer(chatId));
        chat.setTeleoperadorId(null);
        chatsFacade.edit(chat);
    }
    
    public void borrarChat(String chatId){
        Chats chat = chatsFacade.find(new Integer(chatId));

        chatsFacade.remove(chat);
    }
    
    public void crearChat(Integer usuarioId){
        
        Chats chat = new Chats();
        Usuarios usuario = this.usuariosFacade.find(usuarioId);
        Date date = new Date();
        chat.setFecha(date);
        chat.setUsuarioId(usuario);
        chat.setTeleoperadorId(null);
        
        this.chatsFacade.create(chat);
    }
    
}
