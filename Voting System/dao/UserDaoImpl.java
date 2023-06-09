package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;

import pojo.Users;

public class UserDaoImpl implements UserDao{

	//pst3=cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
	
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
		
	public UserDaoImpl() throws SQLException {
		cn=openConnection();
		pst1=cn.prepareStatement("Select * from users where email=? and password=?");
		pst2=cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("Dao is created");
	}
	@Override
	public Users authenticateUser(String email,String password) throws SQLException{
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next()) {
				//// id | first_name | last_name | email| password | dob| status | role
				return new Users(rst.getInt(1),rst.getString(2),rst.getString(3),email,password,rst.getDate(6),rst.getBoolean(7),rst.getString(8));
			}
		}
		return null;
	}
	
	@Override
	public void registeredUser(Users newuser) throws SQLException{
		
		pst2.setString(1,newuser.getFirstName());
		pst2.setString(2,newuser.getLastName());
		pst2.setString(3,newuser.getEmail());
		pst2.setString(4,newuser.getPassword());
		pst2.setDate(5,newuser.getDob());
		pst2.setBoolean(6,false);
		pst2.setString(7,newuser.getRole());
		
		
        LocalDate TODAY = LocalDate.now();
        
        try{
        Date DOB = newuser.getDob();
        LocalDate DOB1 = DOB.toLocalDate();
        
        int DIFF = Period.between(TODAY, DOB1).getYears();
        
        if(DIFF < 21) {
        	
        throw new ServletException("Below The Age Limit ! "); 
        }
        else {
        	int result = pst2.executeUpdate();
        
        	if(result == 1)
        		System.out.println("User Added Successfully ! ");
        	
        }
        }catch(Exception e) {
        	System.out.println("Our Error : " + e);
        	}       
        
 	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null) {
			pst1.close();
			closeConnection();
			System.out.println("Dao connection is closed");
		}
	}
	
}
