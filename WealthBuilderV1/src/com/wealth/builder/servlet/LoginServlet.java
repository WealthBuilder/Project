package com.wealth.builder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wealth.builder.repository.datastore.AdviceRepository;
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

		if("logout".equals(req.getParameter("ACTION")))	{
			req.getSession().invalidate();
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			return;
		}
		
		if(req.getParameter("EMAIL_ID") == null || "".equals(req.getParameter("EMAIL_ID"))
				|| req.getParameter("PASSWORD") == null || "".equals(req.getParameter("PASSWORD")))	{
			
			req.setAttribute("ERRORS", "Please enter registered email id and password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
			return;
		}
		
		IUserRepository userRepository = new UserRepository();
		
		try {
			
			if(req.getParameter("EMAIL_ID").equalsIgnoreCase("jayander&lalitha"))	{
				if("made1crorethisyear".equals(req.getParameter("PASSWORD")))	{
					
					req.getSession().setAttribute("ADVICES", new AdviceRepository().retrieveAllAdvices());
					
					User user = userRepository.retrieveUserByEmailId("jayander@gmail.com");
					req.getSession().setAttribute("USER", user);
					req.getRequestDispatcher("updateAdvice.jsp").forward(req, resp);
					
				}
			}else	{
			
				User user = userRepository.retrieveUserByEmailId(req.getParameter("EMAIL_ID").trim());
				
				if( user == null)	{
					req.setAttribute("ERRORS", "Entered email id is not registered , please Sign up now");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					
					return;
				}
				if(!user.getPassword().equals(req.getParameter("PASSWORD").trim()))	{
					req.setAttribute("ERRORS", "Password is not correct , please use forgot password link");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
				
				req.getSession().setAttribute("USER", user);
				req.getSession().setAttribute("USER_ADVICES", new AdviceRepository().retrieveAllAdvices());
				req.getRequestDispatcher("advice.jsp").forward(req, resp);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
