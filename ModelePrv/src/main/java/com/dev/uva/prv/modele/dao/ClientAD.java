package com.dev.uva.prv.modele.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.modele.entite.Client;


public interface ClientAD {

	long countClients();

	List<Client> findAllClients();

	Client findClient(String codeClient);

	List<Client> findClientEntries(int firstResult, int maxResults);

	@Transactional
	void persist(Client client);

	@Transactional
	void remove(Client client);

	@Transactional
	void flush();

	@Transactional
	void clear();

	@Transactional
	Client merge(Client client);

}