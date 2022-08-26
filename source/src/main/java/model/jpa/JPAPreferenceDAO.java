package model.jpa;

import javax.persistence.Query;

import model.entities.Pet;
import model.entities.Preference;
import model.dao.DAOFactory;
import model.dao.PreferenceDAO;

public class JPAPreferenceDAO extends JPAGenericDAO<Preference, Integer> implements PreferenceDAO {

	public JPAPreferenceDAO() {
		super(Preference.class);
	}	

	@Override
	public Preference getPreferenceByPetId(Integer id) {
		Preference preference = null;
		
		String sentence = "SELECT p from Preference p WHERE p.pet.id= :param_id";
		Query query = this.em.createQuery(sentence);
		query.setParameter("param_id", id);
		
		try {
			preference = (Preference) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return preference;
	}

	@Override
	public void setPreferenceByPetId(Integer id, Preference preference) {
		Preference oldPreference = getPreferenceByPetId(id);
		delete(oldPreference);
		create(preference);
		
		Preference currentPreference = getPreferenceByPetId(id);
		
		if (currentPreference != null) {
			currentPreference.setType(preference.getType());
			currentPreference.setSex(preference.getSex());
			currentPreference.setMinimumAge(preference.getMinimumAge());
			currentPreference.setMaximumAge(preference.getMaximumAge());
			
			update(currentPreference);
		}
		else {
			Pet pet = DAOFactory.getFactory().getPetDAO().read(id);
			Preference newPreference = new Preference(0, preference.getType(), preference.getSex(), preference.getMinimumAge(), preference.getMaximumAge(), pet);			
			
			create(newPreference);
		}	
	}

}
