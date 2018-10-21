package org.eadtogo.jad.entities;

import com.ngs.core.entities.BaseEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rkoufionou
 * @since 05/06/2018
 * @version 1.0.0
 */
@Entity
@Table(name = "hack_membres")
public class Membre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifant")
    private Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenoms", nullable = false, length = 100)
    private String prenoms;

    @Column(name = "tel", nullable = false, length = 20)
    private String tel;

    @Column(name = "whatsapp", length = 20)
    private String whatsapp;

    @Column(name = "adresse", length = 100)
    private String adresse;

    @Column(name = "commentaire", length = 100)
    private String commentaire;

    @Column(name = "date_integration", length = 100)
    @Temporal(TemporalType.DATE)
    private Date dateIntegration = new Date();

    @ManyToOne
    @JoinColumn(name = "profession", referencedColumnName = "id")
    private Profession profession;

    @ManyToOne
    @JoinColumn(name = "groupe", referencedColumnName = "id")
    private Groupe groupe;

//    @Lob
//    @Column(name = "profile")
//    private byte[] profile;

    public Membre() {
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

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Date getDateIntegration() {
        return dateIntegration;
    }

    public void setDateIntegration(Date dateIntegration) {
        this.dateIntegration = dateIntegration;
    }

//    public byte[] getProfile() {
//        return profile;
//    }
//
//    public void setProfile(byte[] profile) {
//        this.profile = profile;
//    }
//    
    @Override
    public String toString() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + '}';
    }

}
