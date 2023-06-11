package DAO;

import java.sql.Date;
import java.sql.SQLException;

import POJO.Voter;

public interface DAOIF {
	
	Voter authenticateVoter(String email, String password) throws SQLException;
		
	String updateVotingStatus(int voterId) throws SQLException;
	
	Voter registerVoter(String fname, String lname, String email,
			String password, Date dob, String role) throws SQLException;
	
} //end of voterDAO interface
