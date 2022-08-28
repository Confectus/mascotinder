package model.dao;

import java.util.List;

import model.entities.Match;

public interface MatchDAO extends GenericDAO<Match, Integer> {
	
	public List<Match> getMatchesByPetId(Integer petId);

}
