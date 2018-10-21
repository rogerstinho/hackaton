/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.dao;

import com.ngs.core.dao.GenericDAO;
import javax.ejb.Stateless;
import org.eadtogo.jad.entities.CategorieOrgane;

/**
 *
 * @author Ramses
 */
@Stateless
public class CategorieOrganeDAO extends GenericDAO<CategorieOrgane, Integer> implements CategorieOrganeDAOLocal {

    public CategorieOrganeDAO() {
        super(CategorieOrgane.class);
    }

}
