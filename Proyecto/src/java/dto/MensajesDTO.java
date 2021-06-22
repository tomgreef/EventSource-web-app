/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.MensajesPK;

/**
 *
 * @author kkeyl
 */
public class MensajesDTO {
     
    protected MensajesPK mensajesPK;
    private String mensaje;
    private ChatsDTO chats;
    private UsuariosDTO usuarios;

    public MensajesDTO(){
        
    }
    
    public MensajesPK getMensajesPK() {
        return mensajesPK;
    }

    public void setMensajesPK(MensajesPK mensajesPK) {
        this.mensajesPK = mensajesPK;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ChatsDTO getChats() {
        return chats;
    }

    public void setChats(ChatsDTO chats) {
        this.chats = chats;
    }

    public UsuariosDTO getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosDTO usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
