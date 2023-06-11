package DAO;

import java.sql.SQLException;
import java.util.List;

import POJO.Candidate;

public interface CandidateDAOIF {
	
	List<Candidate> getAllCandidates() throws SQLException;
	
	String incrementCandidateVote(int candidateId) throws SQLException;
	
}
