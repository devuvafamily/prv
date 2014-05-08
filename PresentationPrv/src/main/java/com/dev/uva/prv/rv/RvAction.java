package com.dev.uva.prv.rv;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;
import com.dev.uva.prv.commun.PrvBaseAction;
import com.dev.uva.prv.commun.UtilitaireValidation;
import com.dev.uva.prv.modele.entite.Rendezvous;
import com.dev.uva.prv.modele.service.ServiceRv;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Classe traitant les actions liées à une prise de rendez-vous.
 * 
 * ModelDriven<Rendezvous> permet d'avoir une approche FormBean: il permet de
 * fournir un objet du modele Sur lequel les données du formulaire vont être
 * stockées. L'implémentation de SessionAware permet à l'action d'acceder à la
 * session de l'utilisateur. L'implémentation de ServletRequestAware permet à
 * l'action d'acceder au Servlet request.
 * 
 * @author bafal
 * @version Prv - v.1.0
 */
/*
 * Les deux annotations qui suivent doivent etre utilisées dans toutes les
 * classes controlleur qui vont faire des transactions
 */
@Configurable
@Transactional
public class RvAction extends PrvBaseAction implements ModelDriven<Rendezvous>,
		ServletRequestAware, SessionAware {

	private static final String AFFICHER = "afficher";
	/**
	 * Exemple d'utilisation du service, l'annotation @Autowired pour
	 * l'injection de dépendances Spring Autrement dit, Unitile de faire
	 * serviceRv = new serviceRvImpl(), Spring s'en charge
	 */
	@Autowired
	private ServiceRv serviceRv;

	/**
	 * Journalisation
	 */
	Logger logger = LoggerFactory.getLogger(RvAction.class);

	private static final long serialVersionUID = 1L;
	private static final String VALIDATION = "validation";
	private Map<String, Object> session;
	private HttpServletRequest request;

	private Rendezvous rv = new Rendezvous();

	// Liste des domaines de valeur -- Juste à titre d'exemple

	private String[] listeSexes = new String[] { "Mr", "Mme", "Autre" };

	private String[] listeHeures = new String[] { "8h", "9h", "10h", "11h",
			"12h", "13h", "14h", "15h", "16h", "17h" };

	private String[] listeMinutes = new String[] { "00", "15", "30", "45" };

	private String[] listePreferences = new String[] { "Telephone", "Courriel",
			"Aucune preference" };

	private String[] listeNatureDemande = new String[] { "Passeport", "Visa",
			"Carte d'identite", "Autres" };

	private String langue;

	public String getLangue() {
		//ActionContext.getContext().get

		if(estVide(langue)){
			//ActionContext ctx = ActionContext.getContext();
			//ctx.setLocale(Locale.FRANCE);
			langue = this.getLocale().getLanguage();
		}
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String[] getListeNatureDemande() {
		return listeNatureDemande;
	}

	public void setListeNatureDemande(String[] listeNatureDemande) {
		this.listeNatureDemande = listeNatureDemande;
	}

	public String[] getListePreferences() {
		return listePreferences;
	}

	public void setListePreferences(String[] listePreferences) {
		this.listePreferences = listePreferences;
	}

	public String[] getListeHeures() {
		return listeHeures;
	}

	public void setListeHeures(String[] listeHeures) {
		this.listeHeures = listeHeures;
	}

	public String[] getListeMinutes() {
		return listeMinutes;
	}

	public void setListeMinutes(String[] listeMinutes) {
		this.listeMinutes = listeMinutes;
	}

	public Rendezvous getRv() {
		return rv;
	}

	public void setRv(Rendezvous rv) {
		this.rv = rv;
	}

	public String[] getListeSexes() {
		return listeSexes;
	}

	public void setListeSexes(String[] listeSexes) {
		this.listeSexes = listeSexes;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	/**
	 * Permet d'obtenir le modele.
	 */
	public Rendezvous getModel() {
		if (session.get("rv") == null) {
			rv.setNotesRv("une note simple");
			session.put("rv", rv);
		}
		return (Rendezvous) session.get("rv");
	}

	/**
	 * Point d'entrée
	 */
	public String execute() {
		return AFFICHER;
	}

	/**
	 * Permet de resetter le modele {@link Rendezvous}
	 * 
	 * @return
	 */
	@SkipValidation
	public String clearModel() {
		session.remove(rv);
		this.setRv(new Rendezvous());
		return AFFICHER;
	}

	/**
	 * Permet d'effectuer des validations du formulaire. (Il est aussi possible
	 * d'utiliser le modèle de validation par xml: [nom_de_l'action -
	 * validation.xml] )
	 */
	@Override
	public void validate() {
		// les validations du formulaire ici ...
	}

	/**
	 * Sauvergarde les informations concernant un rendez-vous dans la BD.
	 * 
	 * @return la redirection
	 */
	public String soumettreRv() {
		// Traitement ici ...
		// Un exemple d'utilisation du service
		if (validerFormulaire(this.getRv())) {
			try {
				logger.info("PRV : Méthode d'ajout d'un RV");
				serviceRv.ajouterRendezVous(this.getRv());
				logger.info("PRV : Nouveau RV ajouté pour le client ["
						+ this.getRv().getCodeClient().getPrenom() + " "
						+ this.getRv().getCodeClient().getPrenom()
						+ "]la date du " + this.getRv().getJourRv());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		} else {
			return AFFICHER;
		}
		return VALIDATION;
	}

	/**
	 * Traite l'annulation de la saisie d'un RV.
	 * 
	 * @return
	 */
	public String annulerRv() {
		// Traitement ici ...
		return AFFICHER;
	}

	/**
	 * Validation du formulaire avant sauvegarde des données dans la BD.
	 * 
	 * @param formulaire
	 *            le formulaire saisi.
	 * @return <code>true</code> si le formulaire est valide.
	 */
	public boolean validerFormulaire(Rendezvous formulaire) {
		boolean result = true;
		int compteurErr = 0;
		String msgMandatory = getText("prv.champObligatoire");
		if (formulaire.getCodeClient() == null
				|| estVide(formulaire.getCodeClient().getCodeClient())) {
			addFieldError("rv.codeClient.codeClient", msgMandatory);
			result = false;
			compteurErr++;
		}
		if (formulaire.getCodeClient() == null
				|| estVide(formulaire.getCodeClient().getNom())) {
			addFieldError("rv.codeClient.nom", msgMandatory);
			result = false;
			compteurErr++;
		}
		if (formulaire.getCodeClient() == null
				|| estVide(formulaire.getCodeClient().getPrenom())) {
			addFieldError("rv.codeClient.prenom", msgMandatory);
			result = false;
			compteurErr++;
		}
		if (formulaire.getCodeClient() == null
				|| estVide(formulaire.getCodeClient().getAdresse())) {
			addFieldError("rv.codeClient.adresse", msgMandatory);
			result = false;
			compteurErr++;
		}
		if (formulaire.getCodeClient() == null
				|| estVide(formulaire.getCodeClient().getCourriel())) {
			addFieldError("rv.codeClient.courriel", msgMandatory);
			result = false;
			compteurErr++;
		}
		if (!estVide(formulaire.getCodeClient().getCourriel())
				&& !UtilitaireValidation.validerCourriel(formulaire
						.getCodeClient().getCourriel())) {
			addFieldError("rv.codeClient.courriel",
					getText("prv.courriel.invalide"));
			result = false;
			compteurErr++;
		}
		if (formulaire.getJourRv() == null) {
			addFieldError("rv.jourRv", msgMandatory);
			result = false;
			compteurErr++;
		}
		if ("Autres".equals(formulaire.getNatureDemande())
				&& estVide(formulaire.getNatureDemandeAutre())) {
			addFieldError("rv.natureDemandeAutre",
					getText("prv.natureAutre.obligatoire"));
			result = false;
			compteurErr++;
		}

		if (result == false) {
			addActionError("Le formulaire contient " + compteurErr
					+ " erreur(s)");
		}
		return result;
	}

	public boolean estVide(String valeur) {
		if (valeur != null && !valeur.isEmpty()) {
			return false;
		}
		return true;
	}

}
