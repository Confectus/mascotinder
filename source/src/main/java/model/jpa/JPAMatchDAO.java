package model.jpa;

import java.util.List;

import javax.persistence.Query;

import model.dao.MatchDAO;
import model.entities.Match;
import model.entities.Pet;

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

	@Override
	public void processLikeBetweenPets(Pet requester, Pet applicant) {
		Match match = getMatchBetweenPets(requester.getId(), applicant.getId());
		
		if (match == null) {
			match = new Match(false, requester, applicant);
		}
		else {
			match.setConfirmation(true);
		}
	}

	@Override
	public Match getMatchBetweenPets(Integer requesterId, Integer applicantId) {
		Match match = null;
		
		String sentence = "SELECT m FROM petmatch m WHERE (m.applicant= :applicant_id AND m.requester= :requester_id) OR (m.applicant= :requester_id AND m.requester= :applicant_id)";		
		Query query = this.em.createQuery(sentence);
		query.setParameter("requester_id", requesterId);
		query.setParameter("applicant_id", applicantId);
		
		try {
			match = (Match) query.getSingleResult();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return match;
	}

}
