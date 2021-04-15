/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Chats.findById", query = "SELECT c FROM Chats c WHERE c.id = :id")
    , @NamedQuery(name = "Chats.findByFechaYHora", query = "SELECT c FROM Chats c WHERE c.fechaYHora = :fechaYHora")})
public class Chats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_Y_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaYHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chats")
    private Collection<Mensajes> mensajesCollection;
    @JoinColumn(name = "USUARIOS_ID1", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios usuariosId1;
    @JoinColumn(name = "USUARIOS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Chats() {
    }

    public Chats(Integer id) {
        this.id = id;
    }

    public Chats(Integer id, Date fechaYHora) {
        this.id = id;
        this.fechaYHora = fechaYHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    @XmlTransient
    public Collection<Mensajes> getMensajesCollection() {
        return mensajesCollection;
    }

    public void setMensajesCollection(Collection<Mensajes> mensajesCollection) {
        this.mensajesCollection = mensajesCollection;
    }

    public Usuarios getUsuariosId1() {
        return usuariosId1;
    }

    public void setUsuariosId1(Usuarios usuariosId1) {
        this.usuariosId1 = usuariosId1;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chats)) {
            return false;
        }
        Chats other = (Chats) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Chats[ id=" + id + " ]";
    }
    
}
