package model.jpa;

import java.util.List;

import javax.persistence.Query;

import model.dao.PetDAO;
import model.entities.Pet;
import model.entities.Preference;

public class JPAPetDAO extends JPAGenericDAO<Pet, Integer> implements PetDAO {

	public JPAPetDAO() {
		super(Pet.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> getPetsByOwnerEmail(String ownerEmail) {
		List<Pet> pets = null;
		
		String sentence = "SELECT p from Pet p WHERE p.owner.email= :param_email";
		Query query = this.em.createQuery(sentence);
		query.setParameter("param_email", ownerEmail);
		
		try {
			pets = (List<Pet>) query.getResultList();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return pets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTypes() {
		List<String> types = null;
		
		String sentence = "SELECT distinct p.type from Pet p";
		Query query = this.em.createQuery(sentence);
		
		try {
			types = (List<String>) query.getResultList();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
		return types;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> getPetsByPreference(Preference preference) {
		List<Pet> pets = null;
		
		String sentence = "SELECT p from Pet p WHERE p.age<= :p.maximumAge AND p.age>= :p.minimumAge AND p.sex= :param_preference.sex AND p.type= :param_preference.type";
		Query query = this.em.createQuery(sentence);
		query.setParameter("param_preference", preference);
		
		try {
			pets = (List<Pet>) query.getResultList();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return pets;
	}

}
