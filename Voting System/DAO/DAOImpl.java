package DAO;

import static Utils.DBUtils.closeConnection;
import static Utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import POJO.Voter;

public class DAOImpl implements DAOIF {

	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public DAOImpl() throws SQLException {

		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2 = cn.prepareStatement("update users set status=1 where id=?");
		pst3 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");

		System.out.println(" -: Voter DAO Created Succesfully :- ");
	}

	// int id, String fname, String lname, String email, String password, Date dob,
	// boolean status,
	// String role

	@Override
	public Voter authenticateVoter(String email, String password) throws SQLException {

		pst1.setString(1, email);
		pst1.setString(2, password);

		try (ResultSet rst = pst1.executeQuery();) {

			if (rst.next()) {

				return new Voter(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			} else {
				return null;
			}
		} // end of try-with resources
	}// end of authenticateVoter method

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {

		pst2.setInt(1, voterId);

		int updatedRows = pst2.executeUpdate();

		if (updatedRows == 1) {

			return "Your Valuable Vote Has Been Counted !";
		} else
			return "Problem @ updateVotingStatus method ! ";
	}// end of updateVotingStatus method

	@Override
	public Voter registerVoter(String fname, String lname, String email, String password, Date dob, String role)
			throws SQLException {

		System.out.println("Inside RegisterVoter method ");
		
		pst3.setString(1, fname);
		pst3.setString(2, lname);
		pst3.setString(3, email);
		pst3.setString(4, password);
		pst3.setDate(5, dob);
		pst3.setBoolean(6, false);
		pst3.setString(7, role);

		LocalDate DOB = dob.toLocalDate();
		LocalDate TODAY = LocalDate.now();

		int Diff = Period.between(DOB, TODAY).getYears();

		if (Diff < 21) {

			System.out.println("Voter Rejected Due To Age Limit ! ");
			return null;

		} else {
			
			System.out.println("Inside Positive Phase Of Query ");
			int updatedRows = pst3.executeUpdate();

			if (updatedRows == 1) {
				return new Voter(fname, lname, email, password, dob, role);
			}
		}
		return null;

	}// end registerVoter method

	public void cleanUp() throws SQLException {

		if (pst1 != null && pst2 != null && pst3 != null) {
			pst1.close();
			pst2.close();
			pst3.close();

			closeConnection();
		}

		System.out.println(" -: VoterDAO Cleaned Up :- ");
	}// end of cleanUp method

}// end of class
