
package com.dev.uva.prv.accueil;

import com.dev.uva.prv.commun.PrvBaseAction;

/**
 * Classe Controlleur de la connexion d'un client.
 * @author bafal
 *
 */
public class Connexion extends PrvBaseAction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * point d'entrée
	 */
	public String execute() throws Exception {

        if (isInvalid(getUsername())) 
        	return INPUT;

        if (isInvalid(getPassword())) 
        	return INPUT;

        return SUCCESS;
    }

    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}