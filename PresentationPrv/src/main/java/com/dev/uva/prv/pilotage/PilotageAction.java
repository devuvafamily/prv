package com.dev.uva.prv.pilotage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.commun.PrvBaseAction;
import com.dev.uva.prv.modele.entite.Rendezvous;
import com.dev.uva.prv.modele.service.ServicePilotage;
import com.opensymphony.xwork2.ModelDriven;

@Configurable
@Transactional
public class PilotageAction extends PrvBaseAction implements ModelDriven<Rendezvous>,
ServletRequestAware, SessionAware{

	@Autowired
	private ServicePilotage servicePilotage;
	
	private Map<String, Object> session;
	private HttpServletRequest request;
	private Rendezvous rv = new Rendezvous();
	
	private List<Rendezvous> listeRv = new ArrayList<Rendezvous>();
	
	public List<Rendezvous> getListeRv() {
		return listeRv;
	}



	public void setListeRv(List<Rendezvous> listeRv) {
		this.listeRv = listeRv;
	}



	public Rendezvous getRv() {
		return rv;
	}



	public void setRv(Rendezvous rv) {
		this.rv = rv;
	}



	/**
	 * Point d'entrée
	 */
	public String execute() {
		return "afficher";
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
	 * Permet de resetter le modele {@link Rendezvous}
	 * 
	 * @return
	 */
	@SkipValidation
	public String clearModel() {
		session.remove(rv);
		this.setRv(new Rendezvous());
		return "afficher";
	}
	
	public String afficherListe(){
		List<Rendezvous> listeRv = servicePilotage.obtenirListeRv();
		this.setListeRv(listeRv);
		return "afficher";
	}
}
