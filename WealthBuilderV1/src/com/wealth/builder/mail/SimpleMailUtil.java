package com.wealth.builder.mail;

import java.util.Date;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SimpleMailUtil {

	//private static final String SMTP_HOST_NAME = "smtpauth.net4india.com";

	private static final String SMTP_HOST_NAME = "smtpauth.net4india.com";
			
	private static final String SMTP_PORT = "25";

	private static String USER = "wealthbook.IT@gmail.com";
	
	private static String PASSWORD="marathalli123!";
	
	
	/**
	 * This mail sends mail to specified recipients.
	 * 
	 * @param to , The "to" address. 
	 *    The to address can be comma seperated list of valid email Ids.
	 * @param from , The "from" address
	 * @param smtpHost , SMTP host name.
	 * @param subject , subject of the mail.
	 * @param body , The mail body. 
	 * 
	 * @throws Exception , if there is an exception while sending mail. 
	 */
	public static void sendEmail(String to,  
			String subject,String body) throws Exception	{

		// create some properties and get the default Session
		Properties props = new Properties();

		boolean debug = false;

		Authenticator authenticator = new  javax.mail.Authenticator (){
		    public PasswordAuthentication getPasswordAuthentication() {
		        String username = USER;
		        String password = PASSWORD;
		        return new PasswordAuthentication(username, password);
		    }
		};
		
		/*
		props.setProperty("mail.smtp.submitter", USER);
	    props.setProperty("mail.smtp.auth", "true");
	    props.setProperty("mail.smtp.host", SMTP_HOST_NAME);
	    props.setProperty("mail.smtp.port", SMTP_PORT);
	    props.setProperty("mail.smtp.starttls.enable","true");
	    props.setProperty("mail.transport.protocol", "smtp");
	    props.setProperty("mail.debug", "false"); */
	    
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
	    
		Session session = Session.getDefaultInstance(props,authenticator);
		
		session.setDebug(debug);

		
		try {

			InternetAddress[] address = InternetAddress.parse(to);
			for (InternetAddress adrs : address){

				try{
					// create a message
					javax.mail.Message msg = new MimeMessage(session);
	
					//set From address
					//msg.setFrom(new InternetAddress("Jayander"));
	
					//set recipients
					//msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
					
					//set recipient
					msg.setRecipient(javax.mail.Message.RecipientType.TO, adrs);
	
					msg.setFrom(new InternetAddress(USER));
					
					//set the subject
					msg.setSubject(subject);
					msg.setSentDate(new Date());
	
					//set the body
					//msg.setText(body);
	
					msg.setContent(body, "text/html");
					
					//send the mail
					Transport.send(msg);
					
				}catch(javax.mail.MessagingException e){
					e.printStackTrace();
					throw new Exception("Exception while sending mail to [" + to +"], " 
							+"using SMTP Server [" + SMTP_HOST_NAME +"]",e);
				}
			}
		}catch (Exception e) {
			throw new Exception("Exception while sending mail to [" + to +"], " 
					+"using SMTP Server [" + SMTP_HOST_NAME +"]",e);
			
		}
	}
}




