package com.alimama.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailAlimama {

	public void sendToAlimama(String msg, String from) {
		//Get the session object
		String to = "alimamarestaurant@gmail.com";
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
		   message.setSubject("This is message from " + from);
		   message.setText(msg); 
		   //send message
		    Transport.send(message);
		    System.out.println("message sent successfully");
		  } catch (MessagingException e) {throw new RuntimeException(e);}
	}
}
