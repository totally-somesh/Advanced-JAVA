package DAO;

import java.util.List;

import POJOs.Team;

public interface TeamDAOIF {
	
	public String addNewTeam(Team newTeam);
	
	public List<Team> getAllTeams();
	
	public Team getTeamDetails(int teamId);

}
