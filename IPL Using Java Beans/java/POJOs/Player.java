package POJOs;

public class Player {
	
	private int id;
	private String fname; 
	private String lname;
	private String dob;
	private double batting_avg;
	private int wickets_taken;
	private int team_id;
	
	public Player() {
		
	}

	public Player(int id, String fname, String lname, String dob, double batting_avg, int wickets_taken, int team_id) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
		this.team_id = team_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getBatting_avg() {
		return batting_avg;
	}

	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}

	public int getWickets_taken() {
		return wickets_taken;
	}

	public void setWickets_taken(int wickets_taken) {
		this.wickets_taken = wickets_taken;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	@Override
	public String toString() {
		return "Player ID : " + id + " | FName : " + fname + "| LName : " + lname + "| Dob=" + dob + ", batting_avg="
				+ batting_avg + "| Wickets_taken=" + wickets_taken + " | Team_id=" + team_id;
	}
	

}
