package model.dao;

import model.entities.Owner;

public interface OwnerDAO extends GenericDAO<Owner, Integer> {
	
	public void authorizeOwner(String email, String password);

}
