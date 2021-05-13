/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mensajes;
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
public class MensajesFacade extends AbstractFacade<Mensajes> {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajesFacade() {
        super(Mensajes.class);
    }
    
    public List<Mensajes> getMensajesById(String id){
        Query q;
        
        //q = em.createQuery("SELECT m FROM Mensajes m");
        q = em.createQuery("SELECT m FROM Mensajes m WHERE m.mensajesPK.chatId = :chatId");
        q.setParameter("chatId", new Integer(id));
        return q.getResultList(); 
    }
}
