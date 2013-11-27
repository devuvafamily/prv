package com.objis.demostruts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.commons.beanutils.PropertyUtils;


/**
 * La classe <strong>Action</strong> de notre application "Hello".<p>
 * C'est le "Controleur" de l'architecture MVC Struts.
 *
 * @author Douglas MBIANDOU
 */

public final class HelloAction extends Action {

    /**
     * Traitement de la requête HTTP, et création de la réponse HTTP associée
     * (ou forward à un autre composant web qui va la créer).
     * retourne une instance d'<code>ActionForward</code> décrivant ou et comment
     * le conrôle doit être forwardé, ou <code>null</code> si la réponse a déja été rendue
     * 
     *
     * @param mapping l'ActionMapping utilisée pour sélectionner l'instance
     * @param actionForm l'optionel bean ActionForm pour cette requête
     * @param request requête HTTP traitée
     * @param response Réponse HTTP à créer
     *
     * @exception Exception Si la logique métier lance une exception
     */
    public ActionForward execute(ActionMapping mapping,
				                         ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws Exception {



        /*
         * Cette acttion est exécutée 
         *
         * /hello.do  - Au chargement de la page initiale
         * - ou -
         * /hello.do?action=getName - lorsqu'on poste le fomulaire
         *
         */

        // Si c'est la première fois, go straight to page
        String action = request.getParameter("action");
	      if (action == null) {
	          return (mapping.findForward("SayHello"));
        }

        // Les "messages" viennent du fichier ApplicationResources.properties
	     // MessageResources messages = getResources(request);

	      /*
         * Valide les paramètres de requête utilisateur
         * Note: Validation technique des champs réalisée dans HelloForm.java
         *       validation métier réalisée dan HelloAction.java
         */
	      ActionErrors errors = new ActionErrors();
      	String person = (String)
            PropertyUtils.getSimpleProperty(form, "person");
      	String ville = (String)
        PropertyUtils.getSimpleProperty(form, "ville");

        String badPerson = "Atilla";

        if (person.equals(badPerson)) {
            errors.add("person",
               new ActionMessage("com.objis.demostruts.dont.talk.to.atilla", badPerson ));
	          saveErrors(request, errors);
    	      return (new ActionForward(mapping.getInput()));
        }
        String badVille = "Limoges";
        if (ville.equals(badVille)) {
            errors.add("ville",
               new ActionMessage("com.objis.demostruts.dont.talk.at.limoges", badVille ));
	          saveErrors(request, errors);
    	      //return (new ActionForward(mapping.getInput()));
	          return (mapping.findForward("SayYes"));
        }

        /*
         * Ayant reçu et validé les données soumises ds la vue, 
         * on met à jour le modèle,
         */
        HelloModel hm = new HelloModel();
        hm.setPerson(person);

	  // TODO : Sauvegarde en base de données des informations 
        hm.saveToPersistentStore();

        /*
         * S'il y avait un choix de composants Vue dépendant du statut du modèle 
         * la décision à faire pour l'affichage est ici. Dans ce cas, il y a un seul composant vue
         *
         * Nous passons les données au composants vue à travers des attributs de page, 
         * de requête, de session, ou de contexte de servlet
         * Dans ce cas, le périmètre le plus approprié est contexte de requête car les 
         * données ne seront plus necesaires après que la vue ai été générée.
         *
         * Constants.HELLO_KEY fournit une clé accessible à la fois par le 
	 * composant controleur (cad cette classe) et le composant Vue 
	 * (c.a.d. la page JSP à laquelle ns forwardons).
         */

      	request.setAttribute( Constants.HELLO_KEY, hm);

        // Supprimer le bean formulaire - pas besoin des valeurs  
        request.removeAttribute(mapping.getAttribute());

	      // faire suivre le control à page de succès
	      return (mapping.findForward("SayHello"));
	      //return (mapping.findForward("Yes"));

    }
}
