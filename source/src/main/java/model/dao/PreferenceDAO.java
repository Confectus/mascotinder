package model.dao;

import model.entities.Preference;

public interface PreferenceDAO extends GenericDAO<Preference, Integer> {
	
	public Preference getPreferenceByPetId(Integer id);
	
	public void setPreferenceByPetId(Integer id, Preference preference);
	
}
