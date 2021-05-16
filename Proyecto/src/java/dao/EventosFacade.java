/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Eventos;
import entidades.Reservas;
import entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tomvg
 */
@Stateless
public class EventosFacade extends AbstractFacade<Eventos> {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventosFacade() {
        super(Eventos.class);
    }
    
    public List<Eventos> filtroNombreSimilar (String filtro){
        Query q;
        
        q = em.createNamedQuery("Eventos.findByTitulo");
        q.setParameter("titulo", "%" + filtro + "%");
        return q.getResultList();
    }
    
    public List<Eventos> filtroCosteSimilar (String filtro){
        Query q;
        
        q = em.createNamedQuery("Eventos.findByCoste");
        q.setParameter("coste", "%" + filtro + "%");
        return q.getResultList();
    }
    
    public List<Eventos> filtroFechaInicio (String filtro){
        Query q;
        
        q = em.createNamedQuery("SELECT e FROM Eventos e WHERE e.fecha >= :fecha");
        q.setParameter("fecha", "%" + filtro + "%");
        return q.getResultList();
    }
    
    public List<Eventos> filtroFechaLimite (String filtro){
        Query q;
        
        q = em.createNamedQuery("SELECT e FROM Eventos e WHERE e.fecha <= :fecha");
        q.setParameter("fechaLimite", "%" + filtro + "%");
        return q.getResultList();
    }
    
    public List<Eventos> filter(String titulo, double coste) {
        Query q;
        List<Eventos> listaEventos;

        if (titulo.length() > 0) {
            if (coste != 0) {
                q = this.em.createQuery("SELECT a FROM Eventos a WHERE a.titulo LIKE :titulo AND a.coste <= :coste");
                q.setParameter("titulo", "%" + titulo+ "%");
                q.setParameter("coste", coste);
            } else {
                q = this.em.createQuery("SELECT a FROM Eventos a WHERE a.titulo LIKE :titulo");
                q.setParameter("titulo", "%" + titulo + "%");
            }
        } else {
            if (coste != 0) {
                q = this.em.createQuery("SELECT a FROM Eventos a WHERE a.coste <= :coste");
                q.setParameter("coste",coste);
            } else {
                q = this.em.createQuery("SELECT a FROM Eventos a");
            }
        }

        listaEventos = q.getResultList();
        return listaEventos;
    }
    
    public List<Eventos> filterAsistedAndAsisting(List<Reservas> reservas) {
        Query q;
        List<Eventos> listaEventos = new ArrayList<>();
        q = this.em.createQuery("SELECT e FROM Eventos e WHERE e.eventoId = :reservaId");
        
        for(int i=0;i<reservas.size();i++)
        {
            q.setParameter("reservaId",(reservas.get(i).getEventoId().getEventoId()));
            listaEventos.addAll(q.getResultList());
        }
        return listaEventos;
    }
    
    /*
    public List<Eventos> filtroFechaLimite (String filtro){
        Query q;
        
        q = em.createNamedQuery("SELECT e FROM Eventos e WHERE e.fecha BETWEEN :fecha AND :fechaLimite");
        q.setParameter("fechaLimite", "%" + filtro + "%");
        return q.getResultList();
    }
    */
    
    
}
