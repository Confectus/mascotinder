package model.dao;

import model.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory () {
		return factory;
	}
	
	public abstract PetDAO getPetDAO();	
	public abstract OwnerDAO getOwnerDAO();
	
}
