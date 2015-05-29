package com.wealth.builder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wealth.builder.repository.datastore.UserRepository;
import com.wealth.builder.repository.intf.IUserRepository;
import com.wealth.builder.vo.User;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069611469020635254L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		if(req.getParameter("EMAIL_ID") == null || "".equals(req.getParameter("EMAIL_ID"))
				|| req.getParameter("PASSWORD") == null || "".equals(req.getParameter("PASSWORD")))	{
			
			req.setAttribute("ERRORS", "Please enter registered email id and password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
			return;
		}
		
		IUserRepository userRepository = new UserRepository();
		
		try {
			
			User user = userRepository.retrieveUserByEmailId(req.getParameter("EMAIL_ID").trim());
			
			if( user == null)	{
				req.setAttribute("ERRORS", "Entered email id is not registered , please Sign up now");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			if(!user.getPassword().equals(req.getParameter("PASSWORD").trim()))	{
				req.setAttribute("ERRORS", "Password is not correct , please use forgot password link");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
			req.getSession().setAttribute("USER", user);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
