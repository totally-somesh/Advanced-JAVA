package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilities {
	
	private static Connection cn;
	
	public static Connection openConnection() throws SQLException {
		
		String URL = "jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(URL, "root", "JoeRoot123");
		
		return cn;		
	}// end of openConnection method
	
	public static void closeConnection() throws SQLException {
		
		if(cn != null) {
			
			cn.close();	
		}
	}//end of closeConnection method
}//end of class
