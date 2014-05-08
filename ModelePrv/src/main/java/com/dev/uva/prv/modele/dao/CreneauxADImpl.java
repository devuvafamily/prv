package com.dev.uva.prv.modele.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.modele.entite.Creneaux;

@Configurable
@Repository
public class CreneauxADImpl implements CreneauxAD {

	
    @PersistenceContext
    private transient EntityManager entityManager;

    public final EntityManager entityManager() {
        return entityManager;
    }

    @Override
	public long countCreneauxes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Creneaux o", Long.class).getSingleResult();
    }

    @Override
	public List<Creneaux> findAllCreneauxes() {
        return entityManager().createQuery("SELECT o FROM Creneaux o", Creneaux.class).getResultList();
    }

    @Override
	public Creneaux findCreneaux(Integer idCreneaux) {
        if (idCreneaux == null) {
        	return null;
        }
        return entityManager().find(Creneaux.class, idCreneaux);
    }

    @Override
	public List<Creneaux> findCreneauxEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Creneaux o", Creneaux.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
	@Transactional
    public void persist(Creneaux creneaux) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        this.entityManager.persist(creneaux);
    }

    @Override
	@Transactional
    public void remove(Creneaux creneaux) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        if (this.entityManager.contains(creneaux)) {
            this.entityManager.remove(creneaux);
        } else {
            Creneaux attached = this.findCreneaux(creneaux.getIdCreneaux());
            this.entityManager.remove(attached);
        }
    }

    @Override
	@Transactional
    public void flush() {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        this.entityManager.flush();
    }

    @Override
	@Transactional
    public void clear() {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        this.entityManager.clear();
    }

    @Override
	@Transactional
    public Creneaux merge(Creneaux creneaux) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        Creneaux merged = this.entityManager.merge(creneaux);
        this.entityManager.flush();
        return merged;
    }

}
