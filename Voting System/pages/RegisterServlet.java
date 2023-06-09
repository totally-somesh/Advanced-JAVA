package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Users;
import dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	Users NEWUSER;
	private UserDaoImpl userDAO;
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

	
		try(PrintWriter PW = response.getWriter()){
			
			String FNAME = request.getParameter("fnm");
			String LNAME = request.getParameter("lnm");
			String EMAIL = request.getParameter("em");
			String PASSWORD = request.getParameter("pass");
			Date DATE = Date.valueOf(request.getParameter("dt").toString());
			String ROLE = request.getParameter("rl");
			Boolean STATUS = false;

			
			NEWUSER = new Users(10,FNAME,LNAME,EMAIL,PASSWORD,DATE,STATUS,ROLE);

			if(NEWUSER!=null)
			{
				userDAO.registeredUser(NEWUSER);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
