package model.jpa;

import javax.persistence.Query;

import model.dao.OwnerDAO;
import model.entities.Owner;

public class JPAOwnerDAO  extends JPAGenericDAO<Owner, Integer> implements OwnerDAO {
	
	public JPAOwnerDAO() {
		super(Owner.class);
	}

	@Override
	public Owner authorizeOwner(String email, String password) {
		Owner authorizedOwner = null;
		
		String sentence = "SELECT o FROM owner o WHERE o.email= :p1 AND o.password= :p2";
		Query query = em.createQuery(sentence);
		query.setParameter("p1", email);
		query.setParameter("p2", password);

		try {
			authorizedOwner = (Owner) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return authorizedOwner;	
	}

}
