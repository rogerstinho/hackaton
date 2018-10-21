/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.dao;

import com.ngs.core.dao.GenericDAO;
import javax.ejb.Stateless;
import org.eadtogo.jad.entities.Position;

/**
 *
 * @author Ramses
 */
@Stateless
public class PositionDAO extends GenericDAO<Position, Integer> implements PositionDAOLocal {

    public PositionDAO() {
        super(Position.class);
    }

}
