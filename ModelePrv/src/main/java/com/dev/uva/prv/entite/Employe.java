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
@Table(name = "Employe")
@Configurable
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODE_UTILISATEUR", length = 50)
    private String codeUtilisateur;

    public String getCodeUtilisateur() {
        return this.codeUtilisateur;
    }

    public void setCodeUtilisateur(String id) {
        this.codeUtilisateur = id;
    }

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("roles").toString();
    }

    @OneToMany(mappedBy = "codeUtilisateur")
    private Set<Role> roles;

    @Column(name = "NOM", length = 100)
    @NotNull
    private String nom;

    @Column(name = "PRENOM", length = 100)
    @NotNull
    private String prenom;

    @Column(name = "COURRIEL", length = 100)
    @NotNull
    private String courriel;

    @Column(name = "TELEPHONE", length = 15)
    private String telephone;

    @Column(name = "CIVILITE", length = 10)
    @NotNull
    private String civilite;

    @Column(name = "MOT_DE_PASSE", length = 50)
    private String motDePasse;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
