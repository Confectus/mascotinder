package model.jpa;

import model.dao.DAOFactory;
import model.dao.OwnerDAO;
import model.dao.PetDAO;
import model.dao.PetImageDAO;
import model.dao.PreferenceDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public PetDAO getPetDAO() {
		return new JPAPetDAO();
	}

	@Override
	public OwnerDAO getOwnerDAO() {
		return new JPAOwnerDAO();
	}

	@Override
	public PreferenceDAO getPreferenceDAO() {
		return new JPAPreferenceDAO();
	}

	@Override
	public PetImageDAO getPetImageDAO() {
		return new JPAPetImageDAO();
	}

}

