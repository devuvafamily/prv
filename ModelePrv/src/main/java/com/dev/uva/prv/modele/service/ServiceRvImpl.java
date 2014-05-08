package com.dev.uva.prv.modele.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.uva.prv.modele.dao.ClientAD;
import com.dev.uva.prv.modele.dao.CreneauxAD;
import com.dev.uva.prv.modele.dao.EmployeAD;
import com.dev.uva.prv.modele.dao.RendezvousAD;
import com.dev.uva.prv.modele.entite.Client;
import com.dev.uva.prv.modele.entite.Rendezvous;


@Service("serviceRv")
public class ServiceRvImpl implements ServiceRv {
	
	@Autowired
	RendezvousAD daoRv;
	@Autowired
	EmployeAD daoEmploye;
	@Autowired
	CreneauxAD daoCreneaux;
	@Autowired
	ClientAD daoClient;
	
	@Override
	public void ajouterRendezVous(Rendezvous rendezvous){
		if(rendezvous.getCodeClient()!= null){
			Client client = daoClient.findClient(rendezvous.getCodeClient().getCodeClient());
			if(client instanceof Client){
				daoClient.merge(rendezvous.getCodeClient());
			} else {
				daoClient.persist(rendezvous.getCodeClient());
			}
		}
		daoRv.persist(rendezvous);
	}
	
	@Override
	public Rendezvous modifierRendezVous(Rendezvous rendezvous){
		return daoRv.merge(rendezvous);
	}
	
	@Override
	public Rendezvous obtenirRendezVous(Integer idRv){
		return daoRv.findRendezvous(idRv);
	}
	
	// A completer ....

}
