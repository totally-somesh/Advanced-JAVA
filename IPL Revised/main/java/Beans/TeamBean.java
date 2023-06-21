package Beans;

import DAO.PlayerDAOImpl;
import DAO.TeamDAOImpl;
import POJOs.Team;

public class TeamBean {
	
	//tm abv avg ow wickets
	
	private TeamDAOImpl TeamDAOInstance;
	private PlayerDAOImpl PlayerDAOInstance;
	
	private String tm;
	private String abv;
	private double avg;
	private String ow;
	private int wickets;
	
	private Team newTeam;
	
	public TeamBean() {
		
		TeamDAOInstance = new TeamDAOImpl();
		PlayerDAOInstance = new PlayerDAOImpl();		
	}

	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getOw() {
		return ow;
	}

	public void setOw(String ow) {
		this.ow = ow;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	public String validateAndAddTeam() {
		
		String msg = " | Oops Boss ! New Team Insertion Failed Miserably ! ";
	
		//String tName, String abbrevation, String owner, double batting_Avg, int wickets) {
		
		// abv tm ow avg wickets
		Team newTeam = new Team(tm,abv,ow,avg,wickets);
		
		TeamDAOInstance.addNewTeam(newTeam);
		msg = " | Oops Congratulations ! New Team Added Succesfully ! ";
		
		return msg;
	}
	
	
	
	

}
