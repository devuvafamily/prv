package com.dev.uva.prv.modele.service;

import com.dev.uva.prv.modele.entite.Rendezvous;

public interface ServiceRv {

	void ajouterRendezVous(Rendezvous rendezvous);

	Rendezvous modifierRendezVous(Rendezvous rendezvous);

	Rendezvous obtenirRendezVous(Integer idRv);

}