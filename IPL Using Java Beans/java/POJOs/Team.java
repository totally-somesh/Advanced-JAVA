package POJOs;

/*
 * id , name, abbreviation,owner,max_age,batting_avg,wickets_taken	
# table
 */
public class Team {
	private int teamId;
	private String name;
	private String abbreviation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;
	
	public Team() {
		
	}
	
	
	public Team(int teamId, String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}


	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getMinBattingAvg() {
		return minBattingAvg;
	}
	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}
	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}
	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	
	
	@Override
	public String toString() {
		return "<h1>TeamId=" + teamId +" | Name=" + name + "| Abbreviation=" + abbreviation + "| Owner=" + owner
				+ " | MaxAge=" + maxAge + "| MinBattingAvg=" + minBattingAvg + "| MinWicketsTaken=" + minWicketsTaken
				+ "</h1><br><br>";
	}	
}
