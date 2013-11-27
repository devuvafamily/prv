package com.dev.uva.prv.rv;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dev.uva.prv.commun.PrvBaseAction;
import com.dev.uva.prv.modele.entite.Creneaux;
import com.opensymphony.xwork2.ModelDriven;

public class CreneauxAction extends PrvBaseAction implements ModelDriven<Creneaux>, ServletRequestAware, SessionAware{

	/****/
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private HttpServletRequest request;
	private Creneaux creneaux;
	
	public Creneaux getModel() {
		return creneaux;
	}

	public void setSession(Map<String, Object> session) {
		this.session =  session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String enregistrer(){
		return SUCCESS;
	}

}
