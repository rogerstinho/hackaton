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
@Table(name = "hack_organes")
public class Organe extends BaseEntity {

    public static int ETAT_INITIAL = 1;
    public static int ETAT_VALIDE = 2;
    public static int ETAT_EN_ATTENTE = 3;

    public static int CAT_EGLISE = 1;
    public static int CAT_ONG = 3;
    public static int CAT_AUTRE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "confession", length = 50)
    private String confession;

    @Column(name = "categorie_organe", nullable = false, length = 50)
    private int categorieOrgane;

    @Column(name = "doctrine",  length = 50)
    private String doctrine;

    @Column(name = "description",  length = 500)
    private String description;

    @Column(name = "etat", nullable = false, length = 50)
    private int etat = ETAT_INITIAL;

    @Column(name = "lat", nullable = false)
    private double lat;

    @Column(name = "lng", nullable = false)
    private double lng;

    @ManyToOne
    @JoinColumn(name = "position", referencedColumnName = "id")
    private Position position;

    public Organe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static int getETAT_INITIAL() {
        return ETAT_INITIAL;
    }

    public static void setETAT_INITIAL(int ETAT_INITIAL) {
        Organe.ETAT_INITIAL = ETAT_INITIAL;
    }

    public static int getETAT_VALIDE() {
        return ETAT_VALIDE;
    }

    public static void setETAT_VALIDE(int ETAT_VALIDE) {
        Organe.ETAT_VALIDE = ETAT_VALIDE;
    }

    public static int getETAT_EN_ATTENTE() {
        return ETAT_EN_ATTENTE;
    }

    public static void setETAT_EN_ATTENTE(int ETAT_EN_ATTENTE) {
        Organe.ETAT_EN_ATTENTE = ETAT_EN_ATTENTE;
    }

    public static int getCAT_EGLISE() {
        return CAT_EGLISE;
    }

    public static void setCAT_EGLISE(int CAT_EGLISE) {
        Organe.CAT_EGLISE = CAT_EGLISE;
    }

    public static int getCAT_ONG() {
        return CAT_ONG;
    }

    public static void setCAT_ONG(int CAT_ONG) {
        Organe.CAT_ONG = CAT_ONG;
    }

    public static int getCAT_AUTRE() {
        return CAT_AUTRE;
    }

    public static void setCAT_AUTRE(int CAT_AUTRE) {
        Organe.CAT_AUTRE = CAT_AUTRE;
    }

    public int getCategorieOrgane() {
        return categorieOrgane;
    }

    public void setCategorieOrgane(int categorieOrgane) {
        this.categorieOrgane = categorieOrgane;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getConfession() {
        return confession;
    }

    public void setConfession(String confession) {
        this.confession = confession;
    }

    public String getDoctrine() {
        return doctrine;
    }

    public void setDoctrine(String doctrine) {
        this.doctrine = doctrine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    
    
    

    @Override
    public String toString() {
        return "Organe{" + "id=" + id + ", nom=" + nom + ", confession=" + confession + ", categorieOrgane=" + categorieOrgane + ", doctrine=" + doctrine + ", description=" + description + ", etat=" + etat + ", position=" + position + '}';
    }

}
