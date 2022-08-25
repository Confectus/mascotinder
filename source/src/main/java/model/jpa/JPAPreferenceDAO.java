package model.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Preference;
import model.dao.PreferenceDAO;
import model.entities.Owner;
import model.entities.Pet;

public class JPAPreferenceDAO extends JPAGenericDAO<Preference, Integer> implements PreferenceDAO {

	public JPAPreferenceDAO(Class<Preference> persistenceClass) {
		super(persistenceClass);
		// TODO Auto-generated constructor stub
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
