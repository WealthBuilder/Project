package com.wealth.builder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wealth.builder.mail.SimpleMailUtil;

public class ContactServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2983732420355735061L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String body ="Message from - " + req.getParameter("NAME") + "<br>" + 
				"Email id - " + req.getParameter("EMAIL") + "<br>" + 
				"Message - " + req.getParameter("MESSAGE");
		
		String subject = req.getParameter("SUBJECT");
		
		try {
			
			SimpleMailUtil.sendEmail("support@wealthbook.co.in", subject, body);
			
			req.setAttribute("MESSAGE", "We have received your message. We will get back to you within 24 hours , till then login and view our profit making advices.");
			req.getRequestDispatcher("rSuccess.jsp").forward(req, resp);
			
		} catch (Exception e) {
			
			req.setAttribute("ERROR", "OOPS , there was some error while performing your request , please try again later." + e.getMessage());
			req.getRequestDispatcher("failed.jsp").forward(req, resp);
			
			e.printStackTrace();
		}
	}

}
