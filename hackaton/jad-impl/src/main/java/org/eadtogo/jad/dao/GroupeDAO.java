/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.dao;

import com.ngs.core.dao.GenericDAO;
import javax.ejb.Stateless;
import org.eadtogo.jad.entities.Groupe;

/**
 *
 * @author Ramses
 */
@Stateless
public class GroupeDAO extends GenericDAO<Groupe, Integer> implements GroupeDAOLocal {

    public GroupeDAO() {
        super(Groupe.class);
    }

}
