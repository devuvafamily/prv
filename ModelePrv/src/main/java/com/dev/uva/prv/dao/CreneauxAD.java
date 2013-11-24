package com.dev.uva.prv.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.entite.Creneaux;


public interface CreneauxAD {

	long countCreneauxes();

	List<Creneaux> findAllCreneauxes();

	Creneaux findCreneaux(Integer idCreneaux);

	List<Creneaux> findCreneauxEntries(int firstResult, int maxResults);

	@Transactional
	void persist(Creneaux creneaux);

	@Transactional
	void remove(Creneaux creneaux);

	@Transactional
	void flush();

	@Transactional
	void clear();

	@Transactional
	Creneaux merge(Creneaux creneaux);

}