package model.dao;

import java.util.List;

import model.entities.Pet;
import model.entities.Preference;

public interface PetDAO extends GenericDAO<Pet, Integer> {
	
	public List<Pet> getPetsByOwnerEmail(String ownerEmail);

	public List<String> getTypes();
	
	public List<Pet> getPetsByPreference(Preference preference);
	
}
