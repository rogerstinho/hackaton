/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.dao;

import com.ngs.core.dao.GenericDAOLocal;
import javax.ejb.Local;
import org.eadtogo.jad.entities.Groupe;
import org.eadtogo.jad.entities.Position;

/**
 *
 * @author kouroger
 */
@Local
public interface PositionDAOLocal extends GenericDAOLocal<Position, Integer>{
  
}
