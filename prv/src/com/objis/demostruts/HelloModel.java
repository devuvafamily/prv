package com.objis.demostruts;

/**
 * <p>C'est le composant 'Modèle' qui cotient simplement le nom de la personne à qui on va dire "Hello!".
 * <p>
 *
 * Dans une application plus avancée, ce composant mettrait à jour un stockage persistant
 * avec le nom de la personne, l'utiliserai comme argument d'appel à un POJO, un DAO 
 * ou l'enverrait pour traitement dans un système distant (Service web, EJB..).
 *
 * @author Douglas MBIANDOU
 */

public class HelloModel {

    // --------------------------------------------------- Instance Variables

    /**
     * La personne à qui on va dire "Hello!"
     */
    private String _person = null;

    // ----------------------------------------------------------- Properties

    /**
     * Retourne la nouvelle personne à qui on va dire "Hello!"
     *
     * @return String la nouvelle personne à qui on va dire "Hello!"
     */
    public String getPerson() {
        return this._person;
    }

    /**
     * Initialise La personne à qui on va dire "Hello!"
     *
     * @param person La nouvelle personne à qui on va dire "Hello!"
     */
    public void setPerson(String person) {

        this._person = person;

    }

    // --------------------------------------------------------- Methodes publiques

    /**
     * C'est le squelette de la méthode qu'on utiliserait pour le modèle pour sauver
     * l'information entrée dans un stockage persistent. 
     * Dans cette application simple, ce n'est pas utilisé.
     */
    public void saveToPersistentStore() {

        /*
         * Dans une application réelle, c'est ici qu'il faudrait mettre le code pour la persistance (Ex avec Hibernate).
         *
         * Les opérations métier dépendentde l'application.
         */
    }



}
