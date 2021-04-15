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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tomvg
 */
@Embeddable
public class MensajesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CHAT_ID")
    private int chatId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_Y_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaYHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIOS_ID")
    private int usuariosId;

    public MensajesPK() {
    }

    public MensajesPK(int chatId, Date fechaYHora, int usuariosId) {
        this.chatId = chatId;
        this.fechaYHora = fechaYHora;
        this.usuariosId = usuariosId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) chatId;
        hash += (fechaYHora != null ? fechaYHora.hashCode() : 0);
        hash += (int) usuariosId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensajesPK)) {
            return false;
        }
        MensajesPK other = (MensajesPK) object;
        if (this.chatId != other.chatId) {
            return false;
        }
        if ((this.fechaYHora == null && other.fechaYHora != null) || (this.fechaYHora != null && !this.fechaYHora.equals(other.fechaYHora))) {
            return false;
        }
        if (this.usuariosId != other.usuariosId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MensajesPK[ chatId=" + chatId + ", fechaYHora=" + fechaYHora + ", usuariosId=" + usuariosId + " ]";
    }
    
}
