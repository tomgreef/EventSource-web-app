/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomvg
 */
@Entity
@Table(name = "MENSAJES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")
    , @NamedQuery(name = "Mensajes.findByChatId", query = "SELECT m FROM Mensajes m WHERE m.mensajesPK.chatId = :chatId")
    , @NamedQuery(name = "Mensajes.findByFechaYHora", query = "SELECT m FROM Mensajes m WHERE m.mensajesPK.fechaYHora = :fechaYHora")
    , @NamedQuery(name = "Mensajes.findByUsuariosId", query = "SELECT m FROM Mensajes m WHERE m.mensajesPK.usuariosId = :usuariosId")
    , @NamedQuery(name = "Mensajes.findByMensaje", query = "SELECT m FROM Mensajes m WHERE m.mensaje = :mensaje")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MensajesPK mensajesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MENSAJE")
    private String mensaje;
    @JoinColumn(name = "CHAT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chats chats;
    @JoinColumn(name = "USUARIOS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Mensajes() {
    }

    public Mensajes(MensajesPK mensajesPK) {
        this.mensajesPK = mensajesPK;
    }

    public Mensajes(MensajesPK mensajesPK, String mensaje) {
        this.mensajesPK = mensajesPK;
        this.mensaje = mensaje;
    }

    public Mensajes(int chatId, Date fechaYHora, int usuariosId) {
        this.mensajesPK = new MensajesPK(chatId, fechaYHora, usuariosId);
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

    public Chats getChats() {
        return chats;
    }

    public void setChats(Chats chats) {
        this.chats = chats;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensajesPK != null ? mensajesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.mensajesPK == null && other.mensajesPK != null) || (this.mensajesPK != null && !this.mensajesPK.equals(other.mensajesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mensajes[ mensajesPK=" + mensajesPK + " ]";
    }
    
}
