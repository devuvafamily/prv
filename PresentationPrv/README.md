PRV -- Plateforme de Prise de Rendez-vous V.1.0
-----------------------------------------------------------------

##Découpage du Projet: 

1. Couche WEB : composée principalement des pages JSP et permet à l'utilisateur d'interagir avec l'application.
   Struts2 intervient principalement à ce niveau.  
   
   
2. Couche MÉTIER (Controlleur) : représente les classes d'Actions. Elle implémente la logique de l'application, dans le cas présent : 
      - ajouterRendez(), supprimerRendezvous(), ajouterClient(), modifierInfosUtilisateur() ... 
   Cette couche utilise les données des formulaires de la couche WEB(JSP) et les données de la couche DAO( Couche d'accès aux données). 
   Dans le projet actuel, cette couche est composée principalement des classes nommées [mot_cle+Action.java] 
   exemple: RvAction.java. Cette dernière étend la classe ActionSupport de Struts2. La classe ActionSupport fournit une implémentation 
   par défaut des actions les plus courantes de Struts2. 
   
   
3. Couche d'accès aux données DAO : Dans ce projet le module ModelePrv représente la couche DAO et permet la 
   communication avec la BD. Hibernate-Jpa intervient à ce niveau et son rôle principal est le mappage relationnel
   à titre d'exemple : 
    la BD MYSQL du projet PRV contient les tables suivantes : CRENEAUX, RENDEZ_VOUS, CLIENT, EMPLOYE
    Le modele va contenir les classes suivantes(Entités) :Creneaux.java, RendezVous.java, Client.java et Employe.java
    les colonnes d'une table vont être les attributs respectifs de la classe correspondante
    
                  BD MYSQL -PRV                |         MODELEPRV 
    -------------------------------------------|-------------------------------------------------------
                  RENDEZ_VOUS                  |            RendezVous.java
                  CRENEAUX                     |            Creneaux.java
                  CLIENT                       |            Client.java
    
    SPRING intervient dans cette couche(fichier src/main/resources/META-INF/spring/applicationContext.xml  ); il permet
     de créer la DATASOURCE pour la connexion à la BD  
    - datasource de connexion à MYSQL: 
      Dans applicationContext.xml .. ligne 50
~~~~
      <bean class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close" id="dataSource">
        <property name="driverClassName" value="${database.driverClassName}"/>
        <property name="url" value="${database.url}"/>
        <property name="username" value="${database.username}"/>
        <property name="password" value="${database.password}"/>
      </bean>  
~~~~
      
    - Spring permet aussi de créer des beans des classes d'accès aux données et se charge de les initialiser
      Dans applicationContext.xml .. ligne 72 à 78
    
~~~~
        <bean id="clientADImpl"  class="com.dev.uva.prv.modele.dao.ClientADImpl"/>
        <bean id="creneauxADImpl"  class="com.dev.uva.prv.modele.dao.CreneauxADImpl"/>  
        <bean id="serviceRv" class="com.dev.uva.prv.modele.service.ServiceRvImpl" />
~~~~      
        
        
 La création des beans précédents permet à la couche METIER de se dispenser de l'instanciation des classes d'accès
 aux données qu'elle va appeler.
 Exemple : Si l'on veut utiliser le service ServiceRvImpl du modele dans la couche METIER, par exemple dans 
 RvAction.java par injection de dépendances 
 (bean id="serviceRv" class="com.dev.uva.prv.modele.service.ServiceRvImpl" )
       
       
     Exemple :

~~~~          
          /**
          *
          * Exemple d'accès au service du modèle
          */
          
          @Autowired
          private ServiceRv service; 
          
          public void testInjection(){
          
          	service.ajouterRv();
          }
  ~~~~        
          
l'annotation @Autowired permet de spécifier que l'objet est créé par injection de dépendances. Il est important
d'ajouter l'annotation @Configurable dans l'entente de la classe pour cette dernière soit configurable par Spring
et @Transcationnal pour qu'elle puisse faire des transcations avec la BD (Insert, delete, ajout ...)
          
 

##Struts.xml


Permet de définir les diferentes actions. L'action est déclarée par le mot clé action, suivi du nom de la classe qui l'interprète, 
puis du nom de la méthode de la classe d'action, et enfin des JSP où seront redirigés les résultats.  
Exemple : 

~~~~
        <action name="rv" method="executer" class="com.dev.uva.prv.rv.RvAction">
            <result name="afficher">/prv/rv.jsp</result>
        </action>
~~~~ 


Dans la classe qui interprete l'action (RvAction) voici la methode execute :

~~~~  
            public String executer(){
              // Traitement ici 
              return "afficher"; // ce qui va permettre de se rediriger vers la jsp rv.jsp
                                 // (<result name="afficher">/prv/rv.jsp</result>)
            }
~~~~         
            
##WEB.XML


est le descripteur de déploiement de toute application Web. Dans notre cas, il contient les classes intercepteurs de Struts2;
 - les deux principalement utilisés sont : FilterDispatcher et StrutsPrepareAndExecuteFilter. Il est preferable d'utiliser 
 StrutsPrepareAndExecuteFilter si la version de Struts est supérieure à 2.1.3. 
~~~~  
 <filter>
    <filter-name>struts2</filter-name>
    <filter-class>
      org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter
    </filter-class>
  </filter>

  <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping> 
~~~~  

Le fichier contient aussi le contexte de Spring et le lsiterner (nécessaires pour le chargement des beans)   

~~~~
     <!--  contexte d'applications Spring à charger -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath*:META-INF/spring/applicationContext.xml</param-value>
	</context-param>
    <!-- Listener Spring de chargment de contexte-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  
~~~~

  TO BE CONTINUED .....   
      
       
