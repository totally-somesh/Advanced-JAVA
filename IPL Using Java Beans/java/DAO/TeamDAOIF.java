package DAO;

import java.sql.SQLException;
import java.util.List;

import POJOs.Team;

public interface TeamDAOIF {
	
	List<Team> getAllTeams() throws SQLException;

}// end of interface
