package com.dev.uva.prv.entite;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;

@Entity
@Table(name = "client")
@Configurable
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODE_CLIENT", length = 50)
    private String codeClient;

    public String getCodeClient() {
        return this.codeClient;
    }

    public void setCodeClient(String id) {
        this.codeClient = id;
    }


    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("rendezvouses").toString();
    }

    @OneToMany(mappedBy = "codeClient")
    private Set<Rendezvous> rendezvouses;

    @Column(name = "NOM", length = 100)
    @NotNull
    private String nom;

    @Column(name = "PRENOM", length = 100)
    @NotNull
    private String prenom;

    @Column(name = "COURRIEL", length = 100)
    @NotNull
    private String courriel;

    @Column(name = "CIVILITE", length = 10)
    @NotNull
    private String civilite;

    @Column(name = "TELEPHONE", length = 15)
    private String telephone;

    @Column(name = "ADRESSE", length = 200)
    private String adresse;

    @Column(name = "VILLE", length = 50)
    private String ville;

    @Column(name = "CODE_POSTAL", length = 10)
    private String codePostal;

    @Column(name = "PROVINCE", length = 50)
    private String province;

    @Column(name = "PAYS", length = 50)
    private String pays;

    @Column(name = "MOT_DE_PASSE", length = 50)
    private String motDePasse;

    public Set<Rendezvous> getRendezvouses() {
        return rendezvouses;
    }

    public void setRendezvouses(Set<Rendezvous> rendezvouses) {
        this.rendezvouses = rendezvouses;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
