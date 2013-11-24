package com.dev.uva.prv.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.entite.Employe;


public interface EmployeAD {

	long countEmployes();

	List<Employe> findAllEmployes();

	Employe findEmploye(String codeUtilisateur);

	List<Employe> findEmployeEntries(int firstResult, int maxResults);

	@Transactional
	void persist(Employe employe);

	@Transactional
	void remove(Employe employe);

	@Transactional
	void flush();

	@Transactional
	void clear();

	@Transactional
	Employe merge(Employe employe);

}