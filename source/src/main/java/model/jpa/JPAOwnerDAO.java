package model.jpa;

import java.util.List;

import javax.persistence.Query;

import model.dao.OwnerDAO;
import model.entities.Owner;
import model.entities.Pet;

public class JPAOwnerDAO extends JPAGenericDAO<Owner, String> implements OwnerDAO {
	
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

	@Override
	public void addRejectedPet(String ownerEmail, Pet rejectedPet) {
		Owner rejectedOwner = read(ownerEmail);
		List<Pet> rejectedPets = rejectedOwner.getRejectedPets();
		
		rejectedPets.add(rejectedPet);
		rejectedOwner.setRejectedPets(rejectedPets);
		
		update(rejectedOwner);	
	}

}
