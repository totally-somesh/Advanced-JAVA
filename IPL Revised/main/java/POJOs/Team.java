package POJOs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Teams")
public class Team extends BaseEntity {

//String name, String abbrevation, String owner, int maxAge, double battingAvg, int wicketsTaken
	
	@Column(name="Team_Name")
	private String tName;
	
	@Column(name="Abbrevation")
	private String abbrevation;
	
	@Column(name="Team_Owner")
	private String owner;
	
	@Column(name="Batting_Avg")
	private double batting_Avg;
	
	@Column(name="Wickets")
	private int wickets;
	
	@OneToMany(mappedBy= "myTeam", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Player> playerList = new ArrayList<>();
	
	
	public Team() {
		
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBatting_Avg() {
		return batting_Avg;
	}

	public void setBatting_Avg(double batting_Avg) {
		this.batting_Avg = batting_Avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "TeamName : " + tName + " | Abbrevation : " + abbrevation + " | Owner : " + owner + " | Batting_Avg :  "
				+ batting_Avg + " | Wickets : " + wickets + " | ";
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public Team(String tName, String abbrevation, String owner, double batting_Avg, int wickets) {
		super();
		this.tName = tName;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.batting_Avg = batting_Avg;
		this.wickets = wickets;
	}

	public Team(int Id, String abbrevation) {
		super.setId(Id);
		this.abbrevation = abbrevation;
	}
	
	public void addNewPlayer(Player newPlayer) {
		
		playerList.add(newPlayer);
		newPlayer.setMyTeam(this);		
	}
	
	
	
	
	
	
	
	
}
