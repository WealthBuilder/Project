package com.wealth.builder.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wealth.builder.constants.WealthConstants;
import com.wealth.builder.repository.datastore.AdviceRepository;
import com.wealth.builder.repository.datastore.UserRepository;
import com.wealth.builder.repository.intf.IAdviceRepository;
import com.wealth.builder.service.MailService;
import com.wealth.builder.vo.Advice;
import com.wealth.builder.vo.User;

public class AdviceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4976118696687880701L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		try {
			if("create".equals(req.getParameter("ACTION")))	{
				Advice advice = new Advice();
				
				advice.setStockName(req.getParameter("STOCK_NAME"));
				advice.setAdvice(req.getParameter("ADVICE"));
				advice.setStatus(req.getParameter("STATUS"));
				
				Date today = Calendar.getInstance().getTime();
				
				advice.setCreatedDate(today);
				advice.setUpdatedDate(today);
				
				advice.setProfile("profile1");
				advice.setProfit("0");
				
				IAdviceRepository adviceRepository = new AdviceRepository();
				
				adviceRepository.saveAdvice(advice);
				
				//send mail to all users
				
				User []allUsers = new UserRepository().retrieveAllUsers();
				
				new MailService().sendMailtoAllUsers(getServletContext(), allUsers, 
						WealthConstants.MAIL_TEMPLATE_NEW_ADVICE, advice.getStockName());
				
				req.getSession().setAttribute("ADVICES",adviceRepository.retrieveAllAdvices());
				
				req.getRequestDispatcher("updateAdvice.jsp").forward(req, resp);
		
			}
			if("view".equals(req.getParameter("ACTION")))	{
				
				IAdviceRepository adviceRepository = new AdviceRepository();
				
				req.getSession().setAttribute("ADVICES",adviceRepository.retrieveAllAdvices());
				
				req.getRequestDispatcher("updateAdvice.jsp").forward(req, resp);
			}
			if("edit".equals(req.getParameter("ACTION")))	{
				
				IAdviceRepository adviceRepository = new AdviceRepository();
				
				req.getSession().setAttribute("CURRENT_ADVICE",
						adviceRepository.retrieveAdviceById(Long.parseLong(req.getParameter("adviceId"))));
				
				req.getRequestDispatcher("editAdvice.jsp").forward(req, resp);
				
			}
			if("update".equals(req.getParameter("ACTION")))	{
				
				Advice advice = (Advice)req.getSession().getAttribute("CURRENT_ADVICE");
				
				advice.setAdvice(req.getParameter("ADVICE"));
				advice.setRemark(req.getParameter("REMARK"));
				advice.setStatus(req.getParameter("STATUS"));
				advice.setProfit(req.getParameter("PROFIT"));
				
				advice.setUpdatedDate(Calendar.getInstance().getTime());
				
				IAdviceRepository adviceRepository = new AdviceRepository();
				
				adviceRepository.saveAdvice(advice);
				
				//send mail to all users
				
				User []allUsers = new UserRepository().retrieveAllUsers();
				
				new MailService().sendMailtoAllUsers(getServletContext(), allUsers, 
						WealthConstants.MAIL_TEMPLATE_UPDATE_ADVICE, advice.getStockName());
				
				req.getSession().setAttribute("ADVICES",adviceRepository.retrieveAllAdvices());
				
				req.getRequestDispatcher("updateAdvice.jsp").forward(req, resp);
				
			}
			if("delete".equals(req.getParameter("ACTION")))	{
				
				IAdviceRepository adviceRepository = new AdviceRepository();
				
				adviceRepository.deleteAdviceById(Long.parseLong(req.getParameter("adviceId")));
				
				req.getSession().setAttribute("ADVICES",adviceRepository.retrieveAllAdvices());
				
				req.getRequestDispatcher("updateAdvice.jsp").forward(req, resp);
				
			}
			
			
		} catch (Exception e) {
			
			req.setAttribute("ERROR", "OOPS , there was some error while performing your request , please try again later." + e.getMessage());
			req.getRequestDispatcher("failed.jsp").forward(req, resp);
		}
	}

}
