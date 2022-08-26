package model.dao;

import model.entities.PetImage;

public interface PetImageDAO extends GenericDAO<PetImage, Integer>{
	
	public PetImage getFirstPetImage(Integer petId);
	
}
