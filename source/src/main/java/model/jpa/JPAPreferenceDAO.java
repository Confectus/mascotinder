package model.jpa;

import javax.persistence.Query;

import model.entities.Preference;
import model.dao.PreferenceDAO;

public class JPAPreferenceDAO extends JPAGenericDAO<Preference, Integer> implements PreferenceDAO {

	public JPAPreferenceDAO() {
		super(Preference.class);
	}

	

	@Override
	public Preference getPreferenceByPetId(int id) {
		Preference preference = null;
		String sentence = "SELECT p from Preference p WHERE p.pet.id= :param_id";
		Query query = this.em.createQuery(sentence);
		query.setParameter("param_id", id);
		try {
			preference = (Preference) query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return preference;
	}

	@Override
	public void setPreferenceByPetId(int id, Preference preference) {
		Preference oldPreference = getPreferenceByPetId(id);
		delete(oldPreference);
		create(preference);
		
	}

}
