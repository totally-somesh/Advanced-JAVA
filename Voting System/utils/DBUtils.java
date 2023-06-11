package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static Connection CN;
	
	public static Connection openConnection() throws SQLException {
		
		String DBURL = "jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		//DriverManager --> getConnection :- DBURL | Username | Password
		CN = DriverManager.getConnection(DBURL, "root", "JoeRoot123");
		
		System.out.println("-: Connection With DB Successful :-");
		return CN;
	}//end of openConnection method
	
	public static void closeConnection() throws SQLException {
		
		if(CN != null) {
			
			CN.close();			
		}		
	}//end of closeConnection method
}
