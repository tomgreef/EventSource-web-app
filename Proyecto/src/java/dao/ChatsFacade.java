/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Chats;
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
public class ChatsFacade extends AbstractFacade<Chats> {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChatsFacade() {
        super(Chats.class);
    }
    
    public List<Chats> getChatsUsuario(String id){
        Query q;
        
        q = em.createQuery("SELECT c FROM Chats c WHERE c.usuarioId.usuarioId = :usuarioId");
        q.setParameter("usuarioId", new Integer(id));
        return q.getResultList(); 
    }
    
    public List<Chats> getChatsUsuarioByNombre(String nombre){
        Query q;
        
        q = em.createQuery("SELECT c FROM Chats c WHERE lower(c.usuarioId.nombre) LIKE :nombre OR lower(c.teleoperadorId.nombre) LIKE :nombre");
        q.setParameter("nombre", "%" + nombre+ "%");
        return q.getResultList(); 
    }
}
