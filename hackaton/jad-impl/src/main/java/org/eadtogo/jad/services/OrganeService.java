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
import org.eadtogo.jad.dao.OrganeDAOLocal;
import org.eadtogo.jad.entities.Organe;

/**
 *
 * @author kouroger
 */
@Stateless
public class OrganeService extends GenericService<Organe, Integer>
        implements OrganeServiceRemote {

    @EJB
    private OrganeDAOLocal dao;

    @Override
    protected GenericDAOLocal<Organe, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(Organe e) {
        return e.getId();
    }

}
