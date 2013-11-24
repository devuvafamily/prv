package com.dev.uva.prv.entite;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;


@Configurable
@Entity
@Table(name = "creneaux")
public class Creneaux {

    @OneToMany(mappedBy = "idCreneaux")
    private Set<Rendezvous> rendezvouses;

    @ManyToOne
    @JoinColumn(name = "CODE_UTILISATEUR", referencedColumnName = "CODE_UTILISATEUR", nullable = false)
    private Employe codeUtilisateur;

    @Column(name = "INFOS_CRENEAUX", length = 200)
    private String infosCreneaux;

    @Column(name = "HEURE_DEBUT")
    private Integer heureDebut;

    @Column(name = "HEURE_FIN")
    private Integer heureFin;

    @Column(name = "MINUTE_DEBUT")
    private Integer minuteDebut;

    @Column(name = "MINUTE_FIN")
    private Integer minuteFin;

    public Set<Rendezvous> getRendezvouses() {
        return rendezvouses;
    }

    public void setRendezvouses(Set<Rendezvous> rendezvouses) {
        this.rendezvouses = rendezvouses;
    }

    public Employe getCodeUtilisateur() {
        return codeUtilisateur;
    }

    public void setCodeUtilisateur(Employe codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }

    public String getInfosCreneaux() {
        return infosCreneaux;
    }

    public void setInfosCreneaux(String infosCreneaux) {
        this.infosCreneaux = infosCreneaux;
    }

    public Integer getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Integer heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Integer getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Integer heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getMinuteDebut() {
        return minuteDebut;
    }

    public void setMinuteDebut(Integer minuteDebut) {
        this.minuteDebut = minuteDebut;
    }

    public Integer getMinuteFin() {
        return minuteFin;
    }

    public void setMinuteFin(Integer minuteFin) {
        this.minuteFin = minuteFin;
    }


    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("rendezvouses", "codeUtilisateur").toString();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CRENEAUX")
    private Integer idCreneaux;

    public Integer getIdCreneaux() {
        return this.idCreneaux;
    }

    public void setIdCreneaux(Integer id) {
        this.idCreneaux = id;
    }
}
