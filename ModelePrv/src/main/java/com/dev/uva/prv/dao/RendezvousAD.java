package com.dev.uva.prv.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.entite.Rendezvous;


public interface RendezvousAD {

	long countRendezvouses();

	List<Rendezvous> findAllRendezvouses();

	Rendezvous findRendezvous(Integer idRv);

	List<Rendezvous> findRendezvousEntries(int firstResult, int maxResults);

	@Transactional
	void persist(Rendezvous rendezvous);

	@Transactional
	void remove(Rendezvous rendezvous);

	@Transactional
	void flush();

	@Transactional
	void clear();

	@Transactional
	Rendezvous merge(Rendezvous rendezvous);

}