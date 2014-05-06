package com.dev.uva.prv.modele.entite;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "role")
@Configurable
public class Role {

	@Column(name = "CODE_APPLICATION", length = 45)
    @NotNull
    private String codeApplication;

	@Column(name = "DATE_DEBUT_ACT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateDebutAct;

	@Column(name = "DATE_FIN_ACT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateFinAct;

	@Column(name = "CREE_PAR", length = 50)
    private String creePar;

	@Column(name = "MODIFIE_PAR", length = 50)
    private String modifiePar;

	@Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateCreation;

	@Column(name = "DATE_MODIF")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dateModif;
	
	
    @ManyToOne
    @JoinColumn(name = "CODE_UTILISATEUR", referencedColumnName = "CODE_UTILISATEUR", nullable = false)
    private Employe codeUtilisateur;
    
    public Employe getCodeUtilisateur() {
        return codeUtilisateur;
    }

    public void setCodeUtilisateur(Employe codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }

	public String getCodeApplication() {
        return codeApplication;
    }

	public void setCodeApplication(String codeApplication) {
        this.codeApplication = codeApplication;
    }

	public Date getDateDebutAct() {
        return dateDebutAct;
    }

	public void setDateDebutAct(Date dateDebutAct) {
        this.dateDebutAct = dateDebutAct;
    }

	public Date getDateFinAct() {
        return dateFinAct;
    }

	public void setDateFinAct(Date dateFinAct) {
        this.dateFinAct = dateFinAct;
    }

	public String getCreePar() {
        return creePar;
    }

	public void setCreePar(String creePar) {
        this.creePar = creePar;
    }

	public String getModifiePar() {
        return modifiePar;
    }

	public void setModifiePar(String modifiePar) {
        this.modifiePar = modifiePar;
    }

	public Date getDateCreation() {
        return dateCreation;
    }

	public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

	public Date getDateModif() {
        return dateModif;
    }

	public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODE_ROLE", length = 30)
    private String codeRole;

	public String getCodeRole() {
        return this.codeRole;
    }

	public void setCodeRole(String id) {
        this.codeRole = id;
    }

}
