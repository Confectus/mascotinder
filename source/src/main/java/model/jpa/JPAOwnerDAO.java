package model.jpa;

import java.util.List;

import model.dao.OwnerDAO;
import model.entities.Owner;

public class JPAOwnerDAO extends JPAGenericDAO<Owner, Integer> implements OwnerDAO {

	public JPAOwnerDAO() {
		super(Owner.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Owner authorizeOwner(String email, String password) {
		// TODO Auto-generated method stub
		return new Owner(1,"Giancarlo","giancarlo.naranjo@epn.edu.ec","giancarlo123");
	}
	
	/*Implement this method
	@Override
	public List<Owner> getAll() {
		return null;
	}*/

	

}

