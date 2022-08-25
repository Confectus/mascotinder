package model.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.dao.GenericDAO;

public class JPAGenericDAO<T,ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistenceClass;
	
	EntityManager em;
	
	public JPAGenericDAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
		em = Persistence.createEntityManagerFactory("mascotinder").createEntityManager();
	}

	
	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
	
	@Override
	public T read(ID id) {
		return em.find(persistenceClass, id);
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}


	



}
