package model.jpa;

import java.util.List;

import model.dao.PetDAO;
import model.entities.Pet;

public class JPAPetDAO extends JPAGenericDAO<Pet, Integer> implements PetDAO {

	public JPAPetDAO() {
		super(Pet.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pet> getPetsByOwnerEmail(String ownerEmail) {
		
		return null;
	}


}

