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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tomvg
 */
@Entity
@Table(name = "EVENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e")
    , @NamedQuery(name = "Eventos.findById", query = "SELECT e FROM Eventos e WHERE e.id = :id")
    , @NamedQuery(name = "Eventos.findByTitulo", query = "SELECT e FROM Eventos e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Eventos.findByDescripcion", query = "SELECT e FROM Eventos e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Eventos.findByFecha", query = "SELECT e FROM Eventos e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Eventos.findByFechaLimiteReserva", query = "SELECT e FROM Eventos e WHERE e.fechaLimiteReserva = :fechaLimiteReserva")
    , @NamedQuery(name = "Eventos.findByCoste", query = "SELECT e FROM Eventos e WHERE e.coste = :coste")
    , @NamedQuery(name = "Eventos.findByAforo", query = "SELECT e FROM Eventos e WHERE e.aforo = :aforo")
    , @NamedQuery(name = "Eventos.findByEntradasMaximasPorUsuario", query = "SELECT e FROM Eventos e WHERE e.entradasMaximasPorUsuario = :entradasMaximasPorUsuario")
    , @NamedQuery(name = "Eventos.findByFilas", query = "SELECT e FROM Eventos e WHERE e.filas = :filas")
    , @NamedQuery(name = "Eventos.findByColumnas", query = "SELECT e FROM Eventos e WHERE e.columnas = :columnas")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_LIMITE_RESERVA")
    @Temporal(TemporalType.DATE)
    private Date fechaLimiteReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTE")
    private double coste;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AFORO")
    private int aforo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTRADAS_MAXIMAS_POR_USUARIO")
    private int entradasMaximasPorUsuario;
    @Column(name = "FILAS")
    private Integer filas;
    @Column(name = "COLUMNAS")
    private Integer columnas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoId")
    private Collection<Reservas> reservasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoId")
    private Collection<Etiquetas> etiquetasCollection;

    public Eventos() {
    }

    public Eventos(Integer id) {
        this.id = id;
    }

    public Eventos(Integer id, String titulo, String descripcion, Date fecha, Date fechaLimiteReserva, double coste, int aforo, int entradasMaximasPorUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fechaLimiteReserva = fechaLimiteReserva;
        this.coste = coste;
        this.aforo = aforo;
        this.entradasMaximasPorUsuario = entradasMaximasPorUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaLimiteReserva() {
        return fechaLimiteReserva;
    }

    public void setFechaLimiteReserva(Date fechaLimiteReserva) {
        this.fechaLimiteReserva = fechaLimiteReserva;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getEntradasMaximasPorUsuario() {
        return entradasMaximasPorUsuario;
    }

    public void setEntradasMaximasPorUsuario(int entradasMaximasPorUsuario) {
        this.entradasMaximasPorUsuario = entradasMaximasPorUsuario;
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public void setColumnas(Integer columnas) {
        this.columnas = columnas;
    }

    @XmlTransient
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    @XmlTransient
    public Collection<Etiquetas> getEtiquetasCollection() {
        return etiquetasCollection;
    }

    public void setEtiquetasCollection(Collection<Etiquetas> etiquetasCollection) {
        this.etiquetasCollection = etiquetasCollection;
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
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Eventos[ id=" + id + " ]";
    }
    
}
