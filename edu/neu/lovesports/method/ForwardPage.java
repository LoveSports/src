package edu.neu.lovesports.method;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardPage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1880667512564710175L;

	public void doGet(HttpServletRequest request,HttpServletResponse response, String addr) 
			throws ServletException,IOException 
			{ 
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(addr);  
			rd.forward(request, response);
			} 
}
