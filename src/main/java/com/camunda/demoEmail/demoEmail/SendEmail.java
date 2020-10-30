package com.camunda.demoEmail.demoEmail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class SendEmail implements JavaDelegate {
	public void execute (DelegateExecution execution) throws Exception{
		
			String email= (String) execution.getVariable("email");
			System.out.println("Email preparation to "+email);
			
			Properties properties=new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
			String myAccountEmail="someone@gmail.com";
			String password="";
			
			Session session=Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail,password);
				}
			});
			
			Message message= prepareMessage (session, myAccountEmail, email);
			
			
			try {
				Transport.send(message);
				System.out.println("Message sent successfully");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Message was not send");
			}
			
			
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress (recipient));
			message.setSubject("Uom Bank - Loan Application");
			message.setText("Your application has been created.");
			return message;
			
		} catch (Exception ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE,null, ex);
		}
		return null;
	}
}

