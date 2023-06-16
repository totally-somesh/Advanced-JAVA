package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJOs.Team;

import static DBUtils.DBUtilities.openConnection;
import static DBUtils.DBUtilities.closeConnection;

public class TeamDAOImpl implements TeamDAOIF {

	private Connection cn;
	private PreparedStatement pst1;

	public TeamDAOImpl() throws SQLException {

		cn = openConnection();
		pst1 = cn.prepareStatement("select * from teams");
	}

	@Override
	public List<Team> getAllTeams() throws SQLException {

		List<Team> TeamList = new ArrayList<>();

		// int teamId, String name, String abbreviation, String owner, int maxAge,
		// double minBattingAvg,
		// int minWicketsTaken

		try (ResultSet RST = pst1.executeQuery();) {

			while (RST.next()) {

				TeamList.add(new Team(RST.getInt(1), RST.getString(2), RST.getString(3), RST.getString(4),
						RST.getInt(5), RST.getDouble(6), RST.getInt(7)));
				

			} // end of while

		} // end of try with resources

		return TeamList;
	}// end of getAllTeams method

	public void cleanUp() throws SQLException {
		
		if(pst1 != null) {
			
			pst1.close();
			closeConnection();
		}//end of if

	}// end of cleanUp method

}// end of TeamDAOImpl Class
