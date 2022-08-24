package model.dao;

import model.entities.Owner;

public interface OwnerDAO extends GenericDAO<Owner, Integer> {
	
	public Owner authorizeOwner(String email, String password);

}
