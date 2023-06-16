package Beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.TeamDAOImpl;
import POJOs.Team;

public class TeamBean {
	
	private TeamDAOImpl teamDAOInstance;
	
	public TeamBean() throws SQLException {
		
		teamDAOInstance = new TeamDAOImpl();		
	}//end of default constructor

	public TeamDAOImpl getTeamDAOInstance() {
		return teamDAOInstance;
	}

	public void setTeamDAOInstance(TeamDAOImpl teamDAOInstance) {
		this.teamDAOInstance = teamDAOInstance;
	}
	
	public List<Team> getWrapperMethod() throws SQLException{
			
		List<Team> allTeams = teamDAOInstance.getAllTeams();
		
		return allTeams;		
	}// end of wrapperMethod	
	
}// end of TeamBean
