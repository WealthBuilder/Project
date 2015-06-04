package com.wealth.builder.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wealth.builder.repository.datastore.UserRepository;
import com.wealth.builder.repository.intf.IUserRepository;
import com.wealth.builder.vo.User;

public class RegisterUserServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		User user = new User();
		
		user.setFirstName(req.getParameter("FIRST_NAME"));
		user.setLastName(req.getParameter("LAST_NAME"));
		user.setEmaidId(req.getParameter("EMAIL_ID"));
		user.setPassword(req.getParameter("PASSWORD_1"));
		user.setMobileNumber(req.getParameter("MOBILE_NUMBER"));
		
		boolean errorFound = false;
		
		StringBuffer errorMessageBuffer = new StringBuffer();
		
		if(anyFieldMissing(user))	{
			errorMessageBuffer.append("All fields are mandatory , please enter all the details.");
			errorFound = true;
		}
		
		if(!req.getParameter("PASSWORD_1").equals(req.getParameter("PASSWORD_2")))	{
			errorMessageBuffer.append("<br>");
			errorMessageBuffer.append("Passwords do no match , please enter same passwords.");
			errorFound = true;
		}
		
		if(!isEmailValid(user.getEmaidId()))	{
			errorMessageBuffer.append("<br>");
			errorMessageBuffer.append("Email id is not valid , please enter valid email id.");
			errorFound = true;
		}
		
		if(!isPhoneNumberValid(user.getMobileNumber()))	{
			errorMessageBuffer.append("<br>");
			errorMessageBuffer.append("Mobile number is not valid , please enter 10 digit valid phone number.");
			errorFound = true;
		}
		
		if(errorFound)	{
			req.setAttribute("ERRORS", errorMessageBuffer.toString());
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}else	{
			
			try {
				
			IUserRepository userRepository = new UserRepository();
			
			if(userRepository.retrieveUserByEmailId(user.getEmaidId()) != null)	{
				req.setAttribute("ERRORS", "Email - [ " + user.getEmaidId() +" ] is already registered , please enter different emaid id or try forgot password.");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
				return;				
			}
			
			user.setActive(true);
			
			Date today = Calendar.getInstance().getTime();
			user.setCreatedDate(today);
			user.setUpdatedDate(today);
			
			userRepository.saveUser(user);
			
			req.setAttribute("USER", user);
			req.setAttribute("MESSAGE", "Your are now registered with Wealth Book. Please login to view our profit making advices.");
			
			req.getRequestDispatcher("rSuccess.jsp").forward(req, resp);
				
			} catch (Exception e) {
				
				req.setAttribute("ERROR", "OOPS , there was some error while performing your request , please try again later." + e.getMessage());
				req.getRequestDispatcher("failed.jsp").forward(req, resp);
				//send mail
				e.printStackTrace();
			}
		}
		
	}

	private boolean isEmailValid(String emailId) {
		
		if(emailId.length() < 3 || emailId.length() > 30)	{
			return false;
		}
		try {
		      InternetAddress emailAddr = new InternetAddress(emailId);
		      emailAddr.validate();
		} catch (AddressException ex) {
		      return false;
		}
		
		return true;
	}

	private boolean isPhoneNumberValid(String mobileNumber) {
		if(mobileNumber.length() != 10)	{
			return false;
		}
		
		return mobileNumber.matches("^[789][0-9]{9}$");
		
	}

	private boolean anyFieldMissing(User user) {
		
		if(user.getFirstName() == null || "".equals(user.getFirstName().trim()))	{
			return true;
		}
		
		if(user.getLastName() == null || "".equals(user.getLastName().trim()))	{
			return true;
		}
		if(user.getEmaidId() == null || "".equals(user.getEmaidId().trim()))	{
			return true;
		}
		if(user.getMobileNumber() == null || "".equals(user.getMobileNumber().trim()))	{
			return true;
		}
		if(user.getPassword() == null || "".equals(user.getPassword().trim()))	{
			return true;
		}
		return false;
	}
}
