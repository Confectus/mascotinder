package model.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.dao.PetDAO;
import model.entities.Match;
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
		
		String sentence = "SELECT p FROM pet p WHERE p.owner.email= :email";
		Query query = this.em.createQuery(sentence);
		query.setParameter("email", ownerEmail);
		
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
		
		String sentence = "SELECT DISTINCT p.type FROM pet p";
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
		/*Get the email of the owner for not show their pets*/
		String emailOwner = preference.getPet().getOwner().getEmail();	
		String sentence = "SELECT p FROM pet p WHERE p.owner <>: pet_owner AND p.type= :pref_type AND p.sex= :pref_sex AND p.age BETWEEN :pref_minimum_age AND :pref_maximum_age"; 
		Query query = this.em.createQuery(sentence);
		query.setParameter("pref_type", preference.getType());
		query.setParameter("pref_sex", preference.getSex());
		query.setParameter("pref_minimum_age", preference.getMinimumAge());
		query.setParameter("pref_maximum_age", preference.getMaximumAge());
		query.setParameter("pet_owner", emailOwner);
		try {
			pets = (List<Pet>) query.getResultList();			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return pets;
	}

	@Override
	public List<Pet> getPetsFromConfirmedMatches(Integer id, List<Match> matches) {
		List<Pet> pets = new ArrayList<>();
		List<Integer> petsIds = new ArrayList<>();
		
		for (Match match : matches) {
			if (match.getRequester().getId() == id) {
				petsIds.add(match.getApplicant().getId());
			}
			else {
				petsIds.add(match.getRequester().getId());
			}
		}
		
		for (Integer petId : petsIds) {
			String sentence = "SELECT p FROM pet p WHERE p.id= :pet_id";
			Query query = this.em.createQuery(sentence);
			query.setParameter("pet_id", petId);
			
			try {
				pets.add((Pet) query.getSingleResult());			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pets;
	}


}
