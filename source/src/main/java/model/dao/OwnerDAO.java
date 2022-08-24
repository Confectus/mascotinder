package model.dao;

public interface OwnerDAO extends GenericDAO<Owner, Integer> {
	
	public Owner authorizeOwner(String email, String password);

}
