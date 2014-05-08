package com.dev.uva.prv.modele.entite;
import java.util.Date;

import javax.persistence.CascadeType;
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


@Configurable
@Entity
@Table(name = "rendezvous")
public class Rendezvous {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RV")
    private Integer idRv;

    public Integer getIdRv() {
        return this.idRv;
    }

    public void setIdRv(Integer id) {
        this.idRv = id;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CRENEAUX", referencedColumnName = "ID_CRENEAUX")
    private Creneaux idCreneaux;

    @ManyToOne /*(cascade = { CascadeType.PERSIST, CascadeType.MERGE })*/
    @JoinColumn(name = "CODE_CLIENT", referencedColumnName = "CODE_CLIENT", nullable = false)
    private Client codeClient;

    @Column(name = "JOUR_RV")
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date jourRv;

    @Column(name = "NOTES_RV", length = 500)
    private String notesRv;
    
    @Column(name = "MODE_COMMUNICATION", length = 200)
    private String modeCommunication;
    
    @Column(name = "NATURE_DEMANDE", length = 200)
    private String natureDemande;
    
    @Column(name = "NATURE_DMD_AUTRE", length = 200)
    private String natureDemandeAutre;

    public String getNatureDemandeAutre() {
		return natureDemandeAutre;
	}

	public void setNatureDemandeAutre(String natureDemandeAutre) {
		this.natureDemandeAutre = natureDemandeAutre;
	}

	public String getNatureDemande() {
		return natureDemande;
	}

	public void setNatureDemande(String natureDemande) {
		this.natureDemande = natureDemande;
	}

	public String getModeCommunication() {
		return modeCommunication;
	}

	public void setModeCommunication(String modeCommunication) {
		this.modeCommunication = modeCommunication;
	}

	public Creneaux getIdCreneaux() {
        return idCreneaux;
    }

    public void setIdCreneaux(Creneaux idCreneaux) {
        this.idCreneaux = idCreneaux;
    }

    public Client getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Client codeClient) {
        this.codeClient = codeClient;
    }

    public Date getJourRv() {
        return jourRv;
    }

    public void setJourRv(Date jourRv) {
        this.jourRv = jourRv;
    }

    public String getNotesRv() {
        return notesRv;
    }

    public void setNotesRv(String notesRv) {
        this.notesRv = notesRv;
    }

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("idCreneaux", "codeClient").toString();
    }

}
