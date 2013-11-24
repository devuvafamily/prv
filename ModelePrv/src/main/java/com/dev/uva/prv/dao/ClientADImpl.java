package com.dev.uva.prv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.entite.Client;

@Configurable
@Repository
public class ClientADImpl implements ClientAD {

	
    @PersistenceContext
    EntityManager entityManager;

    public final EntityManager entityManager() {
        return entityManager;
    }

    @Override
	public long countClients() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Client o", Long.class).getSingleResult();
    }

    @Override
	public List<Client> findAllClients() {
        return entityManager().createQuery("SELECT o FROM Client o", Client.class).getResultList();
    }

    @Override
	public Client findClient(String codeClient) {
        if (codeClient == null || codeClient.length() == 0) return null;
        return entityManager().find(Client.class, codeClient);
    }

    @Override
	public List<Client> findClientEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Client o", Client.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
	@Transactional
    public void persist(Client client) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(client);
    }

    @Override
	@Transactional
    public void remove(Client client) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(client)) {
            this.entityManager.remove(client);
        } else {
            Client attached = this.findClient(client.getCodeClient());
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
    public Client merge(Client client) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Client merged = this.entityManager.merge(client);
        this.entityManager.flush();
        return merged;
    }

}
