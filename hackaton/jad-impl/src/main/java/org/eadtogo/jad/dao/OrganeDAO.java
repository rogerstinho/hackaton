/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.dao;

import com.ngs.core.dao.GenericDAO;
import javax.ejb.Stateless;
import org.eadtogo.jad.entities.Organe;

/**
 *
 * @author Ramses
 */
@Stateless
public class OrganeDAO extends GenericDAO<Organe, Integer> implements OrganeDAOLocal {

    public OrganeDAO() {
        super(Organe.class);
    }

}
