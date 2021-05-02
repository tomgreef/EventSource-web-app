/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tomvg
 */
@Entity
@Table(name = "CHATS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chats.findAll", query = "SELECT c FROM Chats c")
    , @NamedQuery(name = "Chats.findByChatId", query = "SELECT c FROM Chats c WHERE c.chatId = :chatId")
    , @NamedQuery(name = "Chats.findByFecha", query = "SELECT c FROM Chats c WHERE c.fecha = :fecha")})
public class Chats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CHAT_ID")
    private Integer chatId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chats")
    private List<Mensajes> mensajesList;
    @JoinColumn(name = "TELEOPERADOR_ID", referencedColumnName = "USUARIO_ID")
    @ManyToOne(optional = false)
    private Usuarios teleoperadorId;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Chats() {
    }

    public Chats(Integer chatId) {
        this.chatId = chatId;
    }

    public Chats(Integer chatId, Date fecha) {
        this.chatId = chatId;
        this.fecha = fecha;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Mensajes> getMensajesList() {
        return mensajesList;
    }

    public void setMensajesList(List<Mensajes> mensajesList) {
        this.mensajesList = mensajesList;
    }

    public Usuarios getTeleoperadorId() {
        return teleoperadorId;
    }

    public void setTeleoperadorId(Usuarios teleoperadorId) {
        this.teleoperadorId = teleoperadorId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatId != null ? chatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chats)) {
            return false;
        }
        Chats other = (Chats) object;
        if ((this.chatId == null && other.chatId != null) || (this.chatId != null && !this.chatId.equals(other.chatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Chats[ chatId=" + chatId + " ]";
    }
    
}
