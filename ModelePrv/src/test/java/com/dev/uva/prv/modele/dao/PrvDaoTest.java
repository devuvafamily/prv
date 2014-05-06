package com.dev.uva.prv.modele.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.dev.uva.prv.modele.entite.Client;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class PrvDaoTest {

	@Autowired
	RendezvousAD daoRv;
	@Autowired
	EmployeAD daoEmploye;
	@Autowired
	CreneauxAD daoCreneaux;
	@Autowired
	ClientAD daoClient;
	@Autowired
	RoleAD daoRole;
	
	@Test
	public void testAjouterEmploye() {
		Client client = new Client();
		client.setNom("Fall");
		client.setPrenom("Bafal");
		client.setCivilite("Mr");
		client.setAdresse("396 Rue de la Reine");
		client.setCodeClient("bafal");
		client.setCodePostal("G1K2R2");
		client.setCourriel("bafal.fall@uva.sn");
		client.setTelephone("4182628018");
		client.setVille("Quebec");
		client.setProvince("QC");
		
		//daoClient.persist(client);
		assertTrue("Insertion succes", client.getCodeClient()!=null);
		
	}

}
