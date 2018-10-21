/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ngs.core.dao.GenericDAOLocal;
import com.ngs.core.service.GenericService;
import java.util.List;
import org.eadtogo.jad.dao.MembreDAOLocal;
import org.eadtogo.jad.entities.Membre;

/**
 *
 * @author kouroger
 */
@Stateless
public class MembreService extends GenericService<Membre, Integer>
        implements MembreServiceRemote {

    @EJB
    private MembreDAOLocal dao;

    @Override
    protected GenericDAOLocal<Membre, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(Membre e) {
        return e.getId();
    }

    @Override
    public List<String> getAdresses() {
        return this.dao.getAdresses();
    }

}
