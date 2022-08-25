package model.jpa;

import model.dao.DAOFactory;
import model.dao.OwnerDAO;
import model.dao.PetDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public PetDAO getPetDAO() {
		return new JPAPetDAO();
	}


}

