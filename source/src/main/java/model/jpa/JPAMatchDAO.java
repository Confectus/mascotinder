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
	public List<Match> getMatchesByPetId(Integer id) {
		List<Match> matches = null;
		
		String sentence = "SELECT m FROM petmatch m WHERE m.confirmation= :confirmation AND (m.requester.id= :pet_id OR m.applicant.id= :pet_id)";
		Query query = this.em.createQuery(sentence);
		query.setParameter("pet_id", id);
		query.setParameter("confirmation", true);
		
		try {
			matches = (List<Match>) query.getResultList();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return matches;
	}

}
