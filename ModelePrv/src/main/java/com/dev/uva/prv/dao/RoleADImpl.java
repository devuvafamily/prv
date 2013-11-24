package com.dev.uva.prv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.uva.prv.entite.Role;

@Configurable
@Repository
public class RoleADImpl implements RoleAD {

	

	@PersistenceContext
    transient EntityManager entityManager;

	public final EntityManager entityManager() {
        return entityManager;
    }

	@Override
	public long countRoles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Role o", Long.class).getSingleResult();
    }

	@Override
	public List<Role> findAllRoles() {
        return entityManager().createQuery("SELECT o FROM Role o", Role.class).getResultList();
    }

	@Override
	public Role findRole(String codeRole) {
        if (codeRole == null || codeRole.length() == 0) return null;
        return entityManager().find(Role.class, codeRole);
    }

	@Override
	public List<Role> findRoleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Role o", Role.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
	@Transactional
    public void persist(Role role) {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(role);
    }

	@Override
	@Transactional
    public void remove(Role role) {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(role)) {
            this.entityManager.remove(role);
        } else {
            Role attached = this.findRole(role.getCodeRole());
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
    public Role merge(Role role) {
        if (this.entityManager == null) this.entityManager = entityManager();
        Role merged = this.entityManager.merge(role);
        this.entityManager.flush();
        return merged;
    }

}
