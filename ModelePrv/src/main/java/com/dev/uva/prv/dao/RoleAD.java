package com.dev.uva.prv.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.entite.Role;


public interface RoleAD {

	long countRoles();

	List<Role> findAllRoles();

	Role findRole(String codeRole);

	List<Role> findRoleEntries(int firstResult, int maxResults);

	@Transactional
	void persist(Role role);

	@Transactional
	void remove(Role role);

	@Transactional
	void flush();

	@Transactional
	void clear();

	@Transactional
	Role merge(Role role);

}