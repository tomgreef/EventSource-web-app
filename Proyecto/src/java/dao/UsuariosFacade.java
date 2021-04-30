/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuarios;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public Usuarios findByEmailAndPassword(String email, String password) {
        Query q;
        List<Usuarios> listaUsuarios;

        q = this.em.createQuery("SELECT a FROM Usuarios a WHERE a.email = :email AND a.password = :password");
        //q = this.getEntityManager().createNamedQuery("Usuarios.findByEmailAndPassword");
        q.setParameter("email", email);
        q.setParameter("password", password);

        listaUsuarios = q.getResultList();

        if (listaUsuarios == null || listaUsuarios.isEmpty()) {
            return null;
        } else {
            return listaUsuarios.get(0);
        }
    }
}
