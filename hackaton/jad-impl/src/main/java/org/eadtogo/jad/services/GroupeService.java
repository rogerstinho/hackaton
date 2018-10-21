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
import org.eadtogo.jad.dao.GroupeDAOLocal;
import org.eadtogo.jad.entities.Groupe;

/**
 *
 * @author kouroger
 */
@Stateless
public class GroupeService extends GenericService<Groupe, Integer>
        implements GroupeServiceRemote {

    @EJB
    private GroupeDAOLocal dao;

    @Override
    protected GenericDAOLocal<Groupe, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(Groupe e) {
        return e.getId();
    }

}
