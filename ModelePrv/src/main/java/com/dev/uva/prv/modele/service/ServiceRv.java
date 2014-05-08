package com.dev.uva.prv.modele.service;

import com.dev.uva.prv.modele.entite.Rendezvous;

public interface ServiceRv {

	/**
	 * Ajoute un nouveau rendez-vous à la BD. 
	 * @param rendezvous le rendez-vous
	 */
	void ajouterRendezVous(Rendezvous rendezvous);

	/**
	 * Modifie un rendez-vous existant.
	 * @param rendezvous le rendez-vous à modifier
	 * @return le rendez-vous modifié.
	 */
	Rendezvous modifierRendezVous(Rendezvous rendezvous);

	/**
	 * Obtenir le rendez-vous dont l'Id est passé en paramètre.
	 * @param idRv l'Identifiant
	 * @return le rendez-vous trouvé
	 */
	Rendezvous obtenirRendezVous(Integer idRv);

}