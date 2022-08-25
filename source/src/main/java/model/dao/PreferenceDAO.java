package model.dao;

import model.entities.Preference;

public interface PreferenceDAO extends GenericDAO<Preference, Integer>
{
	public Preference getPreferenceByPetId(int id);
	public void setPreferenceByPetId(int id,Preference preference);
}
