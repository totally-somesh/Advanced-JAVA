package POJOs;

import java.time.LocalDate;
import javax.persistence.*;

@Entity 
@Table(name="Players")
public class Player extends BaseEntity {
	
	@Column(name="EmailID")
	private String email;
	
	@Column(name="F_Name")
	private String fName;
	
	@Column(name="L_Name")
	private String LName;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	@Column(name="Batting_Avg")
	private double battingAvg;
	
	
	@ManyToOne
	@JoinColumn(name = "My_Team", nullable = false)
	private Team myTeam;
	
	
	public Player() {
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getLName() {
		return LName;
	}


	public void setLName(String lName) {
		LName = lName;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public double getBattingAvg() {
		return battingAvg;
	}


	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}


	@Override
	public String toString() {
		return " | Email : " + email + " | FName : " + fName + " | LName : " + LName + " | DOB : " + dob + " | BattingAvg : "
				+ battingAvg + " | ";
	}


	public Team getMyTeam() {
		return myTeam;
	}


	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}


	public Player(String email, String fName, String lName, LocalDate dob, double battingAvg) {
		super();
		this.email = email;
		this.fName = fName;
		LName = lName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		
	}


	


	
	
	
	

}
