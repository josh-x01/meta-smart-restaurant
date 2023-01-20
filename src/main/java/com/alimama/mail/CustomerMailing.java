package com.alimama.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class CustomerMailing {
	
	String to;
	String firstName;
	String lastName;
	String phone;

	public void welcome() {
		
	}
	
	
	public CustomerMailing(String to, String name) {
		//Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		            "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication("alimamarestaurant@gmail.com","nymcjphlrkmavqre");//Put your email id and password here
		   }
		  });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("ey.devops@gmail.com"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		   message.setSubject("Welcome to Alimama");
//		   message.setContent("<h3>Dear " + name + ", </h3>", "text/html");
//		   message.setContent("<p>Your alimama smart restaurant account is successfully created!</p>", "text/html");
//		   message.setContent("<p>Go through our web and find your favorite food.</p><h4>Good Luck!</h4>", "text/html");
		   message.setContent(
		              "<h3>Dear " + name + ", </h3>"
		              		+ "<img src=\"https://img2.chinadaily.com.cn/images/201812/12/5c107b81a310eff3690a890f.jpeg\" width=\"450\" height=\"300\">"
		              		+ "<p>Your alimama smart restaurant account is successfully created!</p>"
		              		+ "<p>Go through our web and find your favorite food.</p><h4>Good Luck!</h4>",
		             "text/html");
		   //send message
		    Transport.send(message);
		    System.out.println("message sent successfully");
		 
		  } catch (MessagingException e) {throw new RuntimeException(e);}
	}
}