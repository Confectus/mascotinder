package model.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.dao.OwnerDAO;
import model.entities.Owner;

public class JPAOwnerDAO  extends JPAGenericDAO<Owner, Integer> implements OwnerDAO{
	EntityManager e = Persistence.createEntityManagerFactory("mascotinder").createEntityManager();
	
	public JPAOwnerDAO() {
		super(Owner.class);
	}

	@Override
	public void authorizeOwner(String email, String password) {
		String sentenceJPQL = "SELECT o FROM Owner o WHERE o.email =:p1 AND o.password =:p2";
		Query query = e.createQuery(sentenceJPQL);
		query.setParameter("p1", email);
		query.setParameter("p2", password);
		Owner authorizedOwner = (Owner)query.getSingleResult();
		System.out.println(authorizedOwner);	
	}

}
