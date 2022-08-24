package model.dao;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory;
	
	public static DAOFactory getFactory () {
		return factory;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	
}
