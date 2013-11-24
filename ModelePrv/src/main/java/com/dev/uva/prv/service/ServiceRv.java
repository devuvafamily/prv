package com.dev.uva.prv.service;

import com.dev.uva.prv.entite.Rendezvous;

public interface ServiceRv {

	void ajouterRendezVous(Rendezvous rendezvous);

	Rendezvous modifierRendezVous(Rendezvous rendezvous);

	Rendezvous obtenirRendezVous(Integer idRv);

}