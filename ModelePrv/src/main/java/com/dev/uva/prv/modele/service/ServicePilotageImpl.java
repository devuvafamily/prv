package com.dev.uva.prv.modele.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.uva.prv.modele.dao.ClientAD;
import com.dev.uva.prv.modele.dao.CreneauxAD;
import com.dev.uva.prv.modele.dao.EmployeAD;
import com.dev.uva.prv.modele.dao.RendezvousAD;
import com.dev.uva.prv.modele.entite.Rendezvous;

@Service("servicePilotage")
public class ServicePilotageImpl implements ServicePilotage {
	
	@Autowired
	private RendezvousAD daoRv;
	@Autowired
	private EmployeAD daoEmploye;
	@Autowired
	private CreneauxAD daoCreneaux;
	@Autowired
	private ClientAD daoClient;
	@Override
	
	public List<Rendezvous> obtenirListeRv() {
		return daoRv.findAllRendezvouses();
	}
	
	

}
