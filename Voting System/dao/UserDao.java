package dao;

import java.sql.SQLException;

import pojo.Users;

public interface UserDao {
	
	Users authenticateUser(String email,String password) throws SQLException;
	
	void registeredUser(Users newuser) throws SQLException;
}
