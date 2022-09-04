package model.dao;

import model.entities.Pet;
import model.entities.PetImage;

public interface PetImageDAO extends GenericDAO<PetImage, Integer> {

	public PetImage getFirstPetImage(Integer id);

	public void createImagesNewPet(String image1, String image2, String image3, Pet newPet);

}
