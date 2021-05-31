/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import dto.EventosDTO;
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
    , @NamedQuery(name = "Eventos.findByEventoId", query = "SELECT e FROM Eventos e WHERE e.eventoId = :eventoId")
    , @NamedQuery(name = "Eventos.findByTitulo", query = "SELECT e FROM Eventos e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Eventos.findByDescripcion", query = "SELECT e FROM Eventos e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Eventos.findByFecha", query = "SELECT e FROM Eventos e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Eventos.findByFechaLimite", query = "SELECT e FROM Eventos e WHERE e.fechaLimite = :fechaLimite")
    , @NamedQuery(name = "Eventos.findByCoste", query = "SELECT e FROM Eventos e WHERE e.coste = :coste")
    , @NamedQuery(name = "Eventos.findByAforo", query = "SELECT e FROM Eventos e WHERE e.aforo = :aforo")
    , @NamedQuery(name = "Eventos.findByEntradasMaxima", query = "SELECT e FROM Eventos e WHERE e.entradasMaxima = :entradasMaxima")
    , @NamedQuery(name = "Eventos.findByFilas", query = "SELECT e FROM Eventos e WHERE e.filas = :filas")
    , @NamedQuery(name = "Eventos.findByColumnas", query = "SELECT e FROM Eventos e WHERE e.columnas = :columnas")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENTO_ID")
    private Integer eventoId;
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
    @Column(name = "FECHA_LIMITE")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
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
    @Column(name = "ENTRADAS_MAXIMA")
    private int entradasMaxima;
    @Column(name = "FILAS")
    private Integer filas;
    @Column(name = "COLUMNAS")
    private Integer columnas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoId")
    private List<Reservas> reservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoId")
    private List<Etiquetas> etiquetasList;

    public Eventos() {
    }

    public Eventos(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Eventos(Integer eventoId, String titulo, String descripcion, Date fecha, Date fechaLimite, double coste, int aforo, int entradasMaxima) {
        this.eventoId = eventoId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fechaLimite = fechaLimite;
        this.coste = coste;
        this.aforo = aforo;
        this.entradasMaxima = entradasMaxima;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
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

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
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

    public int getEntradasMaxima() {
        return entradasMaxima;
    }

    public void setEntradasMaxima(int entradasMaxima) {
        this.entradasMaxima = entradasMaxima;
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
    public List<Reservas> getReservasList() {
        return reservasList;
    }

    public void setReservasList(List<Reservas> reservasList) {
        this.reservasList = reservasList;
    }

    @XmlTransient
    public List<Etiquetas> getEtiquetasList() {
        return etiquetasList;
    }

    public void setEtiquetasList(List<Etiquetas> etiquetasList) {
        this.etiquetasList = etiquetasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoId != null ? eventoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.eventoId == null && other.eventoId != null) || (this.eventoId != null && !this.eventoId.equals(other.eventoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Eventos[ eventoId=" + eventoId + " ]";
    }

    public EventosDTO getDTO() {
        EventosDTO dto = new EventosDTO();
 
        dto.setTitulo(titulo);
        dto.setAforo(eventoId);
        dto.setCoste(coste);
        dto.setDescripcion(descripcion);
        dto.setEntradasMaxima(entradasMaxima);
        dto.setEventoId(eventoId);
        dto.setFecha(fecha);
        dto.setFechaLimite(fechaLimite);
 
        return dto;
    }
    
}
