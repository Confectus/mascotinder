package model.jpa;

import java.util.List;

import javax.persistence.Query;

import model.dao.PetDAO;
import model.entities.Pet;

public class JPAPetDAO extends JPAGenericDAO<Pet, Integer> implements PetDAO {

	public JPAPetDAO() {
		super(Pet.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> getPetsByOwnerEmail(String ownerEmail) {
		List<Pet> pets = null;
		String sentenceJPQL = "SELECT p from pet p WHERE p.ownerEmail = :param_owner_email";
		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("param_owner_email", ownerEmail);
		
		try {
			pets = query.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pets;
	}

}
