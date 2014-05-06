package com.dev.uva.prv.commun;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.dev.uva.prv.modele.entite.Rendezvous;

/**
 * Classe utilitaire de validation 
 * @author bafal
 * @version Prv - v.1.0
 *
 */
public class UtilitaireValidation {
	
	/**
	 * Liste des expressions régulières.
	 */
	private static final String REGEX_COURRIEL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	private static final String REGEX_MOTDEPASSE = "^(?=(.*[0-9]){2,})(?=(.*[A-Za-z]){6,})[A-Za-z0-9]{8,}$";
	private static final String REGEX_TELEPHONE =    "\\d{3}-\\d{3}-\\d{4}";
	
	/**
	 * Journalisation LOG4J - (A ne pas oublier--> très utile lors du debugage )
	 */
	Logger logger = Logger.getLogger(UtilitaireValidation.class);
	
	private static final UtilitaireValidation singleton = new UtilitaireValidation();
	
	public static UtilitaireValidation getInstance(){
		return singleton;
	}
	
	/**
	 * Permet de valider le courriel du client
	 * @param courriel le courriel 
	 * @return <code>True</code> si le format est valide.
	 * @throws PrvException 
	 */
	public static boolean validerCourriel(String courriel){
		if(!isFormatCourrielValide(courriel)){
			//logger.debug(new PrvException());
			//throw new PrvException("Le format du courriel est invalide");
			return false;
			
		}
		return true;
		
	}
	
	
	/**
	 * Validation du format du courriel du client avec une expression régulière
	 * @param courriel le courriel du client
	 * @return <code>True</code> si le format est valide.
	 */
	public static boolean isFormatCourrielValide(String courriel){
		Pattern pattern = Pattern.compile(REGEX_COURRIEL);
        return pattern.matcher(courriel).matches();
	}
	

}
