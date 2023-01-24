package com.alimama.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class UserMailing {
	
	String to;
	String firstName;
	String lastName;
	String phone;
	String type;
	
	public UserMailing(String to, String firstName, String lastName, String phone, String type) {
		super();
		this.to = to;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.type = type;

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
		   message.setFrom(new InternetAddress("alimamarestaurant@gmail.com"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		   
		   // create switch for handling request types
		   
		   switch (type) {
		   		case "welcome":
				   // welcome message
				   message.setSubject("Welcome to Alimama");
				   message.setContent(
				              "<h3>Dear " + firstName + ", </h3>"
				              		+ "<img src=\"https://img2.chinadaily.com.cn/images/201812/12/5c107b81a310eff3690a890f.jpeg\" width=\"450\" height=\"300\">"
				              		+ "<p>Your alimama smart restaurant account is created successfully!</p>"
				              		+ "<p>Go through our web and find your favorite food.</p><h4>Good Luck!</h4>",
				             "text/html");
				   break;
		   		case "updated":
		 		   message.setSubject("Account updated!");
				   message.setContent(
				              "<h3>Dear " + firstName + ", </h3>"
				              		+ "<img src=\"https://img2.chinadaily.com.cn/images/201812/12/5c107b81a310eff3690a890f.jpeg\" width=\"450\" height=\"300\">"
				              		+ "<p>Your alimama smart restaurant account is updated successfully!</p>"
				              		+ "	<table>"
				              		+ "		<tr>"
				              		+ "			<td>First Name </td>"
				              		+ "			<td>"+firstName+"</td>"
				              		+ "		</tr>"
				              		+ "		<tr>"
				              		+ "			<td>Last Name </td>"
				              		+ "			<td>"+lastName+"</td>"
				              		+ "		</tr>\r\n"
				              		+ "		<tr>\r\n"
				              		+ "			<td>Phone </td>"
				              		+ "			<td>"+phone+"</td>"
				              		+ "		</tr>"
				              		+ "	</table>"
				              		+ "<p>Go through our web and find your favorite food.</p><h4>Good Luck!</h4>",
				             "text/html");
				   		break;
		   		case "deleted":
		 		   message.setSubject("Account Deleted!");
				   message.setContent(
				              "<h3>Dear " + firstName + ", </h3>"
				              		+ "<img src=\"https://img2.chinadaily.com.cn/images/201812/12/5c107b81a310eff3690a890f.jpeg\" width=\"450\" height=\"300\">"
				              		+ "<p>Your alimama smart restaurant account is deleted successfully!</p>"
				              		+ "<h5>We will miss you!</h5><h4>Good Luck!</h4>",
				             "text/html");
				   break;
				default:
					System.out.println("this is default message from customer mailing");			   
		   }
		   
		   //send message
		    Transport.send(message);
		    
		    System.out.println("message sent successfully");
		 
		  } catch (MessagingException e) {throw new RuntimeException(e);}
	}
	
	public void update() {
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
		   message.setFrom(new InternetAddress("alimamarestaurant@gmail.com"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		   message.setSubject("Account updated!");
		   message.setContent(
		              "<h3>Dear " + firstName + ", </h3>"
		              		+ "<img src=\"https://img2.chinadaily.com.cn/images/201812/12/5c107b81a310eff3690a890f.jpeg\" width=\"450\" height=\"300\">"
		              		+ "<p>Your alimama smart restaurant account is updated successfully!</p>"
		              		+ "	<table>"
		              		+ "		<tr>"
		              		+ "			<td>First Name </td>"
		              		+ "			<td>"+firstName+"</td>"
		              		+ "		</tr>"
		              		+ "		<tr>"
		              		+ "			<td>Last Name </td>"
		              		+ "			<td>"+lastName+"</td>"
		              		+ "		</tr>\r\n"
		              		+ "		<tr>\r\n"
		              		+ "			<td>Phone </td>"
		              		+ "			<td>"+phone+"</td>"
		              		+ "		</tr>"
		              		+ "	</table>"
		              		+ "<p>Go through our web and find your favorite food.</p><h4>Good Luck!</h4>",
		             "text/html");
		   //send message
		    Transport.send(message);
		    System.out.println("message sent successfully");
		 
		  } catch (MessagingException e) {throw new RuntimeException(e);}
	}

	public void delete() {
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
		   message.setFrom(new InternetAddress("alimamarestaurant@gmail.com"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		   message.setSubject("Account Deleted!");
		   message.setContent(
		              "<h3>Dear " + firstName + ", </h3>"
		              		+ "<img src=\"https://img2.chinadaily.com.cn/images/201812/12/5c107b81a310eff3690a890f.jpeg\" width=\"450\" height=\"300\">"
		              		+ "<p>Your alimama smart restaurant account is deleted successfully!</p>"
		              		+ "<h5>We will miss you!</h5><h4>Good Luck!</h4>",
		             "text/html");
		   //send message
		    Transport.send(message);
		    System.out.println("message sent successfully");
		 
		  } catch (MessagingException e) {throw new RuntimeException(e);}
	}
}