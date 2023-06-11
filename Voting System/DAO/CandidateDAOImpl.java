package DAO;

import static Utils.DBUtils.closeConnection;
import static Utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Candidate;

public class CandidateDAOImpl implements CandidateDAOIF{

	private Connection cn;
	private PreparedStatement pst1, pst2;
	
	public CandidateDAOImpl() throws SQLException {
		
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		
		System.out.println(" -: Candidate DAO Created Succesfully :- ");		
	}//end of Constructor
		
	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		
		List<Candidate> allCandidateList = new ArrayList<>();
		
		try(ResultSet rst = pst1.executeQuery();){
			
			while(rst.next()) {
				
				allCandidateList.add(new Candidate(rst.getInt(1),rst.getString(2),
						rst.getString(3),rst.getInt(4)));
			}				
		}//end of try - with resource
				
		return allCandidateList;
	}//end of getAllCandidates method
	
	
	@Override
	public String incrementCandidateVote(int candidateId) throws SQLException {
		
		pst2.setInt(1, candidateId);
		
		int updatedRows = pst2.executeUpdate();
		
		if(updatedRows == 1) {
			
			return "Vote Is Added ! ";
		}
		else
			return "Problem @ incrementCandidateVote method ! ";
	}//end of incrementCandVotes method
	
	
	public void cleanUp() throws SQLException {
		
		if(pst1 != null && pst2 != null) {
			
			pst1.close();
			pst2.close();
			closeConnection();
		}
		
	}//end of cleanUp method

	

}//end of CandidateDAOImpl
