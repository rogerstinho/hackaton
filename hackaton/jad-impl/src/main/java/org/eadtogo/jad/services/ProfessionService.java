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
import org.eadtogo.jad.dao.ProfessionDAOLocal;
import org.eadtogo.jad.entities.Profession;

/**
 *
 * @author kouroger
 */
@Stateless
public class ProfessionService extends GenericService<Profession, Integer>
        implements ProfessionServiceRemote {

    @EJB
    private ProfessionDAOLocal dao;

    @Override
    protected GenericDAOLocal<Profession, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(Profession e) {
        return e.getId();
    }

}
