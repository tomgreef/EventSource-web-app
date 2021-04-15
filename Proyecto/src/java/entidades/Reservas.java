/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomvg
 */
@Entity
@Table(name = "RESERVAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
    , @NamedQuery(name = "Reservas.findByIdReservas", query = "SELECT r FROM Reservas r WHERE r.idReservas = :idReservas")
    , @NamedQuery(name = "Reservas.findByCantidad", query = "SELECT r FROM Reservas r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Reservas.findByAsientoFila", query = "SELECT r FROM Reservas r WHERE r.asientoFila = :asientoFila")
    , @NamedQuery(name = "Reservas.findByAsientoColumna", query = "SELECT r FROM Reservas r WHERE r.asientoColumna = :asientoColumna")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RESERVAS")
    private Integer idReservas;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "ASIENTO_FILA")
    private Integer asientoFila;
    @Column(name = "ASIENTO_COLUMNA")
    private Integer asientoColumna;
    @JoinColumn(name = "EVENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Eventos eventoId;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Reservas() {
    }

    public Reservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getAsientoFila() {
        return asientoFila;
    }

    public void setAsientoFila(Integer asientoFila) {
        this.asientoFila = asientoFila;
    }

    public Integer getAsientoColumna() {
        return asientoColumna;
    }

    public void setAsientoColumna(Integer asientoColumna) {
        this.asientoColumna = asientoColumna;
    }

    public Eventos getEventoId() {
        return eventoId;
    }

    public void setEventoId(Eventos eventoId) {
        this.eventoId = eventoId;
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
        hash += (idReservas != null ? idReservas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReservas == null && other.idReservas != null) || (this.idReservas != null && !this.idReservas.equals(other.idReservas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reservas[ idReservas=" + idReservas + " ]";
    }
    
}
