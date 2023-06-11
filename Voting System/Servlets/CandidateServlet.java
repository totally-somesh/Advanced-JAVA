package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CandidateDAOImpl;
import POJO.Candidate;

/**
 * Servlet implementation class CandidateServlet
 */
@WebServlet("/candidatePage")
public class CandidateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter PW = response.getWriter()){
			
			HttpSession CSession = request.getSession();
			
			CandidateDAOImpl CDAOInstance = (CandidateDAOImpl)CSession.getAttribute("CandiDAO");
			
			List<Candidate> allCandidates = CDAOInstance.getAllCandidates();
			
			PW.print("<form  action='logoutPage'>");
			for(Candidate C : allCandidates) {
				
				PW.print("<h3><input type='radio' name='crbtn' value='" +C.getId()+ "'/>"+C.getName()+"</h3>");
				PW.print("<h3><input type='submit' value='Cast A Vote'/></h3>");
				PW.print("</form>");
				
			}//end of forEach Loop		
			
		}//end of try - with resource
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of doGet method

}//end of Candidate Servlet
