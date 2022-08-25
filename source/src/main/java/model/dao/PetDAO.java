package model.dao;

import java.util.List;

import model.entities.Pet;

public interface PetDAO extends GenericDAO<Pet, Integer>{
	
	public List<Pet> getPetsByOwnerEmail(String ownerEmail);

	List<String> getTypes();
	
}
