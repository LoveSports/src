package edu.neu.lovesports.method;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.neu.lovesports.dao.UserDAO;
import edu.neu.lovesports.entity.User;

public class UserLogin {
	
	User user = null;
	
	public boolean LoginCheck(String username, String password){
		UserDAO check = new UserDAO();
		user = check.readOne(username);
		if(user!=null)
			if(password.equals(user.getPassword())){
				return true;
			}
		return false;
	}
	
}
