package com.objis.demostruts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Bean formulaire pour l'application "Hello World!"
 *
 * @author Douglas MBIANDOU
 */

public final class HelloForm extends ActionForm {

    // --------------------------------------------------- Variables d'Instance

    /**
     * La personne à qui on va dire "Hello!"
     */

    private String person = null;
    private String ville = null;


    // ----------------------------------------------------------- Proprietes

    /**
     * Retourne la personne à qui on va dire "Hello!"
     *
     * @return String la personne à qui on va dire "Hello!"
     */
    public String getPerson() {

        return (this.person);

    }
    public String getVille() {

        return (this.ville);

    }

    /**
     * Initialise la personne.
     *
     * @param person la personne à qui on va dire "Hello!"
     */

    public void setPerson(String person) {

        this.person = person;

    }
    
    public void setVille(String ville) {

        this.ville = ville;

    }

    // --------------------------------------------------------- Methodes publiques

    /**
     * Réinitialise toutes les propriétés à leur valeur par défaut.
     *
     * @param mapping Le mapping utilisé pour sélectionner cette instance
     * @param request la requête HTTP 
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.person = null;
        this.ville = null;
    }

    /**
     * Valide les propriétés postés dans cette requête . S'il y a des erreurs de validation
     * retoure un objet <code>ActionErrors</code> contnant les erreurs.
     * Si aucune erreur de validation, retourne un code <code>null</code> ou un objet
     * <code>ActionErrors</code> vide.
     *
     * @param mapping le mapping actuel (de struts-config.xml)
     * @param request la requête HTTP
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if ((person == null) || (person.length() < 1))
        	errors.add("person", new ActionMessage("com.objis.demostruts.no.person.error"));
        
        if ((ville == null) || (ville.length() < 1))
        	errors.add("ville", new ActionMessage("com.objis.demostruts.no.ville.error"));
        
        return errors;

    }

}
