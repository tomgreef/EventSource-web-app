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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ETIQUETAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etiquetas.findAll", query = "SELECT e FROM Etiquetas e")
    , @NamedQuery(name = "Etiquetas.findByEtiquetaId", query = "SELECT e FROM Etiquetas e WHERE e.etiquetaId = :etiquetaId")
    , @NamedQuery(name = "Etiquetas.findByNombre", query = "SELECT e FROM Etiquetas e WHERE e.nombre = :nombre")})
public class Etiquetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ETIQUETA_ID")
    private Integer etiquetaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID")
    @ManyToOne(optional = false)
    private Eventos eventoId;

    public Etiquetas() {
    }

    public Etiquetas(Integer etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    public Etiquetas(Integer etiquetaId, String nombre) {
        this.etiquetaId = etiquetaId;
        this.nombre = nombre;
    }

    public Integer getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(Integer etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Eventos getEventoId() {
        return eventoId;
    }

    public void setEventoId(Eventos eventoId) {
        this.eventoId = eventoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etiquetaId != null ? etiquetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiquetas)) {
            return false;
        }
        Etiquetas other = (Etiquetas) object;
        if ((this.etiquetaId == null && other.etiquetaId != null) || (this.etiquetaId != null && !this.etiquetaId.equals(other.etiquetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Etiquetas[ etiquetaId=" + etiquetaId + " ]";
    }
    
}
