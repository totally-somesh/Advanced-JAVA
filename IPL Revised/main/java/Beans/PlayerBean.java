package Beans;

import java.time.LocalDate;

import DAO.PlayerDAOImpl;
import DAO.TeamDAOImpl;
import POJOs.Player;
import POJOs.Team;

//http://localhost:8080/web_maven_hibernate/process_form.jsp?
//myTeam=1&fn=MS+&fn=Dhoni&dob=1990-01-01&avg=50&wickets=40

public class PlayerBean {
	
	private  TeamDAOImpl TeamDAOInstance;
	private  PlayerDAOImpl PlayerDAOInstance;
	
	private int myTeam;
	private String fn;
	private String ln;
	private String dob;
	private String avg;
	private String wickets;
	private String email;
	
	private Player newPlayer;
	
public PlayerBean() {
	
	TeamDAOInstance = new TeamDAOImpl();
	PlayerDAOInstance = new PlayerDAOImpl();
	System.out.println(" ---< Player Bean Created >--- ");
}

public int getMyTeam() {
	return myTeam;
}



public void setMyTeam(int myTeam) {
	this.myTeam = myTeam;
}



public String getFn() {
	return fn;
}



public void setFn(String fn) {
	this.fn = fn;
}



public String getLn() {
	return ln;
}



public void setLn(String ln) {
	this.ln = ln;
}



public String getDob() {
	return dob;
}



public void setDob(String dob) {
	this.dob = dob;
}



public String getAvg() {
	return avg;
}



public void setAvg(String avg) {
	this.avg = avg;
}



public String getWickets() {
	return wickets;
}



public void setWickets(String wickets) {
	this.wickets = wickets;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public Player getNewPlayer() {
	return newPlayer;
}



public void setNewPlayer(Player newPlayer) {
	this.newPlayer = newPlayer;
}



public String validateAndAddNewPlayer() 
{System.out.println("Inside validate method of playerbean");
	LocalDate DOB1 = LocalDate.parse(dob);
	System.out.println(DOB1);
	double BATTINGAVG = Double.parseDouble(avg);
	System.out.println(BATTINGAVG);
	Team SELECTEDTEAM = TeamDAOInstance.getTeamDetails(myTeam);
	System.out.println(SELECTEDTEAM);
	String msg = " | Oops Boss ! New Player Insertion Failed Miserably ! ";
	
	newPlayer = new Player(email, fn, ln, DOB1, BATTINGAVG);
		System.out.println(newPlayer);
		PlayerDAOInstance.addNewPlayer(newPlayer, SELECTEDTEAM.getId());
		msg = " | Congratulations Boss ! New Player Added Succesfully ! ";
	
	
	return msg;
}


}
