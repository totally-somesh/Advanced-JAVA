package Beans;

import java.util.List;

import DAO.TeamDAOImpl;
import POJOs.Team;

public class IPLBean {
	
	private TeamDAOImpl TeamDAOInstance;
	
	public IPLBean() {
		
		TeamDAOInstance = new TeamDAOImpl();
		
		System.out.println(" ---< IPL Bean Created >--- ");
	}

	public TeamDAOImpl getTeamDAOInstance() {
		return TeamDAOInstance;
	}

	public void setTeamDAOInstance(TeamDAOImpl teamDAOInstance) {
		TeamDAOInstance = teamDAOInstance;
	}
	
	public List<Team> fetchAllTeams(){
		
		return TeamDAOInstance.getAllTeams();
	}
}
