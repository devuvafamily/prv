package com.dev.uva.prv.modele.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.modele.entite.Rendezvous;

@Configurable
@Repository
public class RendezvousADImpl implements RendezvousAD {

	
    @PersistenceContext
    private transient EntityManager entityManager;

    public final EntityManager entityManager() {
        return entityManager;
    }

    @Override
	public long countRendezvouses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Rendezvous o", Long.class).getSingleResult();
    }

    @Override
	public List<Rendezvous> findAllRendezvouses() {
        return entityManager().createQuery("SELECT o FROM Rendezvous o", Rendezvous.class).getResultList();
    }

    @Override
	public Rendezvous findRendezvous(Integer idRv) {
        if (idRv == null) {
        	return null;
        }
        return entityManager().find(Rendezvous.class, idRv);
    }

    @Override
	public List<Rendezvous> findRendezvousEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Rendezvous o", Rendezvous.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
	@Transactional
    public void persist(Rendezvous rendezvous) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        this.entityManager.persist(rendezvous);
    }

    @Override
	@Transactional
    public void remove(Rendezvous rendezvous) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        if (this.entityManager.contains(rendezvous)) {
            this.entityManager.remove(rendezvous);
        } else {
            Rendezvous attached = this.findRendezvous(rendezvous.getIdRv());
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
    public Rendezvous merge(Rendezvous rendezvous) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        Rendezvous merged = this.entityManager.merge(rendezvous);
        this.entityManager.flush();
        return merged;
    }

}
