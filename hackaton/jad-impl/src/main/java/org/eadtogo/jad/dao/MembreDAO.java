/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.dao;

import com.ngs.core.dao.GenericDAO;
import com.ngs.core.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import org.eadtogo.jad.entities.Membre;

/**
 *
 * @author Ramses
 */
@Stateless
public class MembreDAO extends GenericDAO<Membre, Integer> implements MembreDAOLocal {

    public MembreDAO() {
        super(Membre.class);
    }

    @Override
    public Membre getOneByID(String id) {
        Membre u = null;
        String query = "SELECT m FROM Membre m WHERE m.id =:id ";
        try {
            u = this.em.createQuery(query, Membre.class).setParameter("id", Long.valueOf(id)).getSingleResult();
        } catch (NumberFormatException e) {
            u = null;
            e.printStackTrace();
        }
        return u;
    }
    
    @Override
    public List<String> getAdresses() {
        String query = "SELECT DISTINCT(m.adresse) FROM Membre m ";
        return this.em.createQuery(query, String.class).getResultList();
    }
}
