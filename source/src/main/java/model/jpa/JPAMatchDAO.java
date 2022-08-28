package model.jpa;

import java.util.List;

import javax.persistence.Query;

import model.dao.MatchDAO;
import model.entities.Match;

public class JPAMatchDAO extends JPAGenericDAO<Match, Integer> implements MatchDAO {

	public JPAMatchDAO() {
		super(Match.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Match> getMatchesByPetId(Integer petId) {
		List<Match> matches = null;
		
		String sentence = "SELECT m from Match m WHERE (m.requester.id= :param_pet_id AND m.applicant IS NOT NULL) OR (m.applicant.id= :param_pet_id AND m.requester IS NOT NULL)";
		Query query = this.em.createQuery(sentence);
		query.setParameter("param_pet_id", petId);
		
		try {
			matches = (List<Match>) query.getResultList();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return matches;
	}

}
