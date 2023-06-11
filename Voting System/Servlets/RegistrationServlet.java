package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CandidateDAOImpl;
import DAO.DAOImpl;
import POJO.Voter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	DAOImpl voterDAO1;
	
	public void init(ServletConfig config) throws ServletException {

		try {
			voterDAO1 = new DAOImpl();

		} catch (SQLException e) {

			e.printStackTrace();
		} // end of try-catch block
	}// end of init method

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter PW = response.getWriter()) {

			HttpSession RSession = request.getSession();

			//DAOImpl VoterDAOInst = (DAOImpl) RSession.getAttribute("voterDAO");

			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Date dob = Date.valueOf(request.getParameter("date"));
			String role = request.getParameter("role");

			Voter registeredVoter = voterDAO1.registerVoter(fname, lname, lname, password, dob, role);

			PW.print("<h3>" + registeredVoter + "</h3>");
			RSession.setAttribute("RVoter", registeredVoter);

			PW.print("<h3>Congratulations ! You've Registered Succesfully.</h3>");

			response.sendRedirect("login");

		} // end of try - with resource
		catch (SQLException e) {

			e.printStackTrace();
		}

	}// end of doPost method

	public void destroy() {

		try {
			voterDAO1.cleanUp();
		} catch (SQLException e) {

			e.printStackTrace();
		} // end of try-catch block
	}// end of destroy method

}
