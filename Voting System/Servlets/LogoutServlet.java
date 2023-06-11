package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CandidateDAOImpl;
import DAO.DAOImpl;
import POJO.Voter;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logoutPage")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter PW = response.getWriter()) {

			HttpSession LSession = request.getSession();

			Voter newVoter = (Voter) LSession.getAttribute("newVoterDetails");
			DAOImpl DAOInst = (DAOImpl) LSession.getAttribute("voterDAO");
			CandidateDAOImpl CandidateDAOInst = (CandidateDAOImpl) LSession.getAttribute("CandiDAO");

			String updatedStatus = "123";
			String incrementedVoteStatus = "456";

			int candidateId = Integer.parseInt(request.getParameter("crbtn"));

//			PW.print("<h2>" + candidateId + "</h2>");
//			PW.print("<h2>" + newVoter + "</h2>");

			if(!newVoter.isStatus()) {
			updatedStatus = DAOInst.updateVotingStatus(newVoter.getId());
			incrementedVoteStatus = CandidateDAOInst.incrementCandidateVote(candidateId);
			}
			
			PW.print("<h2>"+updatedStatus+"</h2>");
			PW.print("<h2>"+incrementedVoteStatus+"</h2>");

		} // end of try - with resource
		catch (Exception e) {

			throw new ServletException("Problem At Logout Servlet ! ", e);
		}
	}// end of doGet method

}// end of LogOut Servlet
