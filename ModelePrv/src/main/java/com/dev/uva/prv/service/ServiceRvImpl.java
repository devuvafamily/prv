package com.dev.uva.prv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.uva.prv.dao.CreneauxAD;
import com.dev.uva.prv.dao.EmployeAD;
import com.dev.uva.prv.dao.RendezvousAD;
import com.dev.uva.prv.entite.Rendezvous;


@Service("serviceRv")
public class ServiceRvImpl implements ServiceRv {
	
	@Autowired
	RendezvousAD daoRv;
	@Autowired
	EmployeAD daoEmploye;
	@Autowired
	CreneauxAD daoCreneaux;
	
	@Override
	public void ajouterRendezVous(Rendezvous rendezvous){
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
