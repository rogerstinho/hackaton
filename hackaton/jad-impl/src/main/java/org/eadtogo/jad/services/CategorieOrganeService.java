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
import org.eadtogo.jad.dao.CategorieOrganeDAOLocal;
import org.eadtogo.jad.entities.CategorieOrgane;

/**
 *
 * @author kouroger
 */
@Stateless
public class CategorieOrganeService extends GenericService<CategorieOrgane, Integer>
        implements CategorieOrganeServiceRemote {

    @EJB
    private CategorieOrganeDAOLocal dao;

    @Override
    protected GenericDAOLocal<CategorieOrgane, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(CategorieOrgane e) {
        return e.getId();
    }

}
