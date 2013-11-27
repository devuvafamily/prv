package com.dev.uva.prv.modele.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.modele.entite.Employe;

@Configurable
@Repository
public class EmployeADImpl implements EmployeAD {

	 @PersistenceContext
	    EntityManager entityManager;

	    public  final EntityManager entityManager() {
	        return entityManager;
	    }

	    @Override
		public long countEmployes() {
	        return entityManager().createQuery("SELECT COUNT(o) FROM Employe o", Long.class).getSingleResult();
	    }

	    @Override
		public List<Employe> findAllEmployes() {
	        return entityManager().createQuery("SELECT o FROM Employe o", Employe.class).getResultList();
	    }

	    @Override
		public Employe findEmploye(String codeUtilisateur) {
	        if (codeUtilisateur == null || codeUtilisateur.length() == 0) return null;
	        return entityManager().find(Employe.class, codeUtilisateur);
	    }

	    @Override
		public List<Employe> findEmployeEntries(int firstResult, int maxResults) {
	        return entityManager().createQuery("SELECT o FROM Employe o", Employe.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	    }

	    @Override
		@Transactional
	    public void persist(Employe employe) {
	        if (this.entityManager == null) this.entityManager = entityManager();
	        this.entityManager.persist(employe);
	    }

	    @Override
		@Transactional
	    public void remove(Employe employe) {
	        if (this.entityManager == null) this.entityManager = entityManager();
	        if (this.entityManager.contains(employe)) {
	            this.entityManager.remove(employe);
	        } else {
	            Employe attached = this.findEmploye(employe.getCodeUtilisateur());
	            this.entityManager.remove(attached);
	        }
	    }

	    @Override
		@Transactional
	    public void flush() {
	        if (this.entityManager == null) this.entityManager = entityManager();
	        this.entityManager.flush();
	    }

	    @Override
		@Transactional
	    public void clear() {
	        if (this.entityManager == null) this.entityManager = entityManager();
	        this.entityManager.clear();
	    }

	    @Override
		@Transactional
	    public Employe merge(Employe employe) {
	        if (this.entityManager == null) this.entityManager = entityManager();
	        Employe merged = this.entityManager.merge(employe);
	        this.entityManager.flush();
	        return merged;
	    }


}
