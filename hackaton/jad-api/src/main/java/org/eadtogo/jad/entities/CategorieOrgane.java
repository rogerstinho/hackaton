package org.eadtogo.jad.entities;

import com.ngs.core.entities.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rkoufionou
 * @since 05/06/2018
 * @version 1.0.0
 */
@Entity
@Table(name = "jad_categorie_organe")
public class CategorieOrgane extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;

    public CategorieOrgane() {
    }

    public CategorieOrgane(String libelle) {
        this.libelle = libelle;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "CategorieOrgane{" + "id=" + id + ", libelle=" + libelle + '}';
    }

}
