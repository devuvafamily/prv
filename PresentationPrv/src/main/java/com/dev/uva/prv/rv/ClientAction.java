package com.dev.uva.prv.rv;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dev.uva.prv.commun.PrvBaseAction;
import com.dev.uva.prv.modele.entite.Client;
import com.opensymphony.xwork2.ModelDriven;


public class ClientAction extends PrvBaseAction implements ModelDriven<Client>, ServletRequestAware, SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private HttpServletRequest request;
	private Client client;

	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public Client getModel() {
		return client;
	}

}
