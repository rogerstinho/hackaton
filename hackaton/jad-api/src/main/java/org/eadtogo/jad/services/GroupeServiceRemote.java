/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eadtogo.jad.services;

import javax.ejb.Remote;
import com.ngs.core.service.GenericServiceRemote;
import org.eadtogo.jad.entities.Groupe;

/**
 *
 * @author kouroger
 */
@Remote
public interface GroupeServiceRemote extends GenericServiceRemote<Groupe, Integer>{
    
}
