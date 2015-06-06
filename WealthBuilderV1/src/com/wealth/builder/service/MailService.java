package com.wealth.builder.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import com.wealth.builder.vo.User;
import com.wealth.builder.mail.SimpleMailUtil;

public class MailService {
	
	private static final Logger logger =  Logger.getLogger("MailService");
	
	private static final String  MAIL_TEMPLATE_FOLDER =  "/WEB-INF/mail-templates/";
	
	private static final String  SUBJECT_SUFFIX =  "-subject.txt";
	
	private static final String  BODY_SUFFIX =  "-body.html";
	
	
	public void sendMailtoAllUsers(ServletContext servletContext , User[] users , String templateId , String ... values)	{
		
		logger.info("Entering sendMailtoAllUsers - " + templateId);
		
		String subject = this.getSubjectForTemplate(servletContext,templateId);
		
		if(subject == null){
			logger.info("Subject is not configured for Template [" + templateId + "] , hence existing");
			return;
		}
		
		String body = this.getBodyForTemplate(servletContext,templateId);
		
		if(body == null){
			logger.info("Body is not configured for Template [" + templateId + "] , hence existing");
			return;
		}
		
		subject = MessageFormat.format(subject, values);
		
		for(User user : users)	{
			
			body = MessageFormat.format(body, values , user.getFirstName());
			
			try {
				SimpleMailUtil.sendEmail(user.getEmaidId(), subject, body);
				
			} catch (Exception e) {
				
				logger.warning("Error sending mail to - " + user.getEmaidId() 
						+ " - " + e.getCause().getCause().getMessage());
				//e.printStackTrace();
			}
		}
	}
	
	private String getSubjectForTemplate(ServletContext servletContext, String templateId){
		
		logger.info("Entering getSubjectForTemplate - " +  MAIL_TEMPLATE_FOLDER + templateId + SUBJECT_SUFFIX);
		
		InputStream io = servletContext.getResourceAsStream(
				MAIL_TEMPLATE_FOLDER + templateId + SUBJECT_SUFFIX);
		
		if(io == null){
			logger.info("Input Stream is null");
			return null;
		}
		
		String subject = this.getStringFromInputStream(io);
		
		if(subject == null || "".equals(subject))	{
			return null;
		}
		
		logger.info("Returning - " + subject);
		return subject;
		
	}
	
	public void sendForgotPasswordMail(ServletContext servletContext, User user , String templateId) throws Exception	{
		
		logger.info("Entering sendForgotPasswordMail - " + templateId);
		
		String subject = this.getSubjectForTemplate(servletContext, templateId);
		
		if(subject == null){
			logger.info("Subject is not configured for Template [" + templateId + "] , hence existing");
			return;
		}
		
		String body = this.getBodyForTemplate(servletContext, templateId);
		
		if(body == null){
			logger.info("Body is not configured for Template [" + templateId + "] , hence existing");
			return;
		}
		
		body = MessageFormat.format(body, user.getFirstName() , user.getPassword());
		
		SimpleMailUtil.sendEmail(user.getEmaidId(), subject, body);
		
	}
			
	private String getStringFromInputStream(InputStream io) {
		
		StringBuilder out = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(io));
		
		try	{
	         String line;
	         while ((line = reader.readLine()) != null) {
	            out.append(line);
	         }
		} catch (IOException e) {
			e.printStackTrace();
		}finally	{
	        try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return out.toString();
		
	}

	private String getBodyForTemplate(ServletContext servletContext, String templateId){
		
		logger.info("Entering getBodyForTemplate - " +  templateId);
		
		InputStream io = servletContext.getResourceAsStream(
				MAIL_TEMPLATE_FOLDER + templateId + BODY_SUFFIX);
		
		if(io == null){
			logger.info("Input Stream is null");
			return null;
		}
		
		String body = this.getStringFromInputStream(io);
		
		if(body == null || "".equals(body))	{
			return null;
		}
		
		logger.info("Returning - " + body);
		return body;
	}
	
	public static void main(String[] args) {
		//System.out.println(new MailService().getSubjectForTemplate("NewAdvice" , "Infosys"));
		
		System.out.println(MessageFormat.format("Hi {1}", "jayander","kumar"));
	}
	

}
