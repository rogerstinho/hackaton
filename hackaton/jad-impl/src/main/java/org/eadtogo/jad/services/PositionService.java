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
import org.eadtogo.jad.dao.PositionDAOLocal;
import org.eadtogo.jad.entities.Position;

/**
 *
 * @author kouroger
 */
@Stateless
public class PositionService extends GenericService<Position, Integer>
        implements PositionServiceRemote {

    @EJB
    private PositionDAOLocal dao;

    @Override
    protected GenericDAOLocal<Position, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public Integer getId(Position e) {
        return e.getId();
    }

}
