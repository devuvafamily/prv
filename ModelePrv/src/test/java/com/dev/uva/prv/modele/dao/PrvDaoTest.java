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
		client.setNom("Muche");
		client.setPrenom("Truc");
		client.setCivilite("Mr");
		client.setAdresse("ou steak hache");
		client.setCodeClient("bafal");
		client.setCodePostal("94800");
		client.setCourriel("truc.muche@uva.sn");
		client.setTelephone("062828282");
		client.setVille("Quebec");
		client.setProvince("QC");
		
		//daoClient.persist(client);
		assertTrue("Insertion succes", client.getCodeClient()!=null);
		
	}

}
