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
	public void create(Pet instancia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Pet instancia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Pet instancia) {
		// TODO Auto-generated method stub

	}
	
	/*
	Check this part!!
	@Override
	public Pet getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet autorizar(String usuario, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> getAll() {
		// TODO Auto-generated method stub
		return null;
	}*/


}

