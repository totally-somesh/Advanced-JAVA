package Basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		try(PrintWriter PW = resp.getWriter()){
			
		LocalDateTime today = LocalDateTime.now();
			
		PW.print("<h3> Today Its : " +today.getDayOfWeek() +"/"+today.getMonth()+"/"+today.getYear());
		PW.print("<h3> We're In Pune City, Situated In Maharashtra State Of India.</h3>");
		
		}		
	}

	@Override
	public void destroy() {
	
		System.out.println(" | Destroying Phase..." + " | Executed By : " + Thread.currentThread() );	
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println(" | Destroying Phase..." + " | Executed By : " + Thread.currentThread() );		
	}
	
	

}
