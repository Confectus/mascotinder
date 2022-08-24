package model.jpa;

import java.util.List;

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
	public void create(T instancia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T instancia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T instancia) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T getByID(ID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> get() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> get(String[] attributes, String[] values) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> get(String[] attributes, String[] values, String order, int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteByID(ID id) {
		// TODO Auto-generated method stub
		
	}


}
