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
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private int usuarioId;

    public MensajesPK() {
    }

    public MensajesPK(int chatId, Date fecha, int usuarioId) {
        this.chatId = chatId;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) chatId;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) usuarioId;
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
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MensajesPK[ chatId=" + chatId + ", fecha=" + fecha + ", usuarioId=" + usuarioId + " ]";
    }
    
}
