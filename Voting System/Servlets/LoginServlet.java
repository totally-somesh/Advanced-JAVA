package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	DAOImpl voterDAO;
	CandidateDAOImpl CandidateDAO;

	public void init(ServletConfig config) throws ServletException {

		try {
			voterDAO = new DAOImpl();
			CandidateDAO = new CandidateDAOImpl();
		} catch (SQLException e) {

			e.printStackTrace();
		} // end of try-catch block
	}// end of init method

	public void destroy() {
		
		try {
			voterDAO.cleanUp();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}// end of try-catch block
	}// end of destroy method

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter PW = response.getWriter()){
			
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			
			Voter newVoter = voterDAO.authenticateVoter(email, password);
			
			if(newVoter == null) {
				
				PW.print("<h1>Invalid Email Or Password ! Please : <a href='login.html'>Retry</a></h1>");
							
			}else {
				
				
				HttpSession HS = request.getSession();
				HS.setAttribute("newVoterDetails", newVoter);
				HS.setAttribute("CandiDAO", CandidateDAO);
				HS.setAttribute("voterDAO", voterDAO);
		
				if(newVoter.getRole().equals("admin")) {
					
					response.sendRedirect("adminPage");
				}
				else {
					
					if(newVoter.isStatus() == true) {
						
						response.sendRedirect("logoutPage");						
					}else {
						
						response.sendRedirect("candidatePage");
					}
				}
			}
			
		}//end of try-with resource
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end of doGet method
}//end of Login Servlet
