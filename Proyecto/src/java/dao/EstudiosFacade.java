/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Estudios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alberto
 */
@Stateless
public class EstudiosFacade extends AbstractFacade<Estudios> {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiosFacade() {
        super(Estudios.class);
    }
    
    public Estudios findByID(Integer estudioId) {
        Query q;
        List<Estudios> listaEstudios;

        q = em.createNamedQuery("Estudios.findByEstudioId");
        q.setParameter("estudioId", estudioId);

        listaEstudios = q.getResultList();

        if (listaEstudios == null || listaEstudios.isEmpty()) {
            return null;
        } else {
            return listaEstudios.get(0);
        }
    }
    
}
