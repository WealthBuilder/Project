package com.wealth.builder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wealth.builder.constants.WealthConstants;
import com.wealth.builder.repository.datastore.UserRepository;
import com.wealth.builder.service.UserService;


public class ReportServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8843293724456358506L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		UserService userService = new UserService(new UserRepository());
		
		try	{
			req.setAttribute(WealthConstants.REQUEST_ATTRIBUTE_TODAY_USERS, 
					userService.getCountUsersRegisteredToday());
			
			req.setAttribute(WealthConstants.REQUEST_ATTRIBUTE_WEEKLY_USERS, 
					userService.getCountUsersRegisteredLastWeek());
			
			req.setAttribute(WealthConstants.REQUEST_ATTRIBUTE_MONTHLY_USERS, 
					userService.getCountUsersRegisteredInMonth());
			
			req.getRequestDispatcher("report.jsp").forward(req, resp);
			
		} catch (Exception e) {
			
			req.setAttribute("ERROR", "OOPS , there was some error while performing your request , "
					+ "please try again later." + e.getCause().getCause().getMessage());
			req.getRequestDispatcher("failed.jsp").forward(req, resp);
			//send mail
			e.printStackTrace();
		}
	
	}

}
